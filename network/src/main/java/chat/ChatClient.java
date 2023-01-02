package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import echo.EchoServer;

public class ChatClient {
// 123456
public static final String SERVER_IP = "127.0.0.1";
	
	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		try {
			// 1. 키보드 연결
			scanner = new Scanner(System.in);
			
			// 2. socket 생성
			socket = new Socket();
			
			// 3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			log("connected");
			
			// 4. reader/writer 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);		//true가 반환되면 buffer가 차지 않아도 서버르를 종료해준다
			
			// 5. join 프로토콜
			System.out.print("닉네임>> ");
			String nickname = scanner.nextLine();
			pw.println("join:" + nickname);
			//pw.flush();
			
			// 6. ChatClientThread 시작
			new ChatClientThread(socket).start();
			
			// 7. 키보드 입력 처리
			while(true) {
				System.out.print(">>");
				String input = scanner.nextLine();
				
				if("quit".equals(input) == true) {
					break;
				} else {
					// 9. 메시지 처리
					pw.println("message:" + input);
				}
			}
		} catch(IOException e) {
			log("error:" + e);
		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
//				if (scanner != null) {
//					scanner.close();
//				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	static void log(String message) {
		System.out.println("[ChatClient]" + message);
	}
}

package chat.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import chat.ChatServer;

public class ChatClientApp {
	public static final int C_PORT = 8000;
	public static final String C_IP = "0.0.0.0";
	
	public static void main(String[] args) {
	String name = null;
	Scanner scanner = new Scanner(System.in);

		while (true) {

			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();

			if (!name.isEmpty()) {
				break;
			}
			System.out.println("대화명은 한글자 이상 입력해야 합니다.");
			
		}
		scanner.close();
		try {
			// 1. create socket
			Socket socket = new Socket();
			
			// 2. connect to server
			socket.connect(new InetSocketAddress("127.0.0.1", 5000));
			System.out.println("connected");
			
			// 3. get iostream
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			
			// 4. join protocol 진행
			//String line = br.readLine();
			String line = "JOiN:OK";
			if ("JOIN:OK".equals(line)) {
				new ChatWindow(name).show();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

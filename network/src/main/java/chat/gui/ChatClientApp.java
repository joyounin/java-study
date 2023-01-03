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
import chat.ChatClient;
import chat.ChatServer;

public class ChatClientApp {
	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;
		try {
			while (true) {
				System.out.println("대화명을 입력하세요.");
				System.out.print(">>> ");
				name = scanner.nextLine();

				if (!name.isEmpty()) {
					break;
				}

				System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
			}
			scanner.close();
			// 1. create socket
			socket = new Socket();

			// 2. connect to server
			socket.connect(new InetSocketAddress(ChatClient.SERVER_IP, ChatServer.PORT));
			System.out.println("connected");

			// 3. get iostream
			BufferedReader br = new BufferedReader(
					new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);

			// 4. join protocol 진행
			String data = br.readLine();
			if (!data.isEmpty() == false) {
				pw.println("JOIN:" + name);
			}
			if ("JOIN:OK".equals(data)) {
				System.out.println(name + "님이 입장하였습니다.");
				new ChatWindow(name).show();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

}

package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ChatClientThread extends Thread {
	private Socket socket;

	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			while (true) {
				String message = br.readLine();
				if (message == null) {
					ChatClient.log("closed by server");
					break;
				}
				System.out.println(message);
			}
		} catch (SocketException ex) {
			System.out.println("[client] suddnely closed by client:" + ex);
		} catch (IOException e) {
			ChatClient.log("error:" + e);
		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}

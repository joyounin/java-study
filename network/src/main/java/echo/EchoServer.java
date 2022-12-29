package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
	public static final int PORT = 8000;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket();

			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			log("starts...[port:" + PORT + "]");

			Socket socket = serverSocket.accept();

			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remoteport = inetRemoteSocketAddress.getPort();
			log("connected by client[" + remoteHostAddress + ":" + remoteport + "]");

			try {
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

				while (true) {
					String data = br.readLine();
					if (data == null) {
						log("closed by client");
						break;
					}

					log("received:" + data);
					pw.println(data); // print는 write만 하고 flush를 하지 않아 사용 불가
				}
			} catch (SocketException ex) {
				System.out.println("[server] suddnely closed by server:" + ex);
			} catch (IOException ex) {
				log("error:" + ex);
			} finally {
				try {
					if (socket != null && !socket.isClosed()) {
						socket.close();
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}

		} catch (IOException e) {
			log("error:" + e);
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private static void log(String message) {
		System.out.println("[EchoServer]" + message);
	}

}

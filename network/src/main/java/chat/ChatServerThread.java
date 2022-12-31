package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nickName;
	private Socket socket;
	List<Writer> listWriters;
	
	@Override
	public void run() {
		BufferedReader br;
		PrintWriter pw;
		try {
			// 1. remote host Information
//			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
//		    String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
//		    int remotePort = inetRemoteSocketAddress.getPort();
//		    log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");
		    
			// 2. 스트림 얻기
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
			// 3. 요청 처리
			while (true) {
				String request = br.readLine();
				if (request == null) {
					log("클라이언트로 부터 연결 끊김");
					doQuit(pw);
					break;
				}
				String[] tokens = request.split(":");
				if("join".equals(tokens[0])) {
					doJoin(tokens[1], pw);
				} else if("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if("quit".equals(tokens[0])) {
					doQuit(pw);
				}else {
					ChatServer.log("에러:알수 없는 요청(" + tokens[0] + ")");
				}
			}
			
			
		} catch (SocketException e) {
			log("error:" + e);
		} catch (IOException e) {
			log("error:" + e);
		} finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}

	}

	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	private void doJoin(String nickName, Writer writer) {
		this.nickName = nickName;

		String data = nickName + "님이 참여하였습니다.";
		broadcast(data);
		// wirter pool에 저장
		addWriter(writer);
		
		// ack
		PrintWriter printWriter = (PrintWriter)writer;
		printWriter.println("join:ok");
		printWriter.flush();
	}

	private void addWriter(Writer writer) {
		synchronized(listWriters) {
			listWriters.add(writer);
		}
		
	}
	
	private void broadcast(String data) {
		synchronized(listWriters) {
			for(Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);
				printWriter.flush();
			}
		}
	}

	private void doMessage(String message) {
		broadcast(message);
		String data = nickName + ":" + message;
		
	}

	private void doQuit(Writer writer) {
		removeWriter(writer);

		String data = nickName + "님이 퇴장하였습니다.";
		broadcast(data);
	}

	private void removeWriter(Writer writer) {
		synchronized(listWriters) {
			listWriters.remove(writer);
		}
	}

	private static void log(String message) {
		System.out.println("[ChatServer]" + message);
	}
}

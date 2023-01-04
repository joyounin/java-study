package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import chat.ChatClient;
import chat.ChatClientThread;
import chat.ChatServer;
import chat.ChatServerThread;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	Socket socket = null;
	PrintWriter pw = null;
	BufferedReader br = null;
	
	public ChatWindow(String name, Socket socket) {
		this.frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.socket = socket;
		
	}



	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER) {		//키보드 입력
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
				
			}
		});
		frame.setVisible(true);
		frame.pack();
		
		
		
		try {
			// IOStream 받아오기
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
	        pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true);
	      } catch (IOException e1) {
	         e1.printStackTrace();
	      }
		// ChatClientThread 생성하고 실행
		new ChatClientThread(socket).start();
			
		
	}
		
	private void finish() {
		// quit protocol 구현
		 pw.println("quit");
		// exit java(Application)
		System.exit(0);		// 0은 정상종료
	}
	private void sendMessage() {
		String message = textField.getText();
		System.out.println("메세지 보내는 프로토콜 구현!!:" + message);
		if ("quit".equals(message)) {
	         finish();
	      }
		pw.println("message:" + message);
		textField.setText("");
		textField.requestFocus();
		updateTextArea(message);
		// updateTextArea()
		// ChatClientThread 에서 서버로 부터 받은 메세지가 있다 치고~~~
		
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
	private class ChatClientThread extends Thread{

		private Socket socket;

		public ChatClientThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			BufferedReader br;
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
				while (true) {
					String data = br.readLine();
					updateTextArea(data);
				}
			}catch (IOException e) {
				 System.out.println("error:" + e);
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

}

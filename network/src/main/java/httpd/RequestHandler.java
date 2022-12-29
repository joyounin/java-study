package httpd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler extends Thread {
	private static final String DOCUMENT_ROOT = "./webapp";
	private Socket socket;

	public RequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// get IOStream
			OutputStream outputStream = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			consoleLog("connected from " + inetSocketAddress.getAddress().getHostAddress() + ":"
					+ inetSocketAddress.getPort());
			String request = null;
			while (true) {
				String line = br.readLine();

				// 브라우저가 연결을 끊으면
				if (line == null) {
					break;
				}

				// SimpleHttpServer는 요청의 헤더만 처리한다.
				if ("".equals(line)) {
					break;
				}
//				consoleLog(line); // 브라우저가 뭘 보내는지 확인

				// 요청 헤더의 첫 번째 라인만 읽음
				if (request == null) {
					request = line;
					break;
				}
			}

			// 요청 처리
			// consoleLog(request);
			String[] tokens = request.split(" "); // 3개로 보내주기로 약속 1.메소드 2. URL 3. 프로토콜
			if ("GET".equals(tokens[0])) {
				consoleLog(request);
				reponseStaticResource(outputStream, tokens[1], tokens[2]); // URL 위치 token[1]에 위치해있다.
			} else {
				// methods : POST, PUT, DELETE, HEAD, CONNECT CRUD: c:POST r:GET u:PUT d: DELETE
				// SimpleHttpServer 에서는 무시한다.(400 Bad Resquest) GET으로 오면 200 응답
				// reponse400Error(outputStream, tokens[2]);

			}

			// 예제 응답입니다.
			// 서버 시작과 테스트를 마친 후, 주석 처리 합니다.
			// 브라우저에 보낸다 text에 받는다.
			// outputStream.write("HTTP/1.1 200 OK\r\n".getBytes("UTF-8")); // 인코딩
			// outputStream.write("Content-Type:text/html;
			// charset=utf-8\r\n".getBytes("UTF-8"));
			// outputStream.write("\r\n".getBytes());
			// outputStream.write("<h1>이 페이지가 잘 보이면 실습과제 SimpleHttpServer를 시작할 준비가 된
			// 것입니다.</h1>".getBytes("UTF-8"));
		} catch (Exception ex) {
			consoleLog("error:" + ex);
		} finally {
			// clean-up
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}

			} catch (IOException ex) {
				consoleLog("error:" + ex);
			}
		}
	}

	private void reponseStaticResource (
			OutputStream outputStream,
			String url,
			String protocol) throws IOException {
		// default(welcome) file set
		if("/".equals(url)) {
			url = "/index.html";
		}
		
		File file = new File(DOCUMENT_ROOT + url);
		
		//nio
		byte[] body = Files.readAllBytes(file.toPath());		//한번에 다읽는다
		String contentType = Files.probeContentType(file.toPath());					// os에 파일지정한곳 확인
		
		// 응답
		outputStream.write("HTTP/1.1 200 OK\r\n".getBytes("UTF-8")); 	// 인코딩
		outputStream.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));	//css 적용 이쁘게 만들어준다.
		outputStream.write("\r\n".getBytes());
		outputStream.write(body);
		
	}

	public void consoleLog(String message) {
		System.out.println("[httpd#" + getId() + "] " + message);
	}
}

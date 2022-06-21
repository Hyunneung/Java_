//메세지 송신하는 스레드 클래스 (Client_Ex04_Chating에서 사용)
package networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class SenderThread2 extends Thread {
	private Socket socket;
	private String name;

	SenderThread2(Socket socket, String name) {
		this.socket = socket;
		this.name = name;
	}

	// 키보드로부터 문자열을 입력받아 입력받은 문자열을 클라이언트로 전송한다.
	// "bye"를 입력하면 반복문을 빠져나간다.
	public void run() {
		BufferedReader bw = null;
		PrintWriter pw = null;

		try {
			bw = new BufferedReader(new InputStreamReader(System.in));
			pw = new PrintWriter(this.socket.getOutputStream());

			// 제일 먼저 서버로 이름 송신
			pw.println(name);
			pw.flush();

			// 키보드로 입력된 메시지 서버로 송신
			while (!this.socket.isClosed()) {
				String str = bw.readLine();

				if (str.equalsIgnoreCase("bye"))
					break;

				pw.println(str);
				pw.flush();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				bw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

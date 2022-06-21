// 클라이언트 프로그램
package networking;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client_Ex01 {
	public static void main(String[] args) {
		System.out.println("-여기는 클라이언트입니다.-");

		Socket socket = null;

		try {
			socket = new Socket("127.0.0.1", 9000);

			// 데이터 송신
			OutputStream out = socket.getOutputStream();
			String str = "Hello, Server!";
			out.write(str.getBytes());

			// 데이터 수신
			InputStream in = socket.getInputStream();
			byte[] readBytes = new byte[128];
			in.read(readBytes);
			System.out.println(new String(readBytes));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
				System.out.println("클라이언트 소켓 닫는 중 에러입니다.");
			}
		}
	}
}

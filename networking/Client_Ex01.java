// Ŭ���̾�Ʈ ���α׷�
package networking;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client_Ex01 {
	public static void main(String[] args) {
		System.out.println("-����� Ŭ���̾�Ʈ�Դϴ�.-");

		Socket socket = null;

		try {
			socket = new Socket("127.0.0.1", 9000);

			// ������ �۽�
			OutputStream out = socket.getOutputStream();
			String str = "Hello, Server!";
			out.write(str.getBytes());

			// ������ ����
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
				System.out.println("Ŭ���̾�Ʈ ���� �ݴ� �� �����Դϴ�.");
			}
		}
	}
}

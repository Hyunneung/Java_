// Ŭ���̾�Ʈ ���α׷�
package networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client_Ex02 {
	public static void main(String[] args) {
		System.out.println("-����� Ŭ���̾�Ʈ�Դϴ�.-");
		
		Socket socket = null;

		try {
			socket = new Socket("127.0.0.1", 9001);

			// ������ �۽�
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println("Hello, Server!;");
			pw.flush();

			// ������ ����
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str = br.readLine();
			System.out.println(str);

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
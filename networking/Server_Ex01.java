// ���� ���α׷�
package networking;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Ex01 {

	public static void main(String[] args) {
		System.out.println("-����� �����Դϴ�.-");

		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			serverSocket = new ServerSocket(9000); // ��������
			socket = serverSocket.accept(); // Ŭ���̾�Ʈ ������ ��û ������ ���� �ξ� Ŭ���̾�Ʈ ���� ����

			// ������ ����
			InputStream in = socket.getInputStream(); // ������ ������ �Է� ��Ʈ�� ��ü
			byte[] readBytes = new byte[128];
			in.read(readBytes); // ������ ����
			System.out.println(new String(readBytes)); // ���ŵ� ������ ���

			// ������ �۽�
			OutputStream out = socket.getOutputStream(); // ������ �۽��� ��� ��Ʈ�� ��ü
			String str = "Hello, Client!";
			out.write(str.getBytes()); // ������ �۽�

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
				System.out.println("���� ���� �ݴ� �� �����Դϴ�.");
			} try {
				serverSocket.close(); // serverSocket �ݱ�
			} catch (Exception ignored) { 
				System.out.println("���� ���� �ݴ� �� �����Դϴ�.");
			}
		}
	}
}

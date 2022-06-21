// ���� ���α׷�
package networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Ex02 {

	public static void main(String[] args) {
		System.out.println("-����� �����Դϴ�.-");
		
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			serverSocket = new ServerSocket(9001); // �������� ����
			socket = serverSocket.accept(); // Ŭ���̾�Ʈ ������ ��û ������ ���� �ξ� Ŭ���̾�Ʈ ���� ����

			// ������ ����
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str = br.readLine();
			System.out.println(str);

			// ������ �۽�
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println("Hello, Client!");
			pw.flush();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close(); // socket �ݱ�
			} catch (Exception e) {
				System.out.println("���� ���� �ݴ� �� �����Դϴ�.");
			}
			try {
				serverSocket.close(); // serverSocket �ݱ�
			} catch (Exception ignored) {
				System.out.println("���� ���� �ݴ� �� �����Դϴ�.");
			}
		}
	}
}

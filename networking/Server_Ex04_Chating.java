// 1:�� ä��
// ���� ���α׷�
package networking;

import java.net.ServerSocket;
import java.net.Socket;

public class Server_Ex04_Chating {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			serverSocket = new ServerSocket(9002);

			while (true) { // �ϴ�� ä���� �ο����� �����Ƿ� ���ѹݺ�
				socket = serverSocket.accept(); // Ŭ���̾�Ʈ���� ���� ���� ��ü ����

				// Ŭ���̾�Ʈ �� ������ ������ ����
				Thread thread = new PreClientThread(socket);
				thread.start();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
}
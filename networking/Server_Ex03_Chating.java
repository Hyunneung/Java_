// 1:1 ä�� ���α׷�
// ���� ���α׷�
package networking;

import java.net.ServerSocket;
import java.net.Socket;

public class Server_Ex03_Chating {

	public static void main(String[] args) {
		System.out.println("-����� �����Դϴ�.-");

		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			serverSocket = new ServerSocket(9001); // �������� ����
			socket = serverSocket.accept();
			System.out.println("====== ���� ���� ======");
			System.out.println(socket.getInetAddress().getHostAddress() + "���� �����߽��ϴ�.");
			System.out.println("====================");

			// �޽��� �۽� ������
			Thread senderTh = new SenderThread(socket); 
			senderTh.start();
			
			// �޽��� ���� ������
			Thread receiverTh = new ReceiverThread(socket); 
			receiverTh.start();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				// SenderThread, RecevierThread���� ����ϴ� socket�� �ݾ��ָ� �ȵȴ�!!! - socket.close(); �ȵ�!!!
				// serverSocket�� �ݾ��ֱ�
				serverSocket.close();
			} catch (Exception e) {
				System.out.println("���� ���� �ݴ� �� ���� �߻��߽��ϴ�.");
			}
		}
	}
}
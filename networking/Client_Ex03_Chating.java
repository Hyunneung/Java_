// 1:1 ä�� ���α׷�
// Ŭ���̾�Ʈ ���α׷�
package networking;

import java.net.Socket;

public class Client_Ex03_Chating {

	public static void main(String[] args) {
		System.out.println("-����� Ŭ���̾�Ʈ�Դϴ�.-");

		Socket socket = null;

		try {
			socket = new Socket("127.0.0.1", 9001);

			// �޽��� �۽� ������
			Thread senderTh = new SenderThread(socket);
			senderTh.start();

			// �޽��� ���� ������
			Thread receiverTh = new ReceiverThread(socket);
			receiverTh.start();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// socket ���� ������ �� ��!!!
	}
}
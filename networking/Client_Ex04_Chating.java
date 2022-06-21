// 1:�� ä��
// Ŭ���̾�Ʈ ���α׷�
package networking;

import java.net.Socket;

public class Client_Ex04_Chating {
	public static void main(String[] args) {
		Socket socket = null;

		try {
			socket = new Socket("127.0.0.1", 9002);

			// �޽��� �۽� ������
			Thread senderTh = new SenderThread2(socket, args[0]);
			senderTh.start();

			// �޽��� ���� ������
			Thread receiverTh = new ReceiverThread2(socket);
			receiverTh.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
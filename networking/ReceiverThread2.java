//�޼��� �����ϴ� ������ Ŭ���� (Client_Ex04_Chating���� ���)
package networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

class ReceiverThread2 extends Thread {
	private Socket socket;

	ReceiverThread2(Socket socket) {
		this.socket = socket;
	}

	// Ŭ���̾�Ʈ�κ��� �޽����� ����(reader.readLine())�ؼ� ����ͷ� ����Ѵ�.
	// ������ ������ �������� ���ŵ� ���ڿ��� null�Դϴ�.
	public void run() {
		BufferedReader bis = null;

		try {
			bis = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

			while (!socket.isClosed()) {
				String str = bis.readLine();

				if (str == null) // null�̸� �ݺ����� �����
					break;

				System.out.println(str);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				bis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
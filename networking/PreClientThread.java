// �޼��� �۽� ������ Ŭ���� (Server_Ex04_Chating, Client_Ex04_Chating ���� ���)
package networking;

import java.io.*;

import java.net.Socket;
import java.util.*;

class PreClientThread extends Thread {

	private static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());
	private Socket socket;
	private PrintWriter pw;

	PreClientThread(Socket socket) {
		this.socket = socket; // socket �ʱ�ȭ
		PrintWriter pw = null;
		try { // ������� ���� PrintWriter ��ü �����ؼ� list�� �߰�
			pw = new PrintWriter(this.socket.getOutputStream());
			list.add(pw);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* ���ŵ� ù��° ���ڿ��� ��ȭ������ ����մϴ�. ����� ��� Ŭ���̾�Ʈ���� "#" + name + "���� �����̽��ϴ�" �����ϴ�. 
	 * ���ŵ� �޽��� �տ� ��ȭ���� �ٿ� ��� Ŭ���̾�Ʈ�� �۽��մϴ�.
	 * ���ŵ� �޽����� null�̸� ���ѹݺ� ����ϴ�. Ŭ���̾�Ʈ�� ä�� ������ ��� "#" + name + "���� �����̽��ϴ�" �޽��� �����ϴ�. */
	public void run() {
		String name = null;
		BufferedReader br = null;

		try {
			br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

			name = br.readLine(); // ù��° �Է�: �̸�
			sendAll("[" + name + "]���� �����̽��ϴ�.");

			while (!this.socket.isClosed()) { // �ι�° �Էº��� ä�� ����
				String str = br.readLine();

				if (str == null)
					break;

				sendAll("[" + name + "] " + str);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				list.remove(this.pw);
				sendAll("[" + name + "]���� ä���� �����ϼ̽��ϴ�.");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				br.close();
			} catch (Exception e) {
				System.out.println("���� �ݴ� �߿� ������ �߻��߽��ϴ�.");
			}
		}
	} // run() ������ �޼ҵ� ��

	// ������ ����� ��� Ŭ���̾�Ʈ�� �Ȱ��� �޼��� �۽�
	synchronized private void sendAll(String str) { // �޼��� ������ ���� �ٸ� �͵� �۵� ���ϰ� �Ѵ�.
		for (PrintWriter pw : this.list) {
			pw.println(str);
			pw.flush();
		}
	}
}

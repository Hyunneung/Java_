// �޼��� �۽��ϴ� ������ Ŭ���� (Server_Ex03_Chating , Client_Ex03_Chating ���� ���) 
package networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class SenderThread extends Thread {
	private Socket socket;

	SenderThread(Socket socket) {
		this.socket = socket;
	}

	// Ű����κ��� ���ڿ��� �Է¹޾� �Է¹��� ���ڿ��� Ŭ���̾�Ʈ�� �����Ѵ�.
	// "bye"�� �Է��ϸ� �ݺ����� ����������.
	public void run() {
		BufferedReader bw = null;
		PrintWriter pw = null;

		try {
			bw = new BufferedReader(new InputStreamReader(System.in));
			pw = new PrintWriter(this.socket.getOutputStream());

			while (!this.socket.isClosed()) {
				String str = bw.readLine();

				if (str.equalsIgnoreCase("bye"))
					break;

				pw.println(str);
				pw.flush();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				bw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

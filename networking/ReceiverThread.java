// 메세지 수신하는 스레드 클래스 (Server_Ex03_Chating , Client_Ex03_Chating 에서 사용) 
package networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

class ReceiverThread extends Thread {
	private Socket socket;

	ReceiverThread(Socket socket) {
		this.socket = socket;
	}
	
	// 클라이언트로부터 메시지를 수신(reader.readLine())해서 모니터로 출력한다.
    // 소켓의 연결이 끊어지면 수신된 문자열은 null입니다. 
	public void run() {
		BufferedReader bis = null;

		try {
			bis = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

			while (!socket.isClosed()) {
				String str = bis.readLine();

				if (str == null) // null이면 반복문을 벗어난다    
					break;

				System.out.println("수신>" + str);
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

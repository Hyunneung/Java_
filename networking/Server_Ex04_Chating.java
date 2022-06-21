// 1:多 채팅
// 서버 프로그램
package networking;

import java.net.ServerSocket;
import java.net.Socket;

public class Server_Ex04_Chating {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			serverSocket = new ServerSocket(9002);

			while (true) { // 일대다 채팅의 인원제한 없으므로 무한반복
				socket = serverSocket.accept(); // 클라이언트마다 각자 소켓 객체 생성

				// 클라이언트 올 때마다 스레드 생성
				Thread thread = new PreClientThread(socket);
				thread.start();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
}
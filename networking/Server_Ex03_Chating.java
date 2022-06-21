// 1:1 채팅 프로그램
// 서버 프로그램
package networking;

import java.net.ServerSocket;
import java.net.Socket;

public class Server_Ex03_Chating {

	public static void main(String[] args) {
		System.out.println("-여기는 서버입니다.-");

		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			serverSocket = new ServerSocket(9001); // 서버소켓 생성
			socket = serverSocket.accept();
			System.out.println("====== 접속 정보 ======");
			System.out.println(socket.getInetAddress().getHostAddress() + "에서 접속했습니다.");
			System.out.println("====================");

			// 메시지 송신 스레드
			Thread senderTh = new SenderThread(socket); 
			senderTh.start();
			
			// 메시지 수신 스레드
			Thread receiverTh = new ReceiverThread(socket); 
			receiverTh.start();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				// SenderThread, RecevierThread에서 사용하는 socket은 닫아주면 안된다!!! - socket.close(); 안돼!!!
				// serverSocket만 닫아주기
				serverSocket.close();
			} catch (Exception e) {
				System.out.println("서버 소켓 닫는 중 에러 발생했습니다.");
			}
		}
	}
}
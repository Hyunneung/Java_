// 1:1 채팅 프로그램
// 클라이언트 프로그램
package networking;

import java.net.Socket;

public class Client_Ex03_Chating {

	public static void main(String[] args) {
		System.out.println("-여기는 클라이언트입니다.-");

		Socket socket = null;

		try {
			socket = new Socket("127.0.0.1", 9001);

			// 메시지 송신 스레드
			Thread senderTh = new SenderThread(socket);
			senderTh.start();

			// 메시지 수신 스레드
			Thread receiverTh = new ReceiverThread(socket);
			receiverTh.start();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// socket 절대 닫으면 안 돼!!!
	}
}
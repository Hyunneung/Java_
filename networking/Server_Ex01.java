// 서버 프로그램
package networking;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Ex01 {

	public static void main(String[] args) {
		System.out.println("-여기는 서버입니다.-");

		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			serverSocket = new ServerSocket(9000); // 서버소켓
			socket = serverSocket.accept(); // 클라이언트 소켓의 요청 받으면 연결 맺어 클라이언트 소켓 리턴

			// 데이터 수신
			InputStream in = socket.getInputStream(); // 데이터 수신할 입력 스트림 객체
			byte[] readBytes = new byte[128];
			in.read(readBytes); // 데이터 수신
			System.out.println(new String(readBytes)); // 수신된 데이터 출력

			// 데이터 송신
			OutputStream out = socket.getOutputStream(); // 데이터 송신할 출력 스트림 객체
			String str = "Hello, Client!";
			out.write(str.getBytes()); // 데이터 송신

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
				System.out.println("서버 소켓 닫는 중 에러입니다.");
			} try {
				serverSocket.close(); // serverSocket 닫기
			} catch (Exception ignored) { 
				System.out.println("서버 소켓 닫는 중 에러입니다.");
			}
		}
	}
}

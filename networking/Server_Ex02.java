// 서버 프로그램
package networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Ex02 {

	public static void main(String[] args) {
		System.out.println("-여기는 서버입니다.-");
		
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			serverSocket = new ServerSocket(9001); // 서버소켓 생성
			socket = serverSocket.accept(); // 클라이언트 소켓의 요청 받으면 연결 맺어 클라이언트 소켓 리턴

			// 데이터 수신
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str = br.readLine();
			System.out.println(str);

			// 데이터 송신
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println("Hello, Client!");
			pw.flush();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close(); // socket 닫기
			} catch (Exception e) {
				System.out.println("서버 소켓 닫는 중 에러입니다.");
			}
			try {
				serverSocket.close(); // serverSocket 닫기
			} catch (Exception ignored) {
				System.out.println("서버 소켓 닫는 중 에러입니다.");
			}
		}
	}
}

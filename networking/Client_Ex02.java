// 클라이언트 프로그램
package networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client_Ex02 {
	public static void main(String[] args) {
		System.out.println("-여기는 클라이언트입니다.-");
		
		Socket socket = null;

		try {
			socket = new Socket("127.0.0.1", 9001);

			// 데이터 송신
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println("Hello, Server!;");
			pw.flush();

			// 데이터 수신
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str = br.readLine();
			System.out.println(str);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
				System.out.println("클라이언트 소켓 닫는 중 에러입니다.");
			}
		}
	}
}
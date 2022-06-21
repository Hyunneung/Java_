// 메세지 송신 스레드 클래스 (Server_Ex04_Chating, Client_Ex04_Chating 에서 사용)
package networking;

import java.io.*;

import java.net.Socket;
import java.util.*;

class PreClientThread extends Thread {

	private static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());
	private Socket socket;
	private PrintWriter pw;

	PreClientThread(Socket socket) {
		this.socket = socket; // socket 초기화
		PrintWriter pw = null;
		try { // 사람마다 각각 PrintWriter 객체 생성해서 list에 추가
			pw = new PrintWriter(this.socket.getOutputStream());
			list.add(pw);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* 수신된 첫번째 문자열을 대화명으로 사용합니다. 연결된 모든 클라이언트에게 "#" + name + "님이 들어오셨습니다" 보냅니다. 
	 * 수신된 메시지 앞에 대화명을 붙여 모든 클라이언트로 송신합니다.
	 * 수신된 메시지가 null이면 무한반복 벗어납니다. 클라이언트가 채팅 종료한 경우 "#" + name + "님이 나가셨습니다" 메시지 보냅니다. */
	public void run() {
		String name = null;
		BufferedReader br = null;

		try {
			br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

			name = br.readLine(); // 첫번째 입력: 이름
			sendAll("[" + name + "]님이 들어오셨습니다.");

			while (!this.socket.isClosed()) { // 두번째 입력부터 채팅 시작
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
				sendAll("[" + name + "]님이 채팅을 종료하셨습니다.");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				br.close();
			} catch (Exception e) {
				System.out.println("소켓 닫는 중에 에러가 발생했습니다.");
			}
		}
	} // run() 스레드 메소드 끝

	// 서버에 연결된 모든 클라이언트로 똑같은 메세지 송신
	synchronized private void sendAll(String str) { // 메세지 보내는 동안 다른 것들 작동 못하게 한다.
		for (PrintWriter pw : this.list) {
			pw.println(str);
			pw.flush();
		}
	}
}

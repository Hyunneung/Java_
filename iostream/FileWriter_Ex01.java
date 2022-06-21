package iostream;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_Ex01 {

	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("test_output.txt");

			char[] charr = { '시', '간', '에', ' ', '뒤', '쳐', '지', '거', '나', ' ', '같', '이', ' ', '뛰', '거', '나' };
			fw.write(charr); // 파일 작성

		} catch (IOException ie) {
			System.out.println("파일로 출력할 수 없습니다.");
		} finally {
			try {
				fw.close();
			} catch (Exception e) {
				System.out.println("파일을 닫는 중 오류가 생겼습니다.");
			}
		}
	}
}

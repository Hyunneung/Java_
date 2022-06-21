package iostream;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_Ex01_2 {

	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("test_output.txt", true); // 기존 파일에 내용 추가 (기본은 false로 생략하면 덮어써진다)

			char[] charr = { '선', '택', '하', '라', '면', ' ', '난', ' ', '신', '발', '을', ' ', '신', '을', '거', '야' };

			fw.write("\n");
			for (int i = 0; i < charr.length; i++) {
				fw.write(charr[i]); // 파일 작성
			}

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

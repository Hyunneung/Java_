// 구구단 출력한 파일 생성
package iostream;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_Ex02 {

	public static void main(String[] args) {
		FileWriter fw = null;

		try {
			fw = new FileWriter("src/filereader_filewriter/gugudan.txt");

			// 구구단
			for (int i = 2; i <= 9; i++) {
				fw.write("[" + i + "단]\t");
			}

			fw.write("\n");

			for (int i = 1; i <= 9; i++) {
				for (int j = 2; j <= 9; j++) {
					fw.write(j + "*" + i + "=" + i * j + "\t");
				}
				fw.write("\n");
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

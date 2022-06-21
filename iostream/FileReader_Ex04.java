// FileWriter_Ex02에서 작성한 gugudan.txt 파일 열기
package iostream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_Ex04 {

	public static void main(String[] args) {
		FileReader fr = null;

		try {
			fr = new FileReader("src/filereader_filewriter/gugudan.txt");
			while (true) {
				int data = fr.read(); // 파일 읽기
				if (data == -1)
					break;

				System.out.print((char) data);
			}
		} catch (FileNotFoundException fnfe) {
			System.err.println("파일이 존재하지 않습니다.");
		} catch (IOException io) {
			System.err.println("파일을 열 수 없습니다.");
		} finally {
			try {
				fr.close();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
}

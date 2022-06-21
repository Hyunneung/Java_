package iostream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_Ex03 {

	public static void main(String[] args) {
		FileReader rd = null;
		char[] charr = new char[64];
		try {
			rd = new FileReader("C:\\Users\\LG\\eclipse-workspace\\Git_yet\\거위의 꿈.txt");

			while (true) {
				int data = rd.read(charr); // 파일 읽어온다
				if (data == -1)
					break;

				System.out.println(new String(charr, 0, data));

			} // while 끝
		} catch (FileNotFoundException fnfe) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException ie) {
			System.out.println("파일을 읽을 수 없습니다.");
		} finally {
			try {
				rd.close(); // 파일 닫는다
			} catch (IOException ie) {
				System.out.println("파일을 읽을 수 없습니다.2");
			}
		}
	}
}

package iostream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_Ex01 {
	public static void main(String[] args) {
		FileReader reader = null;

		try {
			reader = new FileReader("poem.txt");
			while (true) {
				int data = reader.read(); // 파일을 연다
				if (data == -1)
					break;
				char ch = (char) data; // 숫자로 읽어진 data 값을 char에 담는다
				System.out.print(ch);
			} // while 끝

		} catch (FileNotFoundException fnfe) { // FileReader 예외 처리
			System.err.println("FileNotFoundException 에러 - " + fnfe.getMessage());
		} catch (IOException ie) { // read() 메소드 예외 처리
			System.err.println("IOException 에러 - " + ie.getMessage());
		} finally {
			try {
				reader.close(); // FileReader 닫는거는 에러에 관계 없이 항상 닫혀야 하므로 finally 블록에 작성
			} catch (IOException ie) { // close() 메소드 예외 처리
				System.err.println("IOException 에러 - " + ie.getMessage());
			}
		} // finally 끝
	}
}

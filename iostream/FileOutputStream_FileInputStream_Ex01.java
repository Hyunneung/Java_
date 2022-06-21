package iostream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_FileInputStream_Ex01 {
	public static void main(String[] args) {

		FileOutputStream fos = null;
		FileInputStream fis = null;

		try {
			// 파일 쓰기
			fos = new FileOutputStream("test_output.txt");
			byte[] outarr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

			for (int i = 0; i < outarr.length; i++) { // 파일에 byte 타입 데이터를 반복해서 쓴다.
				fos.write(outarr[i]);
			}
			fos.close();

			// 파일 읽기
			fis = new FileInputStream("test_output.txt");

			while (true) {
				byte[] inarr = new byte[64];
				int num = fis.read(inarr);
				if (num == -1)
					break;
				System.out.println("출력시작");

				for (int i = 0; i < num; i++) {
					System.out.printf("%02d \n", inarr[i]);
				}

			} // while 끝
			fis.close();
		} catch (FileNotFoundException f) { // FileOutputStream 예외 처리
			System.err.println(f.getMessage());
		} catch (IOException e) { // write() 메소드 예외 처리
			System.err.println(e.getMessage());

		}
	}
}

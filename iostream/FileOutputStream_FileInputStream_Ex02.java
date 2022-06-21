// 다른 폴더에 파일 복사
package iostream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_FileInputStream_Ex02 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			// 파일 열기
			fis = new FileInputStream("C:\\test1\\test.jpg");
			fos = new FileOutputStream("C:\\test2\\test_copy.jpg");
			
			byte[] arr = new byte[1024];
			
			while (true) {
				int num = fis.read(arr); // 파일 열기
				if (num == -1)
					break;
				fos.write(arr); // 파일 복사
			}

		} catch (FileNotFoundException f) {
			System.err.println(f.getMessage());
		} catch (IOException i) {
			System.err.println(i.getMessage());
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException i) {
				System.err.println(i.getMessage());
			}
		}
	}
}

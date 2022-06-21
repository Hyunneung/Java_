// 폴더 생성하고, 그 폴더에 파일 복사하기
package iostream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class File_Ex04 {
	public static void main(String[] args) {
		File dir = new File("C:\\test");

		if (!dir.exists()) {
			if (dir.mkdir()) {
				System.out.println(dir.getPath() + " 폴더가 생성되었습니다.");
			} else {
				System.out.println(dir.getPath() + " 폴더가 생성에 실패했습니다.");
			}
		} else {
			System.out.println("이미 존재하는 폴더입니다.");
		}

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
			// 파일 읽기
			bis = new BufferedInputStream(new FileInputStream("C:\\test1\\test.jpg"));
			bos = new BufferedOutputStream(new FileOutputStream("C:\\test\\test.jpg"));

			byte[] readBytes = new byte[1024];
			int num;
			while ((num = bis.read(readBytes)) != -1) {
				bos.write(readBytes);
			}
			System.out.println("파일 복사가 완료되었습니다.");

		} catch (FileNotFoundException f) {
			System.err.println("FileNotFoundException 에러 발생");
		} catch (IOException i) {
			System.err.println("IOException 에러 발생");
		} finally {
			try {
				bis.close();
				bos.close();
			} catch (IOException i) {
				System.err.println("IOException 에러 발생");
			}
		}
	}
}

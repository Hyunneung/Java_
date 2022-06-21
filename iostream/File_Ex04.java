// ���� �����ϰ�, �� ������ ���� �����ϱ�
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
				System.out.println(dir.getPath() + " ������ �����Ǿ����ϴ�.");
			} else {
				System.out.println(dir.getPath() + " ������ ������ �����߽��ϴ�.");
			}
		} else {
			System.out.println("�̹� �����ϴ� �����Դϴ�.");
		}

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
			// ���� �б�
			bis = new BufferedInputStream(new FileInputStream("C:\\test1\\test.jpg"));
			bos = new BufferedOutputStream(new FileOutputStream("C:\\test\\test.jpg"));

			byte[] readBytes = new byte[1024];
			int num;
			while ((num = bis.read(readBytes)) != -1) {
				bos.write(readBytes);
			}
			System.out.println("���� ���簡 �Ϸ�Ǿ����ϴ�.");

		} catch (FileNotFoundException f) {
			System.err.println("FileNotFoundException ���� �߻�");
		} catch (IOException i) {
			System.err.println("IOException ���� �߻�");
		} finally {
			try {
				bis.close();
				bos.close();
			} catch (IOException i) {
				System.err.println("IOException ���� �߻�");
			}
		}
	}
}

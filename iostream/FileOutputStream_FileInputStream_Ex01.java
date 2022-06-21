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
			// ���� ����
			fos = new FileOutputStream("test_output.txt");
			byte[] outarr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

			for (int i = 0; i < outarr.length; i++) { // ���Ͽ� byte Ÿ�� �����͸� �ݺ��ؼ� ����.
				fos.write(outarr[i]);
			}
			fos.close();

			// ���� �б�
			fis = new FileInputStream("test_output.txt");

			while (true) {
				byte[] inarr = new byte[64];
				int num = fis.read(inarr);
				if (num == -1)
					break;
				System.out.println("��½���");

				for (int i = 0; i < num; i++) {
					System.out.printf("%02d \n", inarr[i]);
				}

			} // while ��
			fis.close();
		} catch (FileNotFoundException f) { // FileOutputStream ���� ó��
			System.err.println(f.getMessage());
		} catch (IOException e) { // write() �޼ҵ� ���� ó��
			System.err.println(e.getMessage());

		}
	}
}

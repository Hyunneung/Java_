// FileWriter_Ex02���� �ۼ��� gugudan.txt ���� ����
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
				int data = fr.read(); // ���� �б�
				if (data == -1)
					break;

				System.out.print((char) data);
			}
		} catch (FileNotFoundException fnfe) {
			System.err.println("������ �������� �ʽ��ϴ�.");
		} catch (IOException io) {
			System.err.println("������ �� �� �����ϴ�.");
		} finally {
			try {
				fr.close();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
}

package iostream;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_Ex01 {

	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("test_output.txt");

			char[] charr = { '��', '��', '��', ' ', '��', '��', '��', '��', '��', ' ', '��', '��', ' ', '��', '��', '��' };
			fw.write(charr); // ���� �ۼ�

		} catch (IOException ie) {
			System.out.println("���Ϸ� ����� �� �����ϴ�.");
		} finally {
			try {
				fw.close();
			} catch (Exception e) {
				System.out.println("������ �ݴ� �� ������ ������ϴ�.");
			}
		}
	}
}

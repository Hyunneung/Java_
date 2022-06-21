package iostream;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_Ex01_2 {

	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("test_output.txt", true); // ���� ���Ͽ� ���� �߰� (�⺻�� false�� �����ϸ� ���������)

			char[] charr = { '��', '��', '��', '��', '��', ' ', '��', ' ', '��', '��', '��', ' ', '��', '��', '��', '��' };

			fw.write("\n");
			for (int i = 0; i < charr.length; i++) {
				fw.write(charr[i]); // ���� �ۼ�
			}

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

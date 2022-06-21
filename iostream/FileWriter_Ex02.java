// ������ ����� ���� ����
package iostream;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_Ex02 {

	public static void main(String[] args) {
		FileWriter fw = null;

		try {
			fw = new FileWriter("src/filereader_filewriter/gugudan.txt");

			// ������
			for (int i = 2; i <= 9; i++) {
				fw.write("[" + i + "��]\t");
			}

			fw.write("\n");

			for (int i = 1; i <= 9; i++) {
				for (int j = 2; j <= 9; j++) {
					fw.write(j + "*" + i + "=" + i * j + "\t");
				}
				fw.write("\n");
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

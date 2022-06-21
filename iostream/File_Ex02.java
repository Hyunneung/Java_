// ���� ���� / ���� ���� / ���� ���� �߰�
package iostream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class File_Ex02 {

	public static void main(String[] args) {
		// ���� ����
		File dir = new File("C:\\imsi");

		if (!dir.exists()) { // C:\\imsi ���� ���
			if (dir.mkdir()) {
				System.out.println("���� ���� ���� �̸�: " + dir.getPath());
			} else {
				System.out.println("���� ������ �����߽��ϴ�.");
			}
		} else { // C:\\imsi �ִ� ���
			System.out.println("�̹� �ִ� ���� �̸�: " + dir.getPath());
		}

		// ���� ����
		File file = new File("C:\\imsi\\alwaysawake.txt");

		if (file.exists()) {
			System.out.println(file.getPath() + "��ο� " + file.getName() + " ������ �ֽ��ϴ�.");
		} else {
			try {
				if (file.createNewFile()) {
					System.out.println(file.getPath() + "�� ���ο� ������ �����Ǿ����ϴ�.");
				}
			} catch (IOException ioe) {
				System.err.println("IOException�� �߻��߽��ϴ�.");
			} // try-catch ��

		}

		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter("C:\\imsi\\alwaysawake.txt", true));
			char[] aa = { '��', '��', '��', ' ', '��', '��', '��', '��', '��', ' ', '��', '��', ' ', '��', '��', '��', ' ', '��', '��',
					'��', '��', '��', ' ', '��', ' ', '��', '��', '��', ' ', '��', '��', '��', '��' };

			bw.write(aa);
			System.out.println("������ ����Ǿ����ϴ�.");
		} catch (IOException ioe) {
			System.err.println("IOException�� �߻��߽��ϴ�.");
		} finally {
			try {
				bw.close();
			} catch (IOException ioe) {
				System.err.println("IOException�� �߻��߽��ϴ�.");
			}
		}
	}
}

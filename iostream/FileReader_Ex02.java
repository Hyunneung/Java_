package iostream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_Ex02 {

	public static void main(String[] args) {
		FileReader rd = null;
		char[] charr = new char[64];
		try {
			rd = new FileReader("C:\\Users\\LG\\eclipse-workspace\\Git_yet\\������ ��.txt");

			while (true) {
				int data = rd.read(charr); // ���� �о�´�
				if (data == -1)
					break;

				for (char c : charr) {
					System.out.print(c);
				}

			} // while ��
		} catch (FileNotFoundException fnfe) {
			System.out.println("������ �������� �ʽ��ϴ�.");
		} catch (IOException ie) {
			System.out.println("������ ���� �� �����ϴ�.");
		} finally {
			try {
				rd.close(); // ���� �ݴ´�
			} catch (Exception ie) {
				System.out.println("������ ���� �� �����ϴ�.2");
			}
		}
	}
}

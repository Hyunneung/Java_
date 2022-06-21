package iostream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_Ex01 {
	public static void main(String[] args) {
		FileReader reader = null;

		try {
			reader = new FileReader("poem.txt");
			while (true) {
				int data = reader.read(); // ������ ����
				if (data == -1)
					break;
				char ch = (char) data; // ���ڷ� �о��� data ���� char�� ��´�
				System.out.print(ch);
			} // while ��

		} catch (FileNotFoundException fnfe) { // FileReader ���� ó��
			System.err.println("FileNotFoundException ���� - " + fnfe.getMessage());
		} catch (IOException ie) { // read() �޼ҵ� ���� ó��
			System.err.println("IOException ���� - " + ie.getMessage());
		} finally {
			try {
				reader.close(); // FileReader �ݴ°Ŵ� ������ ���� ���� �׻� ������ �ϹǷ� finally ��Ͽ� �ۼ�
			} catch (IOException ie) { // close() �޼ҵ� ���� ó��
				System.err.println("IOException ���� - " + ie.getMessage());
			}
		} // finally ��
	}
}

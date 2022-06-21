package iostream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter_Ex01 {

	public static void main(String[] args) {
		String message = "�� �ӿ��� ��� �ٿ� � �ῡ�� �Ʊ� �ٷ�";

		BufferedWriter bw = null;

		try {
			// ���� ����
			bw = new BufferedWriter(new FileWriter("src/bufferd/alwaysawake.dat"));
			bw.write(message);

		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		} finally {
			try {
				bw.close();
			} catch (IOException ioe) {
				System.err.println(ioe.getMessage());
			}
		}
	}
}

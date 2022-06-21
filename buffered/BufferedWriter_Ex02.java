package buffered;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter_Ex02 {

	public static void main(String[] args) {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			fw = new FileWriter("src/buffered/starinspace");
			bw = new BufferedWriter(fw,5);

			char[] arr = {'��', '��', ' ', '��', '��', '��', ' ', '��', '��', '��', ' ', '��', '��', '��', '��', '��', '\n', 
					'��', '��', ' ', '��', '��', ' ', '��', '��', ' ', '��', '��', '��', '��', ' ', '��', '��', ' ', '��', ' ', '��', '��', '��'};

			for (int i = 0; i < arr.length; i++) {
				bw.write(arr[i]);
			}

			bw.flush();

		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		} finally {
			try {
				// ���� ��Ʈ�� ���� �ݱ�
				bw.close();
				fw.close();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
}

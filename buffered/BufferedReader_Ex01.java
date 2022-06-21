package buffered;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReader_Ex01 {

	public static void main(String[] args) {
		BufferedReader br = null;

		try {
			// 파일 읽기
			br = new BufferedReader(new FileReader("src/bufferd/alwaysawake.dat"));
			char[] arr = new char[128];
			int num = 0;
			while ((num = br.read(arr)) != -1) {
				System.out.println(new String(arr, 0, num));
			}

		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		} finally {
			try {
				br.close();
			} catch (IOException ioe) {
				System.err.println(ioe.getMessage());
			}
		}
	}

}

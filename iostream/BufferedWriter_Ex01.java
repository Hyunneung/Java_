package iostream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter_Ex01 {

	public static void main(String[] args) {
		String message = "꿈 속에서 헤맬 바엔 어서 잠에서 꺠길 바래";

		BufferedWriter bw = null;

		try {
			// 파일 쓰기
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

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

			char[] arr = {'무', '한', ' ', '우', '주', '에', ' ', '순', '간', '의', ' ', '빛', '일', '지', '라', '도', '\n', 
					'달', '을', ' ', '향', '해', ' ', '쏴', '라', ' ', '빗', '나', '가', '도', ' ', '별', '이', ' ', '될', ' ', '것', '이', '다'};

			for (int i = 0; i < arr.length; i++) {
				bw.write(arr[i]);
			}

			bw.flush();

		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		} finally {
			try {
				// 보조 스트림 먼저 닫기
				bw.close();
				fw.close();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
}

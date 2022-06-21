// 폴더 생성 / 파일 생성 / 파일 내용 추가
package iostream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class File_Ex02 {

	public static void main(String[] args) {
		// 폴더 생성
		File dir = new File("C:\\imsi");

		if (!dir.exists()) { // C:\\imsi 없는 경우
			if (dir.mkdir()) {
				System.out.println("새로 만든 폴더 이름: " + dir.getPath());
			} else {
				System.out.println("폴더 생성에 실패했습니다.");
			}
		} else { // C:\\imsi 있는 경우
			System.out.println("이미 있는 폴더 이름: " + dir.getPath());
		}

		// 파일 생성
		File file = new File("C:\\imsi\\alwaysawake.txt");

		if (file.exists()) {
			System.out.println(file.getPath() + "경로에 " + file.getName() + " 파일이 있습니다.");
		} else {
			try {
				if (file.createNewFile()) {
					System.out.println(file.getPath() + "에 새로운 파일이 생성되었습니다.");
				}
			} catch (IOException ioe) {
				System.err.println("IOException이 발생했습니다.");
			} // try-catch 끝

		}

		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter("C:\\imsi\\alwaysawake.txt", true));
			char[] aa = { '시', '간', '에', ' ', '뒤', '쳐', '지', '거', '나', ' ', '같', '이', ' ', '뛰', '거', '나', ' ', '선', '택',
					'하', '라', '면', ' ', '난', ' ', '신', '발', '을', ' ', '신', '을', '거', '야' };

			bw.write(aa);
			System.out.println("파일이 변경되었습니다.");
		} catch (IOException ioe) {
			System.err.println("IOException이 발생했습니다.");
		} finally {
			try {
				bw.close();
			} catch (IOException ioe) {
				System.err.println("IOException이 발생했습니다.");
			}
		}
	}
}

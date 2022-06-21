// 현재 디렉토리 확인
package iostream;

import java.io.File;
import java.util.GregorianCalendar;

public class File_Ex01 {

	public static void main(String[] args) {
		File file = new File("."); // 현재 디렉토리
		File[] arrf = file.listFiles(); // 서브 디렉토리와 파일 목록 가져오기

		for (int i = 0; i < arrf.length; i++) {
			String name = arrf[i].getName();

			if (arrf[i].isFile())
				System.out.printf("%-25s %7d \t", name, arrf[i].length());
			else
				System.out.printf("%-25s	   <DIR> \t", name);

			GregorianCalendar gc = new GregorianCalendar();
			gc.setTimeInMillis(arrf[i].lastModified()); // 최종 수정일시

			System.out.printf("\tF \tT \n", gc, gc);
		}
	}
}

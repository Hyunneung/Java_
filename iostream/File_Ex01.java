// ���� ���丮 Ȯ��
package iostream;

import java.io.File;
import java.util.GregorianCalendar;

public class File_Ex01 {

	public static void main(String[] args) {
		File file = new File("."); // ���� ���丮
		File[] arrf = file.listFiles(); // ���� ���丮�� ���� ��� ��������

		for (int i = 0; i < arrf.length; i++) {
			String name = arrf[i].getName();

			if (arrf[i].isFile())
				System.out.printf("%-25s %7d \t", name, arrf[i].length());
			else
				System.out.printf("%-25s	   <DIR> \t", name);

			GregorianCalendar gc = new GregorianCalendar();
			gc.setTimeInMillis(arrf[i].lastModified()); // ���� �����Ͻ�

			System.out.printf("\tF \tT \n", gc, gc);
		}
	}
}

// ���� ����
package iostream;

import java.io.File;

public class File_Ex03 {
	public static void main(String[] args) {
		File dir = new File("C:\\imsi");

		if (dir.exists()) {
			if (dir.delete()) {  
				System.out.println(dir.getPath() + " ���丮�� �����߽��ϴ�.");
			} else { // dir.delete() == false // ������ ������� ������ false�� ��ȯ�� �������� ���Ѵ�
				System.out.println(dir.getPath() + " ���丮�� �������� ���߽��ϴ�.");
			}
		} else {
			System.out.println(dir.getPath() + "�� �����ϰ��� �ϴ� ������ �����ϴ�.");
		}
	}
}

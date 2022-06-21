// 폴더 삭제
package iostream;

import java.io.File;

public class File_Ex03 {
	public static void main(String[] args) {
		File dir = new File("C:\\imsi");

		if (dir.exists()) {
			if (dir.delete()) {  
				System.out.println(dir.getPath() + " 디렉토리를 삭제했습니다.");
			} else { // dir.delete() == false // 폴더가 비어있지 않으면 false를 반환해 삭제하지 못한다
				System.out.println(dir.getPath() + " 디렉토리를 삭제하지 못했습니다.");
			}
		} else {
			System.out.println(dir.getPath() + "에 삭제하고자 하는 폴더가 없습니다.");
		}
	}
}

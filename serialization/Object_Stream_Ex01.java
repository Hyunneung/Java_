// GregorianCalendar 객체를 직렬화 하는 프로그램
package serialization;

import java.io.*;
import java.util.*;

public class Object_Stream_Ex01 {

	public static void main(String[] args) {

		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		try {
			// 직렬화
			oos = new ObjectOutputStream(new FileOutputStream("calendar.dat"));
			oos.writeObject(new GregorianCalendar(2022, 06, 01));
			oos.writeObject(new GregorianCalendar(2022, 06, 02));
			oos.writeObject(new GregorianCalendar(2022, 06, 03));

			// 역직렬화
			ois = new ObjectInputStream(new FileInputStream("calendar.dat"));
			while (true) {
				GregorianCalendar calendar = (GregorianCalendar) ois.readObject();
				int year = calendar.get(Calendar.YEAR);
				int month = calendar.get(Calendar.MONTH);
				int date = calendar.get(Calendar.DATE);

				System.out.printf("%d년 %d월 %d일 입니다.\n", year, month, date);
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.getMessage();
		} catch (ClassNotFoundException cnfe) {
			cnfe.getMessage();
		} catch (EOFException eofe) { // 파일로부터 더 이상 읽을 객체가 없을 때 발생하는 예외 처리
			System.out.println("끝.");
		} catch (IOException ioe) {
			System.err.println("파일로 출력할 수 없습니다.");
		} finally {
			try {
				oos.close();
			} catch (Exception e) {
				System.err.println("파일을 닫는 중 오류가 발생했습니다.");
			}
		}
	}
}

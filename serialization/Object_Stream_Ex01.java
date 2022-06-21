// GregorianCalendar ��ü�� ����ȭ �ϴ� ���α׷�
package serialization;

import java.io.*;
import java.util.*;

public class Object_Stream_Ex01 {

	public static void main(String[] args) {

		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		try {
			// ����ȭ
			oos = new ObjectOutputStream(new FileOutputStream("calendar.dat"));
			oos.writeObject(new GregorianCalendar(2022, 06, 01));
			oos.writeObject(new GregorianCalendar(2022, 06, 02));
			oos.writeObject(new GregorianCalendar(2022, 06, 03));

			// ������ȭ
			ois = new ObjectInputStream(new FileInputStream("calendar.dat"));
			while (true) {
				GregorianCalendar calendar = (GregorianCalendar) ois.readObject();
				int year = calendar.get(Calendar.YEAR);
				int month = calendar.get(Calendar.MONTH);
				int date = calendar.get(Calendar.DATE);

				System.out.printf("%d�� %d�� %d�� �Դϴ�.\n", year, month, date);
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.getMessage();
		} catch (ClassNotFoundException cnfe) {
			cnfe.getMessage();
		} catch (EOFException eofe) { // ���Ϸκ��� �� �̻� ���� ��ü�� ���� �� �߻��ϴ� ���� ó��
			System.out.println("��.");
		} catch (IOException ioe) {
			System.err.println("���Ϸ� ����� �� �����ϴ�.");
		} finally {
			try {
				oos.close();
			} catch (Exception e) {
				System.err.println("������ �ݴ� �� ������ �߻��߽��ϴ�.");
			}
		}
	}
}

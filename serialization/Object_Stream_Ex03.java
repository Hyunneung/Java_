package serialization;

import java.io.*;

public class Object_Stream_Ex03 {

	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		try {
			// ����ȭ
			oos = new ObjectOutputStream(new FileOutputStream("src/serialization/fanclub.dat"));
			oos.writeObject(new fanClub("����", "blackpink1", "7�� �Ű�", "�Ű��� ��ǥ�մϴ�."));
			oos.writeObject(new fanClub("����", "blackpink2", "8�� �Ű�", "�ȳ��ϼ���."));

			// ������ȭ
			ois = new ObjectInputStream(new FileInputStream("src/serialization/fanclub.dat"));

			while (true) {
				fanClub fc = (fanClub) ois.readObject();
				System.out.println(fc);

			}
		} catch (EOFException e) {
		} catch (FileNotFoundException f) {
			System.err.println(f.getMessage());
		} catch (IOException i) {
			System.err.println(i.getMessage());
		} catch (ClassNotFoundException c) {
			System.err.println(c.getMessage());
		} finally {
			try {
				oos.close();
				ois.close();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
}

class fanClub implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private static int itemNum = 0; // �Խù� ��
	private String writer; // �۾���
	private transient String passwd; // �н�����
	private String title; // ����
	private String content; // ����

	fanClub(String writer, String passwd, String title, String content) {
		this.writer = writer;
		this.passwd = passwd;
		this.title = title;
		this.content = content;
		fanClub.itemNum++;
	}

	// ���� ���� �޼���
	public void modifyContent(String content, String passwd) {
		if (!passwd.equals(this.passwd))
			return;
		else
			this.content = content;
	}

	public String toString() {
		return "��ü�Խù��� ��: " + fanClub.itemNum + "\n�۾���: " + this.writer + "\n�н�����: " + this.passwd + "\n����: "
				+ this.title + "\n����: " + this.content + "\n";
	}
}

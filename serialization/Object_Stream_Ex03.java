package serialization;

import java.io.*;

public class Object_Stream_Ex03 {

	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		try {
			// 직렬화
			oos = new ObjectOutputStream(new FileOutputStream("src/serialization/fanclub.dat"));
			oos.writeObject(new fanClub("제니", "blackpink1", "7월 신곡", "신곡을 발표합니다."));
			oos.writeObject(new fanClub("로제", "blackpink2", "8월 신곡", "안녕하세요."));

			// 역직렬화
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
	private static int itemNum = 0; // 게시물 수
	private String writer; // 글쓴이
	private transient String passwd; // 패스워드
	private String title; // 제목
	private String content; // 내용

	fanClub(String writer, String passwd, String title, String content) {
		this.writer = writer;
		this.passwd = passwd;
		this.title = title;
		this.content = content;
		fanClub.itemNum++;
	}

	// 내용 수정 메서드
	public void modifyContent(String content, String passwd) {
		if (!passwd.equals(this.passwd))
			return;
		else
			this.content = content;
	}

	public String toString() {
		return "전체게시물의 수: " + fanClub.itemNum + "\n글쓴이: " + this.writer + "\n패스워드: " + this.passwd + "\n제목: "
				+ this.title + "\n내용: " + this.content + "\n";
	}
}

package serialization;

import java.io.*;

public class Object_Stream_Ex02 {

	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		try {
			// 직렬화
			oos = new ObjectOutputStream(new FileOutputStream("GoodsStock.dat"));
			oos.writeObject(new GoodsStock("1234", 120));
			oos.writeObject(new GoodsStock("5678", 50));

			// 역직렬화
			ois = new ObjectInputStream(new FileInputStream("GoodsStock.dat"));

			while (true) {
				GoodsStock gs = (GoodsStock) ois.readObject();
				System.out.println(gs);
			} // while 끝

		} catch (FileNotFoundException f) {
			System.err.println(f.getMessage());
		} catch (EOFException eofe) { // 파일로부터 더 이상 읽을 객체가 없을 때 발생하는 예외 처리
			System.out.println("끝.");
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

//재고 정보 클래스
class GoodsStock implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private String code;
	private int num;

	GoodsStock(String code, int num) {
		this.code = code;
		this.num = num;
	}

	void addStock(int num) {
		this.num += num;
	}

	int subtractStock(int num) throws Exception {
		if (this.num < num)
			throw new Exception("재고가 부족합니다.");
		this.num -= num;
		return num;
	}

	public String toString() {
		return "상품코드:" + code + "\t상품수량:" + num;
	}
}
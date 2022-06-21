package serialization;

import java.io.*;

public class Object_Stream_Ex02 {

	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		try {
			// ����ȭ
			oos = new ObjectOutputStream(new FileOutputStream("GoodsStock.dat"));
			oos.writeObject(new GoodsStock("1234", 120));
			oos.writeObject(new GoodsStock("5678", 50));

			// ������ȭ
			ois = new ObjectInputStream(new FileInputStream("GoodsStock.dat"));

			while (true) {
				GoodsStock gs = (GoodsStock) ois.readObject();
				System.out.println(gs);
			} // while ��

		} catch (FileNotFoundException f) {
			System.err.println(f.getMessage());
		} catch (EOFException eofe) { // ���Ϸκ��� �� �̻� ���� ��ü�� ���� �� �߻��ϴ� ���� ó��
			System.out.println("��.");
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

//��� ���� Ŭ����
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
			throw new Exception("��� �����մϴ�.");
		this.num -= num;
		return num;
	}

	public String toString() {
		return "��ǰ�ڵ�:" + code + "\t��ǰ����:" + num;
	}
}
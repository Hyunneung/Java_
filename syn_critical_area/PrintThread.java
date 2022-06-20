package syn_critical_area;

class PrintThread extends Thread {
	private SharedArea sharedarea;

	PrintThread(SharedArea sharedarea) {
		this.sharedarea = sharedarea;
	}

	public void run() {
		for (int cnt = 0; cnt < 3; cnt++) {

			// synchronized Ű���带 ����� ������� ���� �κ��� ����ȭ ���̶�� �Ѵ�

			// ����ȭ ����
			synchronized (sharedarea) {
				// �ʵ��� ���� account1�� account2�� �ܾ��� ���Ѵ�
				int sum = sharedarea.getTotal();
				System.out.println("���� �ܾ� �հ�: " + sum);
			} // ����ȭ ��

			try {
				Thread.sleep(1); // 1/1000��
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());

			} // catch ��
		} // for ��
	} // run ��
} // class ��

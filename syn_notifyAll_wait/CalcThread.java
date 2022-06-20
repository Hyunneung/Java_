// ���� ��� Ŭ����
package syn_notifyAll_wait;

class CalcThread extends Thread {
	private SharedArea sharedarea;

	CalcThread(SharedArea sharedarea) {
		this.sharedarea = sharedarea;
	}

	@Override
	public void run() {
		double total = 0.0;

		// ���� ��� �κ�
		for (int cnt = 1; cnt < 1000000000; cnt += 2) {
			if (cnt / 2 % 2 == 0) {
				total += 1.0 / cnt;
			} else {
				total -= 1.0 / cnt;
			}

			this.sharedarea.setResult(total * 4); // ��� ����� ���� ������ ����
			sharedarea.setReady(true); // ���� ��� ��! SharedArea ��ü�� isReady �ʵ� ���� true�� ����
		} // for�� ��

		// ����ȭ ��
		synchronized (sharedarea) {
			sharedarea.notifyAll(); // �ٸ� ������� ��ȣ ������ �޼ҵ�
		}
	} // run ��
}
package syn_notify_wait;

class PrintThread extends Thread {
	private SharedArea sharedarea;

	PrintThread(SharedArea sharedarea) {
		this.sharedarea = sharedarea;
	}

	@Override
	public void run() {
		try {
			synchronized (sharedarea) {
				sharedarea.wait(); // CalcThread���� ���� ��� ������ ��ȣ �޴´�.
				System.out.println("���� ������ ������ = " + this.sharedarea.getResult());
			}
		} catch (InterruptedException ie) {
			System.err.println(ie.getMessage());
		} // try-catch ��
	} // run ��
}

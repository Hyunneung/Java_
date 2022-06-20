package syn_critical_area;

class TransferThread extends Thread {
	private SharedArea sharedarea;

	TransferThread(SharedArea sharedarea) {
		this.sharedarea = sharedarea;
	}

	public void run() {
		for (int cnt = 0; cnt < 12; cnt++) {
			// ����ȭ ����
			synchronized (sharedarea) {
				sharedarea.transfer();
			} // ����ȭ ��
		} // for ��
	} // run ��
} // class ��
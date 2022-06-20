package syn_notifyAll_wait;

class LuxuryPrintThread extends Thread {
	private SharedArea sharedarea;

	LuxuryPrintThread(SharedArea sharedarea) {
		this.sharedarea = sharedarea;
	}

	public void run() {
		if (sharedarea.isReady() != true) {
			synchronized (sharedarea) {
				try {
					sharedarea.wait();
				} catch (InterruptedException ie) {
					System.err.println(ie.getMessage());
				} // try-catch ��
			} // ����ȭ ��
		} // if ��
		System.out.println("*** �� = " + sharedarea.getResult() + "***");
	} // run ��
}

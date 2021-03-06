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
				} // try-catch 끝
			} // 동기화 끝
		} // if 끝
		System.out.println("*** π = " + sharedarea.getResult() + "***");
	} // run 끝
}

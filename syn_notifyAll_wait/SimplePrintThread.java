package syn_notifyAll_wait;

class SimplePrintThread extends Thread {
	private SharedArea sharedarea;

	SimplePrintThread(SharedArea sharedarea) {
		this.sharedarea = sharedarea;
	}
	
	public void run() {
		if (sharedarea.isReady() != true) {
			synchronized (sharedarea) {
				try {
					sharedarea.wait();
				} catch (InterruptedException ie) {
					System.err.println(ie.getMessage());
				} // try-catch 场
			} // 悼扁拳 场
		} // if 场
		System.out.printf("SimplePrintThread : %.2f %n", sharedarea.getResult()); 
	} // run 场
}

	


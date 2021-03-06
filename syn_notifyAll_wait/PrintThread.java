package syn_notifyAll_wait;

class PrintThread extends Thread {
	private SharedArea sharedarea;

	PrintThread(SharedArea sharedarea) {
		this.sharedarea = sharedarea;
	}

	@Override
	public void run() {
		try {
			synchronized (sharedarea) {
				sharedarea.wait(); // CalcThread에서 파이 계산 끝나면 신호 받는다.
				System.out.println("PrintThread : " + this.sharedarea.getResult());
			}
		} catch (InterruptedException ie) {
			System.err.println(ie.getMessage());
		} // try-catch 끝
	} // run 끝
}

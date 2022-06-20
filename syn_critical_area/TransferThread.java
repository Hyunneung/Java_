package syn_critical_area;

class TransferThread extends Thread {
	private SharedArea sharedarea;

	TransferThread(SharedArea sharedarea) {
		this.sharedarea = sharedarea;
	}

	public void run() {
		for (int cnt = 0; cnt < 12; cnt++) {
			// 동기화 시작
			synchronized (sharedarea) {
				sharedarea.transfer();
			} // 동기화 끝
		} // for 끝
	} // run 끝
} // class 끝
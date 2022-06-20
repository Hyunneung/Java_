package syn_critical_area;

class PrintThread extends Thread {
	private SharedArea sharedarea;

	PrintThread(SharedArea sharedarea) {
		this.sharedarea = sharedarea;
	}

	public void run() {
		for (int cnt = 0; cnt < 3; cnt++) {

			// synchronized 키워드를 사용해 블록으로 묶는 부분을 동기화 블럭이라고 한다

			// 동기화 시작
			synchronized (sharedarea) {
				// 필드의 계좌 account1과 account2의 잔액을 더한다
				int sum = sharedarea.getTotal();
				System.out.println("계좌 잔액 합계: " + sum);
			} // 동기화 끝

			try {
				Thread.sleep(1); // 1/1000초
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());

			} // catch 끝
		} // for 끝
	} // run 끝
} // class 끝

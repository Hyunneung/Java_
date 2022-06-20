// 파이 계산 클래스
package syn_notifyAll_wait;

class CalcThread extends Thread {
	private SharedArea sharedarea;

	CalcThread(SharedArea sharedarea) {
		this.sharedarea = sharedarea;
	}

	@Override
	public void run() {
		double total = 0.0;

		// 파이 계산 부분
		for (int cnt = 1; cnt < 1000000000; cnt += 2) {
			if (cnt / 2 % 2 == 0) {
				total += 1.0 / cnt;
			} else {
				total -= 1.0 / cnt;
			}

			this.sharedarea.setResult(total * 4); // 계산 결과를 공유 영역에 저장
			sharedarea.setReady(true); // 파이 계산 끝! SharedArea 객체의 isReady 필드 값을 true로 설정
		} // for문 끝

		// 동기화 블럭
		synchronized (sharedarea) {
			sharedarea.notifyAll(); // 다른 스레드로 신호 보내는 메소드
		}
	} // run 끝
}
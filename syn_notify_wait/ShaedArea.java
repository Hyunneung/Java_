package syn_notify_wait;

class SharedArea {
	private double result;

	SharedArea() {
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	// ���������Ͱ� ���������� ���θ� ǥ���ϴ� �ʵ� - ����Ʈ�� (false)
	private boolean isReady;

	// getter
	public boolean isReady() {
		return isReady;
	}

	// setter
	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}
}
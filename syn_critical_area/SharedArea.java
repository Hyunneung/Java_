package syn_critical_area;

class SharedArea {
	private Account account1; // 이몽룡의 계좌
	private Account account2; // 성춘향의 계좌

	SharedArea(Account account1, Account account2) {
		this.account1 = account1;
		this.account2 = account2;
	}

	// account1의 getter, setter
	public Account getAccount1() {
		return account1;
	}

	public void setAccount1(Account account1) {
		this.account1 = account1;
	}

	// account2의 getter, setter
	public Account getAccount2() {
		return account2;
	}

	public void setAccount2(Account account2) {
		this.account2 = account2;
	}

	void transfer() { // 계좌이체
		synchronized (this) { // 동기화 할 객체는 자기 자신
			this.account1.withdraw(1000000);
			this.account2.deposit(1000000);
		}
	}

	int getTotal() { // 잔액 합계
		synchronized (this) { // 동기화 할 객체는 자기 자신
			return this.account1.getBalance() + this.account2.getBalance();
		}
	}

}
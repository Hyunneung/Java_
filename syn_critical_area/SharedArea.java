package syn_critical_area;

class SharedArea {
	private Account account1; // �̸����� ����
	private Account account2; // �������� ����

	SharedArea(Account account1, Account account2) {
		this.account1 = account1;
		this.account2 = account2;
	}

	// account1�� getter, setter
	public Account getAccount1() {
		return account1;
	}

	public void setAccount1(Account account1) {
		this.account1 = account1;
	}

	// account2�� getter, setter
	public Account getAccount2() {
		return account2;
	}

	public void setAccount2(Account account2) {
		this.account2 = account2;
	}

	void transfer() { // ������ü
		synchronized (this) { // ����ȭ �� ��ü�� �ڱ� �ڽ�
			this.account1.withdraw(1000000);
			this.account2.deposit(1000000);
		}
	}

	int getTotal() { // �ܾ� �հ�
		synchronized (this) { // ����ȭ �� ��ü�� �ڱ� �ڽ�
			return this.account1.getBalance() + this.account2.getBalance();
		}
	}

}
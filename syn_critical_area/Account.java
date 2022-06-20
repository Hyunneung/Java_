package syn_critical_area;

class Account {
	private String accountNo; // ���¹�ȣ
	private String ownerName; // ������ �̸�
	private int balance; // �ܾ�

	Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	// accountNo�� getter, setter
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	// ownerName�� getter, setter
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	// balance�� getter, setter
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	// �����Ѵ�
	void deposit(int amount) {
		balance += amount;
	}

	// �����Ѵ�
	int withdraw(int amount) {
		if (balance < amount) {
			return 0;
		}
		balance -= amount;
		return amount;
	}
}
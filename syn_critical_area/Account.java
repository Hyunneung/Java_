package syn_critical_area;

class Account {
	private String accountNo; // 계좌번호
	private String ownerName; // 예금주 이름
	private int balance; // 잔액

	Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	// accountNo의 getter, setter
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	// ownerName의 getter, setter
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	// balance의 getter, setter
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	// 예금한다
	void deposit(int amount) {
		balance += amount;
	}

	// 인출한다
	int withdraw(int amount) {
		if (balance < amount) {
			return 0;
		}
		balance -= amount;
		return amount;
	}
}
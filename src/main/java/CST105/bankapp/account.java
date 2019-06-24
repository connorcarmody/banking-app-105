package CST105.bankapp;

public abstract class account {

	private double balance = 5000;
	private String account = "117";
	// private String pin = "4347";
	private String time;

	public account(double balance, String account, String time) {
		super();
		this.balance = balance;
		this.account = account;
		this.time = time;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public double doWithdraw(double amount) {
		return amount;
	}

	public double doDeposit(double amount) {
		return amount;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}

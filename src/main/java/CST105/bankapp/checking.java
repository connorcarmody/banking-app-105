package CST105.bankapp;

public class checking extends account {

	private double overdraft = 0;

	public double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(double overdraft) {

		this.overdraft = overdraft;
	}

	public double doWithdraw(double amount) {
		return amount;

	}

	// constructor
	public checking(double balance, String account, String time, double overdraft) {
		super(balance, account, time);
		this.overdraft = overdraft;

	}
}

package CST105.bankapp;

public class savings extends account {

	private double serviceFee = 0;
	private double interestRate = 0;
	private double minBalance = 0;

//	public savings(int i, String string) {
	// TODO Auto-generated constructor stub
//	}
	public double getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(double serviceFee) {
		this.serviceFee = serviceFee;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
		// minBalance = 5000;
	}

	// constructor
	public savings(double balance, String account, String time, double serviceFee, double interestRate,
			double minBalance) {
		super(balance, account, time);
		this.serviceFee = serviceFee;
		this.interestRate = interestRate;
		this.minBalance = minBalance;
	}

}

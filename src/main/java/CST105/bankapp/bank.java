package CST105.bankapp;
/**
 * @author connorcarmody
 *
 */

import java.text.*;
import java.util.*;
import java.time.*;

public class bank {

	private static String name = "Grand Canyon Unionversity Bank";
	static DecimalFormat money = new DecimalFormat("$###,###,###,###,###,###,###,###,###,###.00");
	static Date date = new Date();
	static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {
		// System.out.println(dateFormat.format(date));
		checking checking = new checking(5000.00, "79795", dateFormat.format(date), 45.00);

		// System.out.println(checking.getAccount());
		savings saving = new savings(5000.00, "90210", dateFormat.format(date), 25.00, .06, 200);
		bank bank = new bank();

		bank.displayMenu(checking, saving);
	}

	private void displayMenu(checking checking, savings saving) throws InterruptedException {
		int option;
		Customer customer = new Customer("William", "Billiams");

		do {
			System.out.println("===================================");
			System.out.println(" MAIN MENU");
			System.out.println(" " + this.name.toUpperCase());
			System.out.println("What's up, " + customer.getFirstName() + " " + customer.getLastName() + "!");
			System.out.println(" ");
			Greetings.greetings();
			System.out.println("===================================");
			System.out.println("Pick an option: ");
			System.out.println("---------------------");
			System.out.println(" 1: : Deposit to Checking");
			System.out.println(" 2: : Deposit to Savings");
			System.out.println(" 3: : Write a Check");
			System.out.println(" 4: : Withdraw from Savings");
			System.out.println(" 5: : Get balance");
			System.out.println(" 6: : Close month");
			System.out.println("---------------------");
			System.out.println(" 9: : Exit");
			option = scan.nextInt();
			this.actionMenu(option, checking, saving);
		} while (option != 9);
	}

	private void actionMenu(int option, checking checking, savings saving) throws InterruptedException {
		switch (option) {
		case 1:
			bank.displayDepositChecking(checking);
			break;
		case 2:
			bank.displayDepositSavings(saving);
			break;
		case 3:
			bank.displayWithdrawChecking(checking);
			break;
		case 4:
			bank.displayWithdrawSavings(saving);

			break;

		case 5:
			bank.displayBalanceScreen(checking, saving);

			break;
		case 6:
			bank.doEndMonth(checking, saving);
			break;
		case 9:
			bank.displayExitScreen();
			break;
		default:
			System.out.println("Whoops! Invalid option");
		}

	}

	private static void doEndMonth(checking checking, savings saving) {
		System.out.println("--------------------------------\n");
		double interest = (saving.getInterestRate() / 12) * saving.getBalance();
		double serviceFee = saving.getServiceFee();
		double newBalance = interest + saving.getBalance();
		double minBalance = saving.getMinBalance();
		System.out.println("End Month!\n");
		System.out.println("For savings account " + saving.getAccount() + ".");
		System.out.println("--------------------------------\n");

		System.out.println("You earned " + money.format(interest) + " in interest this month! Your new balance is "
				+ money.format(newBalance) + "\n\n");
		if (newBalance < minBalance) {
			System.out.println("Your account is below the minimum balance of $200.00. You will be charged "
					+ "a $25.00 Service Fee.");
			newBalance = newBalance - serviceFee;
			System.out.println("Your new balance is " + money.format(newBalance));

		}
		saving.setBalance(newBalance);
		System.out.println("Enter any number to return to the main menu.");

		// this is the first example of it i think, but any time this code is exposed to
		// blank field at the end of a method
		// it will go back to the display menu automatically because the display menu is
		// on a while loop of !=9
		scan.next();

	}

	private static void displayExitScreen() {
		System.out.println("Thanks for stopping by " + name + ". Goodbye!");

	}

	private static void displayBalanceScreen(checking checking, savings saving) {

		System.out.println("Your current balance for: \n Checking Account " + checking.getAccount() + " is "
				+ money.format(checking.getBalance()) + "\n\n");

		System.out.println("Your current balance for: \n Savings Account " + saving.getAccount() + " is "
				+ money.format(saving.getBalance()) + "\n\n");

		System.out.println("Enter any number to return to the main menu.");
		scan.next();
	}

	private static void displayWithdrawSavings(savings saving) throws InterruptedException {
		// System.out.println("Withdraw savings reached");
		System.out.println("--------------------------------\n");
		System.out.println("Withdraw Savings!");
		System.out.println("--From Savings account " + saving.getAccount() + ".--");
		System.out.println("--------------------------------\n");
		System.out.println("Your current balance is: " + money.format(saving.getBalance()) + ". \n" + saving.getTime());
		System.out.println("How much will you withdraw? Enter below.");
		double withdrawl = scan.nextDouble();
		System.out.println("Withdraw " + money.format(withdrawl) + "? Certainly! One moment.");
		System.out.println("...");
		Thread.sleep(600);

		// checking that they arent trying to overdraft savings account. we don't do
		// that here
		double newBalance = saving.getBalance() - withdrawl;
		if (newBalance < 0) {
			System.out.println("Whoops! You don't have that much money. Try again.\n\n\n\n\n");
			System.out.println("Enter any number to return to the main menu.");
			scan.next();

		} else {
			// if all is good, print and set new balance
			System.out.println("\t...");
			Thread.sleep(600);
			saving.setBalance(newBalance);
			System.out.println("\t\t...");
			Thread.sleep(600);
			System.out.println("OK! You have withdawn " + money.format(withdrawl) + ". \n\nYour new balance is: "
					+ money.format(newBalance) + "!\n\n\n");
			System.out.println("Enter any number to return to the main menu.");
			scan.next();

		}

	}

	private static void displayWithdrawChecking(checking checking) throws InterruptedException {
		// System.out.println("Withdraw checking reached");

		System.out.println("--------------------------------\n");
		System.out.println("Let's write a check!");
		System.out.println("--From Checking account " + checking.getAccount() + ".--");
		System.out.println("--------------------------------\n");
		System.out.println(
				"Your current balance is: " + money.format(checking.getBalance()) + ". \n" + checking.getTime());

		// if their account is negative, we can't help them till its positive
		if (checking.getBalance() < -1500) {
			System.out.println("...");
			Thread.sleep(800);
			System.out.println("\t...");
			Thread.sleep(800);
			System.out.println("\t\t...");
			Thread.sleep(800);
			System.out.println("Sorry. We have your current balance as: " + money.format(checking.getBalance()) + ".");
			System.out.println(
					"We will not be able to write checks for you until your balance is restored to the overdraft limit.");
			System.out.println("Enter any number to return to the main menu.");
			scan.next();
		}

		else {
			System.out.println("How much will you write it for? Enter below. Enter \"0\" to return to the main menu.");

			double withdrawl = scan.nextDouble();

			if (withdrawl == 0) {
				// this blank code, because its followed by an else statement, represents the
				// entirety of the method
				// when the condition withdrawl == 0. so it loops back to display menu
				// automatically!
			}

			// joke for negative numbers
			else if (withdrawl < 0) {
				System.out.println("Sorry, you can't magically add money to your account that way.\n");
				System.out.println("Enter any number to return to the main menu.");
				scan.next();

			}
			// joke for large numbers
			else if (withdrawl > 66750 + checking.getBalance()) {
				System.out.println(
						"We don't have that much money in the entire building! You're gonna have to pull out less.");
				System.out.println("Enter any number to go back and withdraw a more responsible amount.");
				scan.next();

			}

			else {
				System.out.println("Write a check for " + money.format(withdrawl) + "? Certainly! One moment.\n");
				System.out.println("...");
				Thread.sleep(500);
				// create an updated balance for use with setter later
				double newBalance = checking.getBalance() - withdrawl;

				// overdraft limit of 1500
				if (newBalance <= -1500) {
					System.out.println("\t...");
					Thread.sleep(600);
					System.out.println("\t\t...\n");
					Thread.sleep(800);
					System.out.println(
							"Sorry, but your overdraft limit is $1500.00. We cannot complete this transaction.");
					System.out.println("Enter any number to return to the main menu.");
					scan.next();

				}
				// if able to overdraft, accesses this overdraft menu.
				else if (newBalance < 0) {
					System.out.println("\t...");
					Thread.sleep(600);
					System.out.println("\t\t...\n");
					Thread.sleep(800);
					System.out.println("This amount will overdraft you. That's okay, but we will charge you a "
							+ "fee of: " + money.format(checking.getOverdraft()) + "\nfor each week your account"
							+ " is overdrafted, and every time you overdraft after. You cannot write a check\n"
							+ "if your balance is below the overdraft limit of $1,500.");

					System.out.println("Press 1 to confirm. Press any number to return to the main menu.");

					// boolean wentToCatch;
					// do {

					// try {
					// wentToCatch= false;

					int choice = Integer.parseInt(scan.next());
					// }catch (InputMismatchException e)
					// {
					// scan.next();
					// wentToCatch = true;
					// System.out.println("Please enter a number!");
					// }

					// while (wentToCatch = true)

					if (choice == 1) {
						newBalance = newBalance - checking.getOverdraft();
						checking.setBalance(newBalance);
						System.out.println("Confirmed! Your new balance is " + money.format(newBalance) + "!");
						System.out.println("Enter any number to return to the main menu.");
						scan.next();
					}}

					else {
						// set and show new balance
						System.out.println("\t...");
						Thread.sleep(600);
						checking.setBalance(newBalance);
						System.out.println("\t\t...");
						Thread.sleep(800);
						System.out.println("OK! You have withdawn " + money.format(withdrawl)
								+ ". \n\nYour new balance is: " + money.format(newBalance) + "!\n\n\n\n\n");
						System.out.println("Enter any number to return to the main menu.");
						scan.next();
						// System.out.println(saving.getBalance());
					}
				}
			}
		}

	

	private static void displayDepositSavings(savings saving) throws InterruptedException {
		// System.out.println("Deposit savings reached");
		System.out.println("--------------------------------");
		System.out.println("Let's make a deposit!");
		System.out.println("To savings account " + saving.getAccount() + ".");
		System.out.println("--------------------------------\n");
		System.out.println(saving.getTime());
		System.out.println("Your current balance is: " + money.format(saving.getBalance()) + ".\n\n");
		System.out.println("How much would you like to deposit?");
		double deposit = scan.nextDouble();
		System.out.println("\n" + money.format(deposit) + "... All right. Let's get that set up!");
		double newBalance = deposit + saving.getBalance();
		System.out.println("...");
		Thread.sleep(600);
		System.out.println("\t...");
		Thread.sleep(600);
		System.out.println("\t\t...\n");
		Thread.sleep(600);
		saving.setBalance(newBalance);
		System.out.println("Sweet! Your new balance is " + money.format(newBalance) + "! Happy Saving!");
		System.out.println("Enter any number to return to the main menu.");
		scan.next();

	}

	private static void displayDepositChecking(checking checking) throws InterruptedException {
		// System.out.println("Deposit checking reached");
		System.out.println("--------------------------------");
		System.out.println("Let's make a deposit!");
		System.out.println("From Checking account " + checking.getAccount() + ".");
		System.out.println("--------------------------------\n");
		System.out.println(checking.getTime());
		System.out.println("Your current balance is: " + money.format(checking.getBalance()) + ".\n\n");
		System.out.println("How much would you like to deposit?");
		double deposit = scan.nextDouble();
		System.out.println("\n" + money.format(deposit) + "... gotcha. We can work with that.");
		double newBalance = deposit + checking.getBalance();
		System.out.println("...");
		Thread.sleep(600);
		System.out.println("\t...");
		Thread.sleep(600);
		System.out.println("\t\t...\n");
		Thread.sleep(600);
		checking.setBalance(newBalance);
		System.out.println("Got it! Your new balance is " + money.format(newBalance) + "! Happy Checking!");
		System.out.println("Enter any number to return to the main menu.");
		scan.next();

	}

}

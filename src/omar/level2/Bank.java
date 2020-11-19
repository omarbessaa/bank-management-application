package omar.level2;

import java.util.ArrayList;

public class Bank {

	private ArrayList<BankAccount> accounts = new ArrayList<>();

	/**
	 * helper method to search for if an account exists in the bank
	 * 
	 * @param accountNumber
	 * @return the index of the if account in the accounts array if it's exist or
	 *        -999 if not
	 */
	private int search(String accountNumber) {
		for (int i = 0; i < this.accounts.size(); i++) {
			if (accounts.get(i).getAccountNumber().equals(accountNumber))
				return i;
		}

		return -999;
	}

	/**
	 * method that tell the total number of accounts in the bank
	 * 
	 * @return the size of the accounts array
	 */
	public int getTotal() {
		return this.accounts.size();
	}

	/**
	 * method to get a a bank account from the accounts array
	 * 
	 * @param accountNumber
	 * @return the bank account or null if it doesn't exist
	 */
	public BankAccount getItem(String accountNumber) {
		int i = search(accountNumber);
		if (i == -999)
			return null;
		else
			return this.accounts.get(i);
	}

	/**
	 * This method receives two strings representing the account number and name
	 * respectively, and adds an account with these details to the list of accounts.
	 * 
	 * @param accountNumber
	 * @param accountName
	 * 
	 * @return If an account with this number already exists, the new account will
	 *         not be added and the method will return a value of false. However, if
	 *         the operation has been completed successfully a value of true is
	 *         returned.
	 */
	public boolean addAccount(String accountNumber, String accountName) {
		if (search(accountNumber) == -999) {
			BankAccount bankAccount = new BankAccount(accountNumber, accountName);
			this.accounts.add(bankAccount);

			return true;
		} else
			return false;
	}

	/**
	 * Accepts a String, representing the account number of a particular account,
	 * and an amount of money which is to be deposited in that account.
	 * 
	 * @param accountNumber
	 * @param amount
	 * @return Returns true if the deposit was made successfully, or false otherwise
	 *         (no such account number).
	 */
	public boolean depositMoney(String accountNumber, double amount) {
		int i = search(accountNumber);
		if (i != -999) {
			this.accounts.get(i).deposit(amount);

			return true;
		} else
			return false;
	}

	/**
	 * Accepts a String, representing the account number of a particular account, and an amount of money which is to be withdrawn from that account.
	 * 
	 * @param accountNumber
	 * @param amount
	 * @return Returns true if the withdrawal was made successfully, or false otherwise.
	 */
	public boolean withdrawMoney(String accountNumber, double amount) {
		int i = search(accountNumber);
		if (i != -999) {
			return this.accounts.get(i).withdraw(amount);
		} else
			return false;
	}
	
	/**
	 * Accepts a String, representing an account number, and removes that account from the list.
	 * 
	 * @param accountNumber
	 * @return Returns true if the account was removed successfully, or false otherwise (no such account number).
	 */
	public boolean removeAccount(String accountNumber) {
		int i = search(accountNumber);
		if (i != -999) {
			this.accounts.remove(i);
			
			return true;
		} else
			return false;
	}
}

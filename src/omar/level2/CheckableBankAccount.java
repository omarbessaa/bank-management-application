package omar.level2;

public class CheckableBankAccount extends BankAccount implements Checkable {

	public CheckableBankAccount(String numberIn, String nameIn) {
		super(numberIn, nameIn);
	}

	/**
	 * method to check if the account number is valid an account number is valid if
	 * it has exactly eight digits
	 */
	@Override
	public boolean check() {
		// check that the account number is exactly 8 characters long
		if (getAccountNumber().length() != 8) {
			return false;
		}
		// check that the account number contains only digits
		for (int i = 0; i <= 7; i++) {
			if (!Character.isDigit(getAccountNumber().charAt(i))) {
				return false;
			}
		}
		return true;
	}

}

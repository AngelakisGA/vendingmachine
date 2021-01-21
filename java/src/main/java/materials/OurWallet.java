package materials;

public class OurWallet {

	public double balance;

	public OurWallet() {
		balance = 0;
	}

	public void addMoney(double amountToDeposit) {
		balance = balance + (amountToDeposit);
	}

	public void withdrawMoney(double changeAmount) {
		balance = balance - (changeAmount);
	}
	
	public boolean negativeFunds() {
		if (balance < 0.00) {
			return true;
		}
		return false;
	}

	public double getBalance() {
		return this.balance;
	}
	
	public String getBalanceAsString() {
		double currentBalance = balance;
		double currentBalanceInChange = (currentBalance / 100.00);
		String formattedDoubleAsString = "$" + String.format("%.2f", currentBalance);
		return formattedDoubleAsString;
	}

	public Double returnChangeAsCoins() {
		
		Double [] change = new Double [] {0.25, 0.10, 0.05};
		String [] coin = new String [] {"Quarters", "Dimes", "Nickels"};
		for (int i = 0; i < change.length; i ++) {
			int counter;
			counter = (int) (balance/change[i]);
			
		balance -= (change[i]  * counter );
		System.out.println(counter + " " + coin[i]);
		
		}
		
		return balance;
	
	}
}

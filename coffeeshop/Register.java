/*
 *  Class
 */
package coffeeshop;

public class Register {
	// Data members
	private double cashBalance, creditBalance, checkBalance;

	public Register() {
		setCashBalance(150.00);
		setCheckBalance(0.00);
		setCreditBalance(0.00);
	}
	
	public Register(double cashBalance, double creditBalance, double checkBalance) {
		setCashBalance(cashBalance);
		setCheckBalance(checkBalance);
		setCreditBalance(creditBalance);
	}
	
	public double totalBalance() {
		return getCashBalance() + getCheckBalance() + getCreditBalance();
	}

	public double getCashBalance() {
		return cashBalance;
	}

	public void setCashBalance(double cashBalance) {
		this.cashBalance = cashBalance;
	}

	public double getCreditBalance() {
		return creditBalance;
	}

	public void setCreditBalance(double creditBalance) {
		this.creditBalance = creditBalance;
	}

	public double getCheckBalance() {
		return checkBalance;
	}

	public void setCheckBalance(double checkBalance) {
		this.checkBalance = checkBalance;
	}
	
}

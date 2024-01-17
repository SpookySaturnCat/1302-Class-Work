import java.util.Date;

public class Account {
	// Private data feilds
	private int id;
	private double balance, annualIntrestRate;
	private Date dateCreated;

	// Default no-args constructor
	public Account() {
		// Mutate data members
		setId(0);
		setBalance(0.00);
		setAnnualIntrestRate(0.0);
		dateCreated = new Date();
	}

	// Creates account with id and balance
	public Account(int id, double balance) {
		// Create instance and mutate
		this();
		setId(id);
		setBalance(balance);
	}

	public void withdraw(double amount) {
		setBalance(getBalance() - amount);
	}
	
	public void deposit(double amount) {
		setBalance(getBalance() + amount);
	} 
	
	// Acsessors and mutators 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualIntrestRate() {
		return annualIntrestRate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setAnnualIntrestRate(double annualIntrestRate) {
		this.annualIntrestRate = annualIntrestRate;
	}

	public double getMonthlyIntrestRate() {
		return getAnnualIntrestRate() / 12.0;
	}
	
	public double getMonthlyIntrest() {
		return balance * getMonthlyIntrestRate();
	}
}
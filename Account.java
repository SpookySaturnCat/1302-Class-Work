import java.sql.Date;

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
	}
	
	// Creates account with id and balance
	public Account(int id, double balance) {
		// Create instance and mutate
		this();
		setId(id);
		setBalance(balance);
	}

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

	public void setAnnualIntrestRate(double annualIntrestRate) {
		this.annualIntrestRate = annualIntrestRate;
	}

	
}

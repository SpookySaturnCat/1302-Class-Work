/*
 *  Class
 */
package coffeeshop;

public class Barista extends Person{
	// Data members
	private int level;
	
	// Default no-args constructor
	public Barista() {
		super("Marciline", 22);
		setLevel(1);
	}
	
	// Convenience constructors
	public Barista(String name, int age, Drink favoriteDrink) {
		super(name, age, favoriteDrink);
	}
	
	public Barista(String name, int age) {
		super(name, age);
	}

	// Acsessors and mutators
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}

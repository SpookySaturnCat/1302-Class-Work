/*
 *  Actual game
 */
package coffeeshop;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeShop extends Game {
	private Barista user;
	static Scanner input = new Scanner(System.in);
	private final String yesOrNoDialog = "Enter 1 for yes and 2 for no: ";
	
	public void chapter0() {
		// Set up user for first time
		Barista player = super.playerSetUp();
		setUser(player);
		int choice = 0;
		
		// Drink objects
		Drink drink = new Drink();
		Drink caramelCoffee = drink.createDrink("Caramel Coffee");
		Drink matchaLatte = drink.createDrink("Matcha Latte");
		
		// Prints intro dialog
		super.dialog("src/coffeeshop/welcome.txt", "*0*", "^0^");
		
		try {
		System.out.printf("\nGood morning %s, are you ready to start your shift?\n%s", getUser().getName(), yesOrNoDialog);
		choice = input.nextInt();
		
		while (choice != 1) {
			System.out.printf("Well, we can't start until you are ready!\n%s", yesOrNoDialog);
			choice = input.nextInt();
		}
		} catch (InputMismatchException ex) {
			System.out.println("Error: Must enter integer value");
		}
		
		super.dialog("src/coffeeshop/welcome.txt", "*1*", "^1^");
		System.out.printf("Alright %s, lets get the day started.\nLooks like theres a customer about to come in, good luck.", getUser().getName());
		
		Drink firstDrink = super.customerOrder(1);
		double charge = firstDrink.getPrice();
		
	}

	public Barista getUser() {
		return user;
	}

	public void setUser(Barista user) {
		this.user = user;
	}
	
}
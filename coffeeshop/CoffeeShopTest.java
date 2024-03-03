/*
 *  Client application
 */
package coffeeshop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CoffeeShopTest {
	public static void main(String[] args) {
		// Will not need game object soon
		Game game = new Game();
		Drink drink = new Drink();
		Barista user = game.playerSetUp();
		
		Drink caramelCoffee = drink.createDrink("Caramel Coffee");
		Drink matchaLatte = drink.createDrink("Matcha Latte");
		
		

	}
}

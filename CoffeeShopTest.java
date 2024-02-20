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
		// Create instances of the game and barista
		CoffeeShop game = new CoffeeShop();
		Barista user = game.playerSetUp();
		
		// Idk if this is right??
		try {
			game.welcome();
		} catch (IOException e) {
			System.out.println("yikes!");
			// e.printStackTrace();
		}
		
		// Testing
		game.saveFile(user);
		System.out.println(true); // Prints if saveFile works
	}
}

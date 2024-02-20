/*
 *  Actual game
 */
package coffeeshop;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CoffeeShop {
	// Create static scanner object
	static Scanner input = new Scanner(System.in);
	
	// Sets up the users 
	public Barista playerSetUp() {
	// Prompt user
	System.out.print("Please enter your name: ");
	String name = input.nextLine();name = Utilities.checkString(name);

	System.out.print("Please enter your age: ");
	int age = input.nextInt();

	// Creates barista object
	Barista user = new Barista(name, age);
	
	return user;
	}
	
	// Fucked up 
	public void welcome() throws IOException {
		File file = new File("welcome.txt");
		Scanner input = new Scanner(file);
		
		while(input.hasNext()) {
			String line = input.nextLine();
			System.out.println(line);
		}
		input.close();
	}
}
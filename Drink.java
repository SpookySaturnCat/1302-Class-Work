/*
 *  Class
 *  
 *  NEED TO EDIT: Have the ingredients ArrayList for each
 *  instance be populated based on the name in a text file
 *  
 *  Text file concept:
 *  --
 *  Black Coffee
 *  --
 *  Coffee Grounds
 *  Water
 *  --
 *  Next Drink Name
 *  -- 
 *  Whatever ingredients below
 */
package coffeeshop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Drink {
	// Data members
	private String name = "";
	private double price;
	private ArrayList<String> ingredientList = new ArrayList<>();

	// No-args default constructor
	public Drink() {
		setPrice(1.50);
		setName("Black Coffee");
		this.ingredientList.add("Coffee Grounds");
		this.ingredientList.add("Water");
	}

	// Convenience constructor
	private Drink(String name, double price, ArrayList<String> ingredients) {
		setName(name);
		setPrice(price);
		setIngredientsList(ingredients);
	}

	// Method that creates a drink by taking in a name and reading from text file
	public Drink createDrink(String name) {
		// Create file object
		File drinkInfo = new File("src/coffeeshop/DrinkInfo.txt");

		// Recreate data members within method
		String line = "";
		double price = 0;
		ArrayList<String> ingredientList = new ArrayList<>();

		// Create a Scanner object with resources
		try (Scanner input = new Scanner(drinkInfo);) {

			// While loop that runs while the file has contents
			while (input.hasNext()) {
				// Extracts the next line
				line = input.nextLine();

				// If we are on the correct drink this if statement runs
				if (line.equalsIgnoreCase(name)) {
					// Goes to the next String which should be "Price: "
					line = input.next();

					// If the file is in the correct formatting this block should execute
					if (line.equalsIgnoreCase("Price:")) {
						// Gets the next String
						line = input.next();

						// Extracts the double value from the String
						price = Double.parseDouble(line);

						// Clears queue then extracts next line
						input.nextLine();
						line = input.nextLine();

						// If "^" is in the next line
						while (line.contains("^")) {
							// Removes the first index (which is "^") and stores
							line = line.substring(1);

							// Adds to ArrayList then extracts next line
							ingredientList.add(line);
							if (input.hasNext()) {
								line = input.nextLine();
							}
						}
					}
				}
				/*
				 * Would this be an appropriate place to use break? The loop will keep going
				 * until the contents of the file have all been read through, and that does not
				 * seem too efficient
				 */
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}

		// Creates new drink object with values extracted from file
		Drink newDrink = new Drink(name, price, ingredientList);

		return newDrink;
	}

	public String toString() {
		String message = String.format("Name:         %s\nPrice:        $%,.2f\n\nIngredients:  %s\n", getName(),
				getPrice(), getIngredientList().get(0));

		// Loop to extract all contents of array and add them to the message
		for (int i = 1; i < getIngredientList().size(); i++) {
			message = message + "\t      " + getIngredientList().get(i) + "\n";
		}

		return message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	private void setIngredientsList(ArrayList<String> ingredientList) {
		this.ingredientList = ingredientList;
	}

	public ArrayList<String> getIngredientList() {
		return ingredientList;
	}

}
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

import java.util.ArrayList;

public class Drink {
	// Data members
	private String name = "";
	private double price;
	private ArrayList <String> ingredientList = new ArrayList<>();
	
	public Drink() {
		setPrice(1.50);
		setName("Black Coffee");
		addIngredientList("Coffee Grounds");
		addIngredientList("Water");
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
	
	public ArrayList<String> getIngredientList() {
		return ingredientList;
	}

	public void addIngredientList(String ingredient) {
		this.ingredientList.add(ingredient);
	}
}

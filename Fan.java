/*
 *  File: Fan.java
 *  Created: 01/09/2023
 *  Author: Seraphina Morrison
 *  Description: Exercise 9.8
 */

public class Fan {

	// Required data members
	public static final int SLOW = 1, Medium = 2, Fast = 3;
	private int speed;
	private boolean on;
	private double radius;
	String color = "";
	
	// Default no-args constructor
	public Fan() {
		
		// Required default values
		setSpeed(SLOW);
		setOn(false);
		setRadius(5);
		setColor("blue");
	}
	
	// Required method
	public String toString(){
		
		// Create formatted String with required information based on conditions
		String info = (isOn() ? "Speed: " + getSpeed() + "\n" : "Fan is off\n")
				+ "Color: " + getColor() + "\nRadius: " + getRadius() + "\n";
		
		// Returns formatted string 
		return info;
		
	}
	// Getters and Setters
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}

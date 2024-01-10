/*
 *  File: FanTest.java
 *  Created: 01/09/2023
 *  Author: Seraphina Morrison
 *  Description: Exercise 9.8
 */

public class FanTest {

	public static void main(String[] args) {

		// Create two fan objects
		Fan fan1 = new Fan();
		Fan fan2 = new Fan();
		
		// Change values to match required values
		fan1.setSpeed(3);
		fan1.setColor("yellow");
		fan1.setRadius(10.0);
		fan1.setOn(true);
		
		fan2.setSpeed(2);
		
		// Print results
		System.out.println(fan1.toString() + "\n" + fan2.toString());
		
	}

}

/*
 *  File: QuadraticEquationTest.java
 *  Author: Seraphina Morrison
 *  Created: 01/11/2023
 *  Description: Exercise 9.10 from the book
 */

import java.util.Scanner;

public class QuadratricEquationTest {

	public static void main(String[] args) {

		// Create array to store values
		double[] userValues = new double[3];

		// Create and initilize variables
		char j = 'a'; // Create j variable for print statment
		String message = "";

		// Create scanner object
		Scanner input = new Scanner(System.in);

		// For loop to display and store for a, b, and c
		for (int i = 0; i < userValues.length; i++) {

			// Prompt and store for data
			System.out.printf("Please enter the value integer values for %c: ", j);
			userValues[i] = input.nextDouble();

			j++; // Incriment j for print statement
		}

		// Create equation object and variables from the instance
		QuadratricEquation equation = new QuadratricEquation(userValues[0], userValues[1], userValues[2]);
		double discriminat = equation.getDiscriminant(), root1 = equation.getRoot1();

		// Else if to check value of discriminate and change message
		if (discriminat > 0) {
			message = String.format("The first root is %f%nThe second root is %f%n", root1, equation.getRoot2());
		} else if (discriminat == 0) {
			message = String.format("The root is %f%n", root1);
		} else {
			message = "The equation has no roots\n";
		}

		System.out.print(message);
	}
}

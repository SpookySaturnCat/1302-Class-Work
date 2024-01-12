/*
 *  File: QuadraticEquation.java
 *  Author: Seraphina Morrison
 *  Created: 01/11/2023
 *  Description: Exercise 9.10 from the book
 */

public class QuadratricEquation {

	// Data members
	private double a, b, c;

	// Default no args constructor
	public QuadratricEquation() {
		
		setA(2);
		setB(4);
		setC(5);
	}

	// Convience constructor
	public QuadratricEquation(double a, double b, double c) {

		setA(a);
		setB(b);
		setC(c);
	}

	// Returns b^2 - 4ac
	public double getDiscriminant() {

		return getB() * getB() - 4 * getA() * getC();
	}

	// Returns the first root of the equation
	public double getRoot1() {

		return (getDiscriminant() > 0) ? (-getB() + Math.sqrt(getDiscriminant())) / (2 * getA()) : 0;
	}

	// Returns the seconf root of the equation
	public double getRoot2() {

		return (getDiscriminant() > 0) ? (-getB() - Math.sqrt(getDiscriminant())) / (2 * getA()) : 0;
	}

	// Accsessors and mutators
	private double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	private void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	private void setC(double c) {
		this.c = c;
	}
}

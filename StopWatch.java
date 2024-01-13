/*
 *  File: StopWatch.java
 *  Author: Seraphina Morrison
 *  Created: 01/10/2023
 *  Description: Exercise 9.6 from the book
 */

public class StopWatch {
	// Private data members
	private double startTime, endTime;

	// Default no-args constructor
	public StopWatch() {
		setStartTime(System.currentTimeMillis());
		setEndTime(getStartTime());
	}

	// Method to start watch
	public void start() {
		startTime = System.currentTimeMillis();
	}

	// Method to stop watch
	public void stop() {
		endTime = System.currentTimeMillis();
	}
	
	// Method to calculate  elapsed time
	public double getElapsedTime() {
		return endTime - startTime;
	}

	// Getters and setters
	public double getStartTime() {
		return startTime;
	}

	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}

	public double getEndTime() {
		return endTime;
	}

	public void setEndTime(double endTime) {
		this.endTime = endTime;
	}
}

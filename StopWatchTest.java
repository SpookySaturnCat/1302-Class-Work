/*
 *  File: StopWatchTest.java
 *  Author: Seraphina Morrison
 *  Created: 01/10/2023
 *  Description: Exercise 9.6 from the book
 */

public class StopWatchTest {

	public static void main(String[] args) {
		// Create array that holds 100,000 numbers
		int[] arr = new int[100000];

		// For loop to populate array
		for (int i = 0; i < arr.length; i++) {
			// Creates a random number to populate array with
			arr[i] = (int) Math.floor(Math.random() * arr.length);
		}

		// Create StopWatch object
		StopWatch watch = new StopWatch();
		selectionSort(arr); // Sorts above array
		watch.stop(); // Stops the watch
		
		// Calculate seconds from milliseconds
		double totalSeconds = watch.getElapsedTime() / 1000.0;

		// Prints sort time
		System.out.printf("It took %.2f seconds to sort %d random integers", totalSeconds, arr.length);
	}

	public static void selectionSort(int[] arr) {
		// Create temp value
		int temp;
		
		// Outer loop to compare element (starts from start)
		for (int i = 0; i < arr.length; i++) {
			// Inner loop to compare next element in list from i
			for (int j = i + 1; j < arr.length; j++) {
				
				// If statement to check if the first element checked is larger than the second
				if (arr[i] > arr[j]) {
					
					// Swaps values
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}

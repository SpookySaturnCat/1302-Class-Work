package labprep;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab06Prep {
	public static void main(String[] args) {
		ArrayList<Double> list = new ArrayList<Double>();

		populateList(list);
		newFileIncresePrice(list, 1.25);
		newFileNoDuplicates(list);

		System.out.println(list);
	}

	public static void populateList(ArrayList<Double> list) {
		File inputFile = new File("src/labprep/pricelist.txt");
		Scanner input = null;
		try {
			input = new Scanner(inputFile);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		do {
			if (inputFile.exists()) {
				try {
					list.add(input.nextDouble());
				}

				catch (InputMismatchException ex) {
					input.next();
					ex.getMessage();
				} catch (Exception ex) {
					System.out.println("Error: Unknown exception");
				}
			}
		} while (input.hasNext());
		input.close();
	}

	public static void newFileIncresePrice(ArrayList<Double> list, double priceIncrease) {
		File outputFile = new File("src/labprep/newpricelist.txt");

		try (PrintWriter output = new PrintWriter(outputFile);) {
			if (outputFile.exists()) {
				for (int i = 0; i <= list.size() - 1; i++) {
					output.printf("$%,.2f\n", list.get(i) * priceIncrease);
				}
			} else {
				throw new FileNotFoundException("Error: File not found.");
			}
		} catch (FileNotFoundException ex) {
			ex.getMessage();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void newFileNoDuplicates(ArrayList<Double> list) {
		File outputFile = new File("src/labprep/pricelistnoduplicates.txt");
		ArrayList<Double> newList = new ArrayList<Double>();

		try (PrintWriter output = new PrintWriter(outputFile);) {
			if (outputFile.exists()) {
				for (int i = 0; i <= list.size() - 1; i++) {
					if (!newList.contains(list.get(i)))
						newList.add(list.get(i));
				}
				
				for (int i = 0; i <= newList.size() - 1; i++) {
					output.printf("$%,.2f\n", newList.get(i));
				}
				System.out.println(newList);
			} else {
				throw new FileNotFoundException("Error: File not found.");
			}
		} catch (FileNotFoundException ex) {
			ex.getMessage();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

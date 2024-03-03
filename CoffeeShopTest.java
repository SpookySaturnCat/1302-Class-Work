/*
 *  Client application
 */
package coffeeshop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CoffeeShopTest {
	public static void main(String[] args) {
		CoffeeShop game = new CoffeeShop();
		
		game.chapter0();

//		CoffeeShop game = new CoffeeShop();
//		File saveFile = new File("src/coffeeshop/savefile.txt");
//		int level = -1;
//
//		while (level <= 10) {
//			try (Scanner saveFileInput = new Scanner(saveFile);) {
//				String line = "";
//
//				if (!saveFile.exists()) {
//					game.chapter0();
		// Need to find a way to reread the file
//				} else {
					// BAD CODE
//					while (saveFileInput.hasNext()) {
//						line = saveFileInput.nextLine();
//
//						if (line.contains("Level")) {
//							level = Integer.parseInt(line);
//						}
//					}
//
//					switch (level) {
//					case 1:
//						break;
//					case 2:
//						break;
//					case 3:
//						break;
//					case 4:
//						break;
//					case 5:
//						break;
//					case 6:
//						break;
//					case 7:
//						break;
//					case 8:
//						break;
//					case 9:
//						break;
//					case 10:
//						break;
//					default:
//
//					}
//				}
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			}
//		}
	}
}

//////////////////////////
/** Package Declaration */
//////////////////////////
package v1;

//////////////
/** Imports */
//////////////
import java.util.Scanner;

///////////////////////
/** Class Definition */
///////////////////////
public class Helper {
	
	/////////////////////////////	
	/** Static Class Variables */
	/////////////////////////////
	private static final Scanner scanner = new Scanner(System.in); // create a single scanner for the whole game. 
	private static final int typeSpeed = 10;

	////////////////////////////////////////////
	/** Generic Methods to make things easier */
	////////////////////////////////////////////
	
	/** Returns user input as a string value */
	public static String input() {
		return scanner.nextLine();
	}
	
	/** Closes the input scanner */
	public static void closeScanner() {
		scanner.close();
	}
	
	/** Shorter generic print line method */
	public static <E> void println(E input) {
		System.out.println(input);
	}
	
	/** Shorter generic print method */
	public static <E> void print(E input) {
		System.out.print(input);
	}
	
	
	/** Simulates typing each character of a string with a new line at the end */
	public static void typeln(String str) {
		for (int i = 0; i < str.length(); i++) {
			
			if (i < str.length() - 1 && str.substring(i, i + 2).equals("\n")) {
				nl();
				i++;
			} 
			else {
				System.out.print(str.substring(i, i + 1));
			}
			pause(typeSpeed);
		}
		nl();
	}
	
	/** Simulates typing each character of a string*/
	public static void type(String str) {
		for (int i = 0; i < str.length(); i++) {
			
			if (i < str.length() - 1 && str.substring(i, i + 2).equals("\n")) {
				nl();
				i++;
			} 
			else {
				System.out.print(str.substring(i, i + 1));
			}
			pause(typeSpeed);
		}
	}
	
	
	/** Removes extra spaces from a string */
	public static String cleanInput(String str) {
		String cleanStr = "";
		for (int i = 0; i < str.length(); i++) {
			
			if (str.substring(i, i + 1).equals(" ")) {
				continue;
			} 
			else {
				cleanStr += str.substring(i, i + 1);
			}
		}
		return cleanStr;
	}
	
	/** pauses execution for a specified time in milliseconds */
	public static void pause(int tms) {
		try {
			Thread.sleep(tms);
		} 
		catch (InterruptedException e) {
			return;
		}
	}
	
	/** random range function */
	public static int randInt(int min, int max) {
		if(min < 0 && max < 0) {
			return (int)(Math.random()* (max - min) + min);
		}
		else {
			return (int)(Math.random() * (max - min + 1) + min);
		}
	}

	/** Shorter method for inserting a newline only */
	public static void nl() {
		System.out.println();
	}

}
//////////////////////////////
/** End of Class Definition */
//////////////////////////////

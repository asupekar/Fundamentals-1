import java.util.Scanner;//Needed for Scanner class
/**
 * This program will promt the user to input a number between the range of 5 to 
 * 25, and then using two different functions(input and calculate), will carry
 * out a mathematical calculation and display the result on the console.
 *
 * @author Aishwarya
 * @version 1.0
 *
 */
public class Functions
{
	final static int MIN = 5; //Declaring a constant for min range of input.
	final static int MAX = 25; //Declaring a constant for max range of input.

	/**
   * Prompts user to enter a number between the specified low and high range,
   * and then performs a mathematical operation on the inputted number.
   *
   * @param args A string array containing command line arguments.
   */ 

	public static void main(String[] args)
	{
		
		int number, result; // Declaring variables.
	   
		//Call welcome function print welcome message 
		welcome();

		//Calling input method.
		number = input();

		//Calling calculate method.
		result = calculate(number);
		System.out.println("The result is: " + result + "\n\n");
		
		//Print the goodbye message
		goodbye();
	}

	/**
 	* Prints the welcome message to the user.
 	*/	 
	public static void welcome()
	{
		System.out.println("Welcome to the Functions program! The program will "
								+ "request a number\nbetween 5 and 25 and return the "
								+ "calculated result.\n\n");	
	}

	/**
 	* Prints the goodbye message to the user.
 	*/	 
	public static void goodbye()
	{
		System.out.println("Thanks for using the Functions program!\n\n");
	}
		
	/**
 	* Prompts user to input a number between 5-25, checks whether it is in
 	* range of 5-25 and returns the valid number to main function.
 	*
 	* @return A valid number in the range
 	*/
	public static int input()
	{
		int number = 0; // Set Accumulator to zero.
			
		//Create a Scanner object for input.
		Scanner keyboard = new Scanner(System.in);
			
		// Keep asking for number from user until it is within the range
		do
		{
			System.out.print("Enter a number between 5 to 25: ");
			number = keyboard.nextInt();
			keyboard.nextLine();
		}
	   while(number < MIN || number > MAX);

		keyboard.close();// Close Scanner object.

		return number; // Returns the valid number where the function was 
								//called.
	}

	/**
	* Performs a mathematical operation on a number, and then returns the result
	* of the operation where the calculate function was called.
	*
 	* @param number The number which was inputted by the user.
	* @return Returns the result of the calculation.
	*/
	public static int calculate(int number)
	{
		int result = (number*2) - (number + 25);
		return result; //Returns the calculated value.
	}	
}

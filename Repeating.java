/** 
 * This program prompts user to input two numbers, then, it calculates if first
 * number is a multiple of second number, if yes, it displays the factor between 
 * them and asks the user if they want to continue with next set of input. 
 * If second number is zero, it prompts user to try again without asking to
 * continue.
 * 
 * @author Aishwarya
 *
 * @version 1.0
 */

import java.util.Scanner; //Needed for Scanner class

public class Repeating
{
	
	public static void main(String[] args)
	{
    
		int num1,num2,factor; //Declare the int variables 
		String response;		// Declaring a new variable for program modification
		char input;

		//Create a Scanner object to read input.
		Scanner keyboard = new Scanner(System.in);

		//Display a welcome message.
		System.out.println("Welcome to the Repeating program!");
		
		//Get as many sets of two numbers as the user wants.
		do
		{
			//Get the two numbers from the user.
			System.out.print("\nEnter two numbers, seperated by a space: ");
			num1 = keyboard.nextInt();
			num2 = keyboard.nextInt();
 			keyboard.nextLine(); // to skip the \n character

			/**
 			* Use the if else condition to check whether the numbers are multiples
 			* of each other 
			*/
   		if(num2 == 0) // If num2 equals zero, re-enter num2
			{
				System.out.println("The second number cannot be zero. Please try "
 										 + "again.");

				input = 'y'; /**In case the second number is zero, we do not take 
                         *input from the user to continue, instead we assign y 
								 *to the input variable so that we go to the beginning 
								 *of the do while loop.
								 */ 
			}
			else
			{	  
				/** 
				* If num1 when divided by num2 equals zero remainder then go inside 
				* this if condition
         	*/
				if(num1%num2 == 0)
      	   {
					factor = (num1/num2); 
					System.out.println(num1 + " is a multiple of " + num2 + "" +
					  							    " with a factor of " + factor + ".");
		  	   }
				//Remainder of mod operation was not zero
				else 
				{
					System.out.println(num1 + " is NOT a multiple of " + num2 + ".");
				}
		
				//Does the user want to repeat the process.
				System.out.print("Would you like to repeat (y/n)? ");
				response = keyboard.nextLine(); //Read a line
				input = response.charAt(0); //Get the first char
			}

		} while(input == 'Y' || input == 'y'); /**If the input is equal to Y or 
														  *   y, enter the do while loop again 
														  *   and if the input is different, 
														  *   exit the do while loop.
														  */

		//Display a thank you mesaage.
		System.out.println("\nThanks for using the Repeating program!\n");

		//Close Scanner
		keyboard.close();
	
	}
}

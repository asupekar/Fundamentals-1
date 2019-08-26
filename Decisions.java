/** 
 * This program prompts user to input two number's, then, it calculates if num1
 * is a multiple of number two, if yes, it displays the factor between them and
 * if second number is zero, it prompts user to try again and input another 
 * number.
 * 
 * @author Aishwarya
 *
 * @version 1.0
 */

import java.util.Scanner; //Needed for Scanner class

public class Decisions
{
	
	public static void main(String[] args)
	{
    
		int num1,num2,factor; //Declare the int variables 

		//Create a Scanner object to read input.
		Scanner keyboard = new Scanner(System.in);

		//Display a welcome message.
		System.out.println("Welcome to the Decisions program!");
	
		//Get the two numbers from the user.
		System.out.print("Enter two numbers, seperated by a space: ");
		num1 = keyboard.nextInt();
		num2 = keyboard.nextInt();
 
		/**
 		* Use the if else condition to check whether the numbers are multiples of 
		* each other
		*/
   	if(num2 == 0) // If num2 equals zero, re-enter num2
		{
			System.out.println("The second number cannot be zero. Please try again"
 									 + ".");
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
				System.out.println(num1 + " is a multiple of " + num2 + " with a" +
									    " factor of " + factor + ".");
		   }
			//Remainder of mod operation was not zero
			else 
			{
				System.out.println(num1 + " is NOT a multiple of " + num2 +  "." );
			}
		}

		//Display a thank you mesaage.
		System.out.println("Thanks for using the Decisions program!\n");

		//Close Scanner
		keyboard.close();
	
	}
}

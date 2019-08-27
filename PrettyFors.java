import java.util.Scanner;
/** 
 * This program takes a positive integer from the user and displays several 
 * patterns on the screen using nested for loops. 
 *
 * @author Aishwarya
 * @version 1.0
 */
public class PrettyFors
{
	public static void main(String[] args)
	{
		int rows, columns, size; //Declare variables
	
		//Create Scanner object for user input
		Scanner keyboard = new Scanner(System.in);

		/**
 		* 	Keep asking user until the input is not a  positive integer.
 		*/
		do
		{
			//Prompt user to enter a positive size
			System.out.print("Enter a positive integer: ");
			size = keyboard.nextInt();
			System.out.println();

			System.out.println("Please enter a number greater than zero\n");
		}
		// If the input is negative or zero, enter the loop again
		while(size <= 0);

		rows = size;
		columns = size;
			
		/****************************
		* X copies of X on one line
		****************************/
		System.out.println("\n1." + size + " copies of " + size + "" 
										+ " on one line.\n");

		for (int col=0;col<columns;col++)
		{
			System.out.print(size);
		}
			
		/*************************************
		* X lines with a single 1 on each line
		*************************************/
		System.out.println("\n\n2." + size + " lines with a single 1 on " 
								 + "each line.\n");

		for (int row=0;row<rows;row++)
		{
			System.out.println(1);
		}	//End of code 2
			
		/**************************************
		* Multiplication table to X
		**************************************/
		System.out.println("\n3.Multiplication table to " + size + ".\n");
			
		/******************************************************************** 
		* Count the number of digits in highest multiple of input size
		* Required to pad additional space in smaller multiples of input size
		*********************************************************************/
		int countOfDigits = 1;
		int maxMultiple = size*size;

		while (maxMultiple/10 != 0)
		{
			maxMultiple = maxMultiple/10;
			countOfDigits++;
		}

		String paddingForFirstColumn = "%" + countOfDigits + "s";
		String paddingForRemainingColumns = "%" + (countOfDigits+1) + "s";
				
		//Special case to handle first empty character in top left corner	
		System.out.printf(paddingForFirstColumn,"");
				
		// For loop to handle first row	
		for(int col=1;col<=columns;col++)
		{
			if(col == 1)
			{
				System.out.printf(paddingForFirstColumn, col);
			}
			else
			{
				System.out.printf(paddingForRemainingColumns, col);
			}
		}
		System.out.println();
			
		// For loop to handle remaining rows
		for(int row=1;row<=rows;row++)
		{
			System.out.printf(paddingForFirstColumn,row);
				
			for(int col=1;col<=columns;col++)
			{
				if(col==1)
				{
					System.out.printf(paddingForFirstColumn, row);
				}
				else
				{
					System.out.printf(paddingForRemainingColumns, row*col);
				}
			}
			System.out.println();
		}	//End of code 3
			
		/*****************************************************
		* X lines with with 1 ones on the first line, 
		* 2 twos on the second, etc. to X Xes on the last line 
		*****************************************************/
		System.out.println("\n4. " + size + " lines with 1 ones on the first line"
								 + ", 2 twos on the second, etc. to " + size + " "
								 + "" + size + "'s on the last line.\n");
		
		for (int row=1;row<=rows;row++)
		{
			for (int col=0;col<row;col++)
			{
				System.out.printf(paddingForRemainingColumns, row);
			}
			System.out.println();
		}
		System.out.println(); //End of code 4
			
		/**********************************************************
		* The outline of a half-diamond, with X at the widest point
		***********************************************************/
		System.out.println("5.The outline of a diamond, with " + size + " at "
								 + "the widest point.\n");

		for (int row=1;row<=rows;row++)
		{
			for (int col=1;col<row;col++)
			{
				System.out.print(" ");
			}
			System.out.println(row);
		}
			
		for (int row=rows-1;row>0;row--)
		{
			for(int col=row;col>1;col--)
			{
				System.out.print(" ");
			}
			System.out.println(row);
		}
		System.out.println(); //End of code 5
			
		keyboard.close();// For closing Scanner object.
	}
}

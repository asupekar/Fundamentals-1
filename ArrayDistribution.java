import java.util.Scanner;
import java.io.*;
/**
 * This program reads from a file and stores integers from the file in odd, even 
 * and neg array. It then prints all the three arrays in a formatted manner.
 *
 *@author Aishwarya
 *@version 1.0
 */
public class ArrayDistribution
{
	// Declare constants		
	final static int SIZE = 30; // max capacity
	final static String EVEN_ARRAY = "evenNum";
	final static String ODD_ARRAY = "oddNum";
	final static String NEG_ARRAY = "negNum";

	public static void main(String[] args) throws IOException
	{
	/**
 	* This program reads a file and then depending on the conditions those
 	* integers are added to odd, even or neg array. 
 	*
 	*@param args A string array containing the command line argument.
   *@throws IOException
 	*/
		// Stores one integer at a time from file
		int value;

		// File to read from
		String fileName;

		Scanner keyboard = new Scanner(System.in);
		
		// Ask for filename until user enters a valid string
		do
		{
			System.out.print("\nEnter the filename : ");
			fileName = keyboard.nextLine();
		}
		while(fileName == null || fileName.length() == 0); 

		// Declare arays with max capacity
		int[] evenNum = new int[SIZE];
		int[] oddNum = new int[SIZE];
		int[] negNum = new int[SIZE];

		// Indexes where the next value will be added in each array
		int indexEven = 0;
		int indexOdd = 0;
		int indexNeg = 0;

		// Scan the file
		File file = new File(fileName);
		Scanner inputFile = new Scanner(file);

		// scan one integer at a time from the file
		while (inputFile.hasNext())
		{
			value = inputFile.nextInt();
			
			// Handle only the non zero values
			if(value != 0)
			{
				if (value < 0)
				{
					negNum[indexNeg] = value;
					indexNeg++;		
				}
				else
				{
					if (value % 2 ==  0)
					{
						evenNum[indexEven]  = value;	
						indexEven++;
					}
					else
					{
						oddNum[indexOdd] = value;
						indexOdd++;
					}	
				}
			}
		}
	
		// print contents for even array
		printContents(evenNum, indexEven, EVEN_ARRAY);
		
		// print contents for odd array
		printContents(oddNum, indexOdd, ODD_ARRAY);
		
		// print contents for neg array
		printContents(negNum, indexNeg, NEG_ARRAY);

	   System.out.println();

		// Close the scanner objects
		keyboard.close();
		inputFile.close();
	}
	
	/**
 	* This function takes in an int array, array name and an index until which 
 	* the array has been filled. 
 	*
 	* @param int[] Array Either of even, odd or neg array.
 	* @param index Index in an array untill which the array is filled.
 	* @param arrayName Name of even, odd or neg array.
 	*
 	*/	 
	public static void printContents(int[] array, int index, String arrayName)
	{
		System.out.println();
		for(int i=0;i<index;i++)
		{
			System.out.println(arrayName + "[" + i + "]: " + array[i]);
		}
	}
}

import java.util.Scanner;// Needed for Scanner class
import java.io.File;//Needed for File input
import java.io.IOException; // Opening file can throw an IOException
/**
 * This program accepts a file from the user, displays the contents on the
 * console and then prompts user to input a number of their choice to check
 * whether it exists in the array. If yes, array index is displayed if not
 * number not found message is displayed.
 *
 * @author Aishwarya
 * @version 1.0 
 */
public class LinearSearch
{
	/**
 	* This program accepts a file from user, reads all the numbers from the file 
 	* and displays them on console. Asks the user to input a number and then
 	* checks whether that number is in the array. If yes, prints the index
 	* location of that number, if not displays a message, number not found.
 	* 
 	* @param args A string array containing the command line arguments
 	* @throws IOException File open operation can throw an IOException when not
 	* found
 	*/
	public static void main(String[] args) throws IOException 
	{
		//Declaring variables.
		int targetValue, size, index; 
		String userInput, fileName;
		char response;
		
		// Declare constants
		final int CAPACITY = 50;
		final char UPPER_CHOICE = 'Y';
		final char LOWER_CHOICE = 'y';

		//Declaring an array of size 50.
		int [] array = new int[CAPACITY];
		
		//Create Scanner object.		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("\nEnter a file name : ");
		fileName = keyboard.nextLine();
		
		File file = new File(fileName); 
		Scanner inputFile = new Scanner(file);
		int i = 0;
		
		System.out.print("\nArray elements:\n");		

		//Printing the contents of array on console.
		while(inputFile.hasNext() && i < array.length)
		{
			array[i] = inputFile.nextInt();
			System.out.println("arr[" + i + "]: " +array[i]);
			i++;
		}
		
		//Store the index location upto which the array is filled.
		size = i-1;

		do
		{
			System.out.print("\nEnter a number to search in the array: ");
			targetValue = keyboard.nextInt();
			keyboard.nextLine();

			//Calling LinearSearch function.		
			index = linearSearch(array, size, targetValue);
	
			if (index == -1)
			{
				System.out.println(targetValue + " not found");		
			}
			else
			{
				System.out.println(targetValue + " found at index " + index);
			}
		
			System.out.print("Would you like to repeat (y/n)? ");
			userInput = keyboard.nextLine();
			response = userInput.charAt(0);
	 	}while (response == LOWER_CHOICE || response == UPPER_CHOICE);
	}

	/**
 	* This function prints the array which is passed in its argument on the
 	* console with their indexes.
 	*
 	* @param int[] arr Array of numbers.
 	* @param size Index upto which we fill the array
 	* @param key Number to be found.
 	*/
	public static int linearSearch(int[] arr, int size, int key)	
	{
		int value = -1;

		for (int i = 0; i <= size; i++)
		{
			if(arr[i] == key)
			{
				value = i;
				return value;
			}
		}
		return value;//return value to the function call.
	}
}

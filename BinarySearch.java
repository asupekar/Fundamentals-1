import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

/**
 * This program reads a file, populates the array list. After populating this
 * array list, it sorts the number in non-descending order and prints them on
 * console. After sorting the numbers, user are prompted to input a key value
 * to be found in the array, if the value is spotted, the first index at which 
 * the value is present is returned with the value. If the value is not found in
 * the index, value not found message occurs on the console. 
 *
 *@author Aishwarya
 *@version 1.0
 *
 */

public class BinarySearch
{
	/**
 	* This function initially reads a file from source provided by the user,
 	* displays that on console, then sorts it in non-descending order and again
 	* displays on the console. Binary search is then carried out on the sorted
 	* array and users are asked to input a number to be sreached in the array
 	* list.
 	*
 	* @param args A string array contatining the command line arguments.
 	* @throws IOException
 	*/

	// Max capacity of the array list
	final static int MAX_SIZE = 30;

	public static void main(String[] args) throws IOException
	{
		String fileName, userInput;
		char response;

		// Create an array list with MAX_SIZE capacity
	   ArrayList<Integer> list = new ArrayList<>(MAX_SIZE);	

		final char LOWER_INPUT = 'y';
		final char UPPER_INPUT = 'Y';
		
		Scanner keyboard = new Scanner(System.in);

		System.out.print("\nEnter the filename: ");
		fileName = keyboard.nextLine();
		
		System.out.println("\nArray list elements before sort: ");
		
		// Fills values from file into the arraylist and gets the index upto which
		// the arraylist is filled
		populateArrayList(list, fileName); 
		
		// Prints the unsorted arraylist to the console 
		printArrayList(list);

		System.out.println("\nArray list elements after sort: ");
		
		// Sorts the array in non descending order
		selectionSort(list);

		// Prints the sorted arraylist to the console
		printArrayList(list);
		
		int number = 0;
		int position = -1;

		do
		{
			System.out.print("\nEnter a number to search in the list: ");
			number = keyboard.nextInt();
			keyboard.nextLine();

			position = BinarySearch(list, number);

			if(position == -1)
				System.out.println(number+ " not found " );
			else
				System.out.println(number + " found at index " + position);
		
			System.out.print("Would you like to repeat (y/n)? ");
			userInput = keyboard.nextLine();
			response = userInput.charAt(0);
		}  while(response == LOWER_INPUT || response == UPPER_INPUT);
		
		System.out.println();

		keyboard.close();

	}
	/**
 	* This function populates the array and returns the array size, i.e the index
 	* still which the array is populated.
 	*
 	*@param list arraylist that needs to be filled
 	*@param fileName name of the file to read from
	*@throws IOException
 	*/
	public static void populateArrayList(ArrayList<Integer> list, 
													 String fileName) throws IOException
	{
		File file = new File(fileName);
		Scanner inputFile = new Scanner(file);

		while(inputFile.hasNext())
		{
			list.add(inputFile.nextInt());
		}

		inputFile.close();
	}

	/**
   * This function prints the arraylist on the console
   *
   *@param list ArrayList to print
   */
	public static void printArrayList(ArrayList<Integer> list)
	{
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println("index:\t" + i + "\tvalue:\t" + list.get(i));
		}
	}

	/**
 	* This function sorts the entered array in non-descending order.
 	*
 	*@param list ArrayList to be sorted
 	*/
	public static void selectionSort(ArrayList<Integer> list)
	{
		int temp;
		int minIndex;

		for (int i=0; i < list.size()-1; i++)
		{
			minIndex = i;
			for (int j = i+1; j < list.size(); j++)
			{
				if(list.get(minIndex) > list.get(j))
				{
					minIndex = j;
				}
			}
			
			if ((i != minIndex))
			{
				temp = list.get(i);
				list.set(i, list.get(minIndex));
				list.set(minIndex, temp);
			}
		}
	}
	/**
 	* This function carries out Binary Search on the inputted arraylist and if 
 	* the number is found returns the index of that respective number and if not
 	* found returns a -1 integer. 
 	*
 	* @param list array Inputted arraylist
 	* @param int key value to be found.
 	* @return int index at which the key is found, -1 if not found.
 	*/
	
	public static int BinarySearch(ArrayList<Integer> list, int key)
	{
		int first = 0, middle;
		int last = list.size()-1;
		
		while(first <= last)
		{
			middle = (first+last)/2;
			if (list.get(middle) == key)
				return middle;
			else if (list.get(middle) < key)
				first = middle+1;
			else
				last = middle-1;
		}
		return -1;
	}
}

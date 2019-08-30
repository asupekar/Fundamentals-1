import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * This program reads from a file, displays the content of the file on the
 * console and then sorts the array in non-descending manner. After sorting
 * those values in array, it displays those sorted values on the console.
 *
 * @author Aishwarya
 * @version 1.0
 */

public class SelectionSort
{
	/**
 	* This function gets the file name, displays on the console. After displaying
 	* on console, selection sort function is called and then sorted array is
 	* again displayed on the console.
 	*
 	* @param args A string array containing the command line argument.
 	* @throws IOException
 	*/
	public static void main(String[] args) throws IOException
	{
		final int SIZE = 60;
		String[] array = new String[SIZE];

		final String FILE_NAME = "/home/fac/ohsh/submit/19rq5001/files/"
										 + "lab9input.txt" ;
		System.out.println("\n");

		File file = new File(FILE_NAME);
		Scanner inputFile = new Scanner(file);

		// Size represents the index until which array is filled		
		int size = readFromFile(array, inputFile);

		System.out.println("Array before sorting:");

		printArray(array, size);		

		// Call selection sort algorithm
		sortContents(array, size);
		
		System.out.println("\nArray after sorting:");
		
		printArray(array, size);	
	}
	/**
 	* This function reads the content from the filename and then stores it in an 
 	* array.
 	*
 	* @param array The entered array.
 	* @param inputFile To read from the file.
 	* @return size Returning the size of the filled array.
 	*/
	public static int readFromFile(String[] array, Scanner inputFile)
	{
		int size = 0;

		for (int i = 0; i < array.length && inputFile.hasNext(); i++)
		{
			array[i] = inputFile.nextLine();
			size = i;
		}
		return size+1;
	}
	
	/**
 	* This function prints the contents from the array.
 	*
 	* @param array The sorted array.
 	* @param size Size of the non-empty array.
 	*/
	public static void printArray(String[] array, int size)
	{
	   for(int i =0; i < size; i++)
		{
			System.out.println("arr[" + i + "]: " + array[i]);
		}
		System.out.println();
	}
	
	/**
 	* This function carries out the sorting of the elements present in the array
 	*
 	* @param array The entered array.
 	* @param size The length of the filled array. 
 	*/
	public static void sortContents(String[] array, int size)
	{
		for (int i = 0; i < size-1; i++)
		{
			String temp;
			int min = i;
	
			for (int j = i+1; j < size; j++)
			{	
				if (array[j].compareTo(array[min]) < 0)
				{
					min = j;
				}
			}
	
			if ( i != min )
			{
				temp = array[min];
				array[min] = array[i];
				array[i] = temp;
			}

		}
	}
}

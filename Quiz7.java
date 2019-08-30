import java.util.*;
import java.io.*;

public class Quiz7
{
	static final String FILE_NAME = "/home/fac/ohsh/submit/19rq5001/files/"
												+ "numbers.txt";

	public static void main(String[] args)throws IOException
	{
		int[] simpleArray = getNumbers(FILE_NAME);
		System.out.println("\n\nArray elements... ");
		for (int i = 0; i < simpleArray.length; i++)
		{
			System.out.println("arr[" + i + "]: " +simpleArray[i]);
		}

			ArrayList<String> array2 = getNumbersAgain(FILE_NAME);
		System.out.println("\n\nArrayList elements... ");
		for(int i = 0; i < array2.size(); i++)
		{
			System.out.println("arrList.get(" + i + "): " + array2.get(i));
		}
		System.out.println();
	}

	public static int[] getNumbers(String filename)throws IOException
	{
		int count = 0;
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		while(inputFile.hasNext())
		{
			inputFile.nextLine();
			count++;
		}
		Scanner reader = new Scanner(file);
		int i = 0;
		int[] array = new int[count];
		while(reader.hasNext() && i < count)
		{
			array[i] = reader.nextInt();
			i++;
		}
		
		reader.close();
		inputFile.close();
		return array;
	}

	public static ArrayList<String> getNumbersAgain(String filename)throws 
																					IOException
	{
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		ArrayList<String> num = new ArrayList<> ();
		while(inputFile.hasNext())
		{
			num.add(inputFile.nextLine());	
    	}
		inputFile.close();
		return num;
	}	
}

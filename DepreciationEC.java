import java.util.Scanner;//Needed for Scanner class

/** This program prompts the user to select a option for calculating depreciated
 * value. The two options are standard and optional. While standard option
 * calculates a depreciated value of an item entered by the user.
 * It asks the user to input description of the item, original value and the 
 * annual depreciation. It also calculates the accumualated depreciation
 * value. Repeats the program as many times the user wants. Option two which is
 * optional prompts user to enter the number of years for complete depreciation.
 * and then prints the table.
 *
 * @author Aishwarya
 * @version 1.0
 */
public class DepreciationEC
{
/**
 * Prompts user for item description, original value and annual depreciation
 * and then prints item depreciation table. 
 *
 * @param args A string array containing the command line arguments.
 */
   public static void main(String[] args)
	{
		char response;//Declare variable.
		final char CHOICEUPPER = 'Y';
		final char CHOICELOWER = 'y';

		Scanner keyboard = new Scanner(System.in);
		welcome();//Calling the welcome function.
		
		do
		{
			System.out.println("\nWhich depreciation report would you like to "
									+ "run? ");
			System.out.print("Press 1 for Standard, 2 for optional: ");
			int option = keyboard.nextInt();
			keyboard.nextLine();

			String itemName =	getDescription(keyboard);
			double originalValue = getOriginalValue(keyboard);
			double annualDepreciation = 0.0;

			int numberOfYears;//Declaration of number of years. 
		
			//Assign a value to annual depreciation
			if(option == 1)
			{
				annualDepreciation = getAnnualDepreciation(keyboard);	
			}
			else if(option == 2)
			{
				numberOfYears = getNoOfYears(keyboard);
				annualDepreciation = originalValue/numberOfYears; 
			}
			
			//print the description
			printDescription(itemName, originalValue, annualDepreciation);

			//print the depreciation table
			printTable(annualDepreciation, originalValue);

			System.out.print("\n\nDo you want to depreciate another item(y/n)? ");
			String userInput = keyboard.nextLine();
		   response = userInput.charAt(0);
		}while(response == CHOICEUPPER || response == CHOICELOWER);
	   
		keyboard.close();	// Close Scanner object

		goodbye();//Calling goodbye function.
	}

	/**
 	* Displays a welcome message on the screen.
 	*/
	public static void welcome()
	{
		System.out.println("\nWelcome to the asset depreciation reporting system, "
							 + "brought to you by\nSlime, Weasel, and Swindle.");
	}
	
	/**
 	* Gets description of the item user wants to calculate depreciated value of.
 	* 
 	* @param keyboard For taking input from command line.
 	* @return name Returns the name from the command line.
 	*/
	public static String getDescription(Scanner keyboard)
	{	
		String name = null;
		
		do
		{
			System.out.print("\nEnter a description of the equipment: ");
			name = keyboard.nextLine();
		}
		while(name == null || name.length() == 0);

		return name;
	}

	/**
 	* Gets orginial value of the item form user.
 	*
 	* @param keyboard For taking input from command line.
 	* @return Returns the original value entered by user.
 	*/
	public static double getOriginalValue(Scanner keyboard)
	{
		double originalValue = 0.0;
		do
		{
			System.out.print("What is the original value of the equipment? $");
			originalValue = keyboard.nextDouble();
			keyboard.nextLine();
			if(originalValue <= 0)
			{
				System.out.println("Enter a value greater than zero");
			}

		} while (originalValue <= 0);
			
		return originalValue;
	} 

	/**
 	* Gets annual depreciation value for the item for option 1
 	*
 	* @param keyboard For taking input from command line.
 	* @return Returns annual depreciation value entered by user. 
 	*/
	public static double getAnnualDepreciation(Scanner keyboard)
	{
		double depreciation = 0.0;
		do
		{
			System.out.print("What is the annual depreciation? $");
			depreciation = keyboard.nextDouble();
			keyboard.nextLine();
			if(depreciation <= 0)
			{
				System.out.println("Enter annual depreciation greater than zero");
			}

		} while (depreciation <= 0);
	
		return depreciation;
	}

	/**
 	* This function accepts the no of years of the equipment to be completely
 	* depreciated.
 	*
 	*@param keyboard For taking input from command line.
 	*/
	public static int getNoOfYears(Scanner keyboard)
	{
		int noOfYears;
		do
		{
			System.out.print("Enter the number of years it takes the equipment to "
								  + "fully depreciate: ");
			noOfYears = keyboard.nextInt();
			keyboard.nextLine();

			if(noOfYears <= 0)
			{
				System.out.println("Number of years has to be greater than 0");
			}
		} while (noOfYears <= 0);

		return noOfYears;
	}

   /**
 	* Prints equipment description, beginning value and depreciation on the
 	* console.
 	*
 	* @param itemName The equipment name.
 	* @param originalValue The beginning value of the item.
 	* @param annualValue The depreciation value of item annually.
 	*/
	public static void printDescription(String itemName,double originalValue,
													double annualValue)
	{
		System.out.println("\nEquipment description: " + itemName);
		System.out.printf("Beginning value: $%.2f%n", originalValue);
		System.out.printf("Depreciation: $%.2f%n", annualValue);
	} 

	/**
 	* Prints out depreciation table in a formatted way by carrying some 
 	* operations on the entered data.
 	*
 	* @param annualDeprecaition The depreciation value of item annually.
 	* @param originalValue The beginning value of the item.
 	*/
	public static void printTable(double annualDepreciation,double originalValue)
	{
		System.out.println("\nYear\tDepreciation\tEnd-of-Year Value\tAccumulated "
								 + "Depreciation");
		double endOfYearValue = originalValue - annualDepreciation;
		
		// Handle a case where originalValue is less than annualDepreciation
		if(endOfYearValue < 0)
		{
			endOfYearValue = 0;
			annualDepreciation = originalValue;
		}

		double accumulatedDepreciation = annualDepreciation;

		int i = 1; 
	
		// Print the depreciation table until 2nd last year
		// Comparing with 0.001 as x-x does not result in 0.0 for double
		for(; endOfYearValue>=0.001; i++)
		{
			//Prints the values for ith year
			printValuesInYear(i, annualDepreciation, endOfYearValue,
								   accumulatedDepreciation);
		
			// If the item depreciates below zero
			if((endOfYearValue-annualDepreciation)<0)
			{
				annualDepreciation = endOfYearValue;
			}
			
			//Value of item depreciating at end of year
			endOfYearValue-=annualDepreciation;
	
			//Total depreciation by end of ith year
			accumulatedDepreciation += annualDepreciation;

			System.out.println();
		}
	   
		//Prints the values for last year when item is fully depreciated	
		printValuesInYear(i, annualDepreciation, endOfYearValue,
								   accumulatedDepreciation);
	}

	/**
 	* This function prints the calculated values on console with formatted
 	* settings.
 	*
 	* @param year Year of depreciation.
 	* @param annualDepreciation Annual depreciation value of item.
 	* @param endOfYearValue Value at the end of year.
 	* @param accumulatedDepreciation Value accumulated at the end of year.
 	*/
	public static void printValuesInYear(int year, double annualDepreciation, 
													double endOfYearValue, 
													double accumulatedDepreciation)
	{
		System.out.printf("%2d\t",year);
		System.out.printf("$%6.2f\t\t",annualDepreciation);
		System.out.printf("$%7.2f\t\t",endOfYearValue);
		System.out.printf("$%7.2f\t\t",accumulatedDepreciation);
	}
	
	/**
 	* This function displays a goodbye message to the user.
 	*/
	public static void goodbye()
	{
		System.out.println("\nGoodbye, and thanks for using the asset "
									+ "depreciation reporting system!\n");
								
	}
}	

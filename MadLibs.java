 /**
 *   This program plays a Mad Libs game with the user which includes getting
 *   name,age,place,college,profession,animal and petname and displaying brief
 *   description of the above user details.
 *
 *   @author Aishwarya
 *   @version 1.0
 *
 */
import java.util.Scanner; //Importing Scanner class for using its function.

public class MadLibs {

   public static void main(String[] args) {
     
      //Displaying the welcome message to the user.
    	System.out.println("\n\nWelcome to the Mad Libs game! You will be asked t"
								+ "o enter specific input.\nLet's begin.\n");
         
		//Declaring the variables.
		int age;
		String name,place,college,profession,animal,petName;
 
		//Create scanner object for keboard input
      Scanner keyboard = new Scanner(System.in);
      
		// Ask user to input name
		System.out.print("Enter the name: ");
	   name = keyboard.nextLine();

		//Ask user to input age
		System.out.print("Enter an number: ");
		age = keyboard.nextInt();
      keyboard.nextLine(); //To skip /n after getting age
        
		//Ask user to input place
      System.out.print("Enter a place: ");
		place = keyboard.nextLine();

		//Ask user to input college
      System.out.print("Enter a college: ");
		college = keyboard.nextLine();

		//Ask user to input profession
		System.out.print("Enter a profession: ");
		profession = keyboard.nextLine();

		//Ask user to input animal
		System.out.print("Enter a animal: ");
		animal = keyboard.nextLine();

		//Ask user to input pet name
	   System.out.print("Enter a pet name: ");
		petName = keyboard.nextLine();

		//Display the entire message on the console
      System.out.println("\nThere once was a person named " + name + " who live"
                         + "d in " + place + ". At the age of " + age + ",\n" 
		        	          + "" + name + " went to school at " + college + ". " 
                         + name + " graduated and went to work as a \n"
			                + "" + profession + ". Then, " + name + " adopted a(n) "
								 + animal + " named " + petName + ". They both \n" 
				             + "lived happily ever after!\n ");
	 
		//Display a thank you message.
	 	System.out.println("Thanks for playing the Mad Libs game!\n");

		//Close Scanner
		keyboard.close();
	
		}
}
	

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

 /**
 * The Chutes program implements an application that plays a Chutes and Ladder
 * game with 2 to 6 players. It uses a spin of 6 possibilities ranging from
 * 1 to 6. When a ladder is found at a certain location, player's location is
 * incremented by some offset. If chute is found, player's location is 
 * decremented by certain offset. The game ends when a player reaches location
 * 100.
 *  
 * @author  Aishwarya
 * @version 1.0
 */
public class Chutes
{
	// Constant for hyphen formatting
	static final String HYPHENS = "------------------------------";
	
	// Array which stores names of the players
	static String[] playerNames;
	
	// Parallel array which stores location of each player
	static int[] playerLocations;
	
	// Array to store chutes ladders offset mapping
	static int[] chutesLadders;
	
	// Max size of the chutes ladder board
	static final int MAX_SIZE = 100;
	
	// Min range for spin
	static final int SPIN_MIN = 1;
	
	// Max range for spin
	static final int SPIN_MAX = 6;
	
	// Declaring random to generate spin outcome
	static Random random = new Random();
	
	// Constant for file name
	static final String FILE_NAME = "/home/fac/ohsh/submit/19rq5001/files/" + 
											  "p3input.txt";
	
	/**
    * Accepts user names and displays the winner in the standard output.
    *
    * @param args A string array containing the command line arguments.
	* @throws IOException.
    */ 
	public static void main(String[] args) throws IOException
	{
		// Print welcome message once
		welcome();
		
		// Scanner to take input from console
		Scanner keyboard = new Scanner(System.in);
		
		// constants for comparing user's response
		final char CHOICE_LOWER = 'y';
		final char CHOICE_UPPER = 'Y';
		
		char response;
		
		do
		{
			// Get the number of players and their names
			setPlayerDetails(keyboard);
		
			// Get the chutes and ladders position and offset details
			setChutesLadders(keyboard);
			
			// Start the game and declare the winner
			int winner = playGame();
			System.out.println("\n" + playerNames[winner] + ", you have won" +
										" the game!\n");
			
			System.out.print("Do you want to play again? ");
			response = keyboard.nextLine().charAt(0);
		}while(response == CHOICE_LOWER || response == CHOICE_UPPER);
		
		// Close the scanner object
		keyboard.close();
		
		// Print goodbye message once
		goodbye();
	}
	
	/**
	* Prints the welcome message.
	*/
	public static void welcome()
	{
		System.out.println("\nWelcome to Chutes & Ladders! You must land on "
								  + "100 (without going past) to win! You will play"
								  + " against the computer.");
	}
	
	/**
	* Initializes player details such as name and location..
	* @param keyboard To take input from console.
	*/
	public static void setPlayerDetails(Scanner keyboard)
	{
		printHyphens();
		
		System.out.print("How many players will play (between 2-6)? ");
		int playerCount = keyboard.nextInt();
		keyboard.nextLine();
		
		// Size of the parallel arrays will be same as number of players
		playerNames = new String[playerCount];
		playerLocations = new int[playerCount];
		
		// Ask for name of each player and set it in the playerNames array
		for(int i=0;i<playerCount;i++)
		{
			System.out.print("Enter player " + (i+1) + "'s name: ");
			setPlayerName(i, keyboard.nextLine()); 
		}
		
		printHyphens();
	}
	
	/**
	* Initializes chutesLadders offset arrays.
	* @param keyboard To take input from console.
	* @throws IOException.
	*/
	public static void setChutesLadders(Scanner keyboard) throws IOException
	{
		chutesLadders = new int[MAX_SIZE];
		
		File file = new File(FILE_NAME);
		keyboard = new Scanner(file);

		while(keyboard.hasNext())
		{
			String line = keyboard.nextLine();
			String[] nums = line.split("\\s+");

			// Starting position of the chute or ladder
			int index = Integer.parseInt(nums[0]);
			
			// Offset for the above position
			int offset = Integer.parseInt(nums[1]);
			
			// Create mapping between chutes/ladders and offset
			chutesLadders[index] = offset;
		}
	}
	
	/**
	 * Returns the player name of player at given index in the playerNames[].
	 *
	 * @param playerNumber playerNames array index representing the player.
	 * @return  The string respresenting player name at index playerNumber.
	 */
	public static String getPlayerName(int playerNumber)
	{
		return playerNames[playerNumber];
	}
	
	/**
	 * Sets the player name of player at given index in the playerNames[].
	 *
	 * @param playerNumber playerNames array index representing the player.
	 * @param playerName name of the player at index playerNumber.
	 */
	public static void setPlayerName(int playerNumber, String playerName)
	{
		playerNames[playerNumber] = playerName;
	}
	
	/**
	 * Returns the player location of player at given index in the 
	 * playerLocations[].
	 *
	 * @param playerNumber playerLocations array index representing the player.
	 * @return  The location at which the player is at on the board.
	 */
	public static int getPlayerLocation(int playerNumber)
	{
		return playerLocations[playerNumber];
	}
	
	/**
	 * Sets the player location of player at given index in the playerLocations[]
	 *
	 * @param playerNumber playerLocations array index representing the player.
	 * @param location location of the playerNumber.
	 */
	public static void setPlayerLocation(int playerNumber, int location)
	{
		playerLocations[playerNumber] = location;
	}
	
	/**
	 * Starts the Chute and Ladder game.
	 *
	 * @return  An array index representing the player who won the game.
	 */
	public static int playGame()
	{
		// Represents index for playerNames and playerLocations array
		int player = -1;
		
		String playerName = null;
		
		// Result of each spin between 1 to 6 inclusive
		int spinOutcome = 0;
		
		// Next location of the player after the spin
		int nextPosition = 0;
		
		// Move forward or back depending on the location
		int offset = 0;
	
		do
		{	
			// Whose turn it is
			player = nextTurn(player, playerNames.length);
			
			playerName = getPlayerName(player);
			System.out.println(playerName + ", it's your turn. You are currently"
								    + " at space " + playerLocations[player]);
			
			// Spin the dice to see the outcome
			spinOutcome = spin();
			System.out.println("The spin was: " + spinOutcome);
			
			// next location where the player will go
			nextPosition = getPlayerLocation(player) + spinOutcome;
			
			// If nextPosition is 100, then player is the winner
			if(nextPosition == MAX_SIZE)
			{
				setPlayerLocation(player, nextPosition);
				return player;
			}
			// Handle a case where spin takes player past 100
			else if(nextPosition > MAX_SIZE)
			{
				System.out.println("Sorry, no player can go over 100.");
			}
			// Case where player is location < 100
			else
			{
				//Get offset mapping for position from chutesLadders array
				offset = chutesLadders[nextPosition];
				
				// Ladder case moce forward
				if(offset > 0)
				{
					System.out.println("Congrats, that is a ladder! You get to"
										     + " climb " + offset + " spaces.");
				}
				// Chute case move backwards
				else if(offset < 0)
				{
					System.out.println("Sorry, that is a chute! You are sent"
												+ "back " + (0-offset) + " spaces.");
				}
				
				//Update player's location
				setPlayerLocation(player, nextPosition + offset);
			
				System.out.println("You are now at space " 
											+ getPlayerLocation(player) + ".");
				
				// After adding offset, the player can reach 100th location
				if(getPlayerLocation(player) == MAX_SIZE)
				{
					return player;
				}
			}
			System.out.println();
		}
		while(getPlayerLocation(player) != 100);
		
		return player;
	}
	
	/**
	 * Returns the number i representing player i'th turn.
	 *
	 * @param currentPlayer player who just played.
	 * @return integer indicating which player will play next.
	 */
	public static int nextTurn(int currentPlayer, int playerCount)
	{
		int nextPlayer = (currentPlayer + 1)%playerCount;
		return nextPlayer;
	}
	
	/**
	* Returns the outcome of the spin where the player will go next.
	*
	* @return integer indicating which player will play next.
	*/
	public static int spin()
	{
		// Return a random integer between 1 and 6 inclusive
		return random.nextInt(SPIN_MAX - SPIN_MIN + 1) + SPIN_MIN;
	}
	
	/**
	* Prints hyphens for console formatting
	*/
	public static void printHyphens()
	{
		System.out.println("\n" + HYPHENS  + "\n");
	}
	
	/**
	* Prints goodbye message to the user
	*/
	public static void goodbye()
	{
		printHyphens();
		System.out.println("Goodbye, and thanks for playing Chutes & Ladders!");
	}
}

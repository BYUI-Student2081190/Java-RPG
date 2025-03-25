/**
 * This is the Game Class - This is where everything
 * in the main game will run.
 */

// Imported Libraries.
import java.util.Scanner; // Import the scanner class to read inputs from user.
// import java.util.ArrayList; // Import the ArrayList class to create ArrayLists in program.

public class Game {
    // Global Variables.
    public static int gameSpeed = 50; // This changes how fast text flows in the game. This is currrently 50 miliseconds.
        
    // This must be at the top, this function clears the console for better UI.
    public static void clearConsole() {
        // This is a ANSI escape code. It moves the cursor to the
        // top left of the console, and clears the screen.
        System.out.println("\033[H\033[2J");
        // This makes sure that after the reset the new console
        // message is immediately displayed.
        System.out.flush();
    }
    
    // This function was made to create a RPG feel to the console by printing sentances
    // in a way an old NES game would which is letter by letter at a time.
    public static void printLetterByLetter(String text) {
        // Create a for loop that loops through each letter and prints them.
        for (int i = 0; i < text.length(); i++) {
            // Print each letter at the index of i in the string.
            System.out.print(text.charAt(i));
            // Create a try catch handles if the thread is ever
            // interupted while sleeping.
            try {
                Thread.sleep(gameSpeed);
            } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    System.out.println(); // After that set of strings has been printed, add a new line so the next set can be printed.
    }

    // This function checks to see if a String is an Int.
    public static boolean isInt(String word) {
        // Use a try catch to see if this is an int,
        // if not return false.
        try {
            Integer.parseInt(word);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Main class. This runs at the start.
    public static void main(String[] args) {
        // Create new scanner to handle user inputs.
        Scanner scanner = new Scanner(System.in);

        // Create a Title Screen for the player.
        System.out.println("JAVA QUEST\n");
        System.out.println("Press Enter to Start... ");
        scanner.nextLine();
        clearConsole(); // Clear Console on each screen to make pretty UI.

        // Create the Game Main Menu.
        boolean endMenuLoop = false; // End the loop.
        String userResponse; // Obtain and use the userResponse.

        while (endMenuLoop != true) {
            // Display messages to the user.
            printLetterByLetter("Welcome to the land of Javopia.\nA world full of wonder and adventure.");
            printLetterByLetter("Tell me adventurer? What would you like to do first?");
            printLetterByLetter("1.) Create Character");
            printLetterByLetter("2.) Quit");
            printLetterByLetter("Please type the number of the option you would like: ");
            userResponse = scanner.nextLine();

            // Test the user response and see if it is an int before moving on.
            if (isInt(userResponse)) {
                // Change the data type of the userResponse.
                int choice = Integer.parseInt(userResponse);

                // Find which option the user wanted to do.
                switch (choice) {
                    case 1:
                        // Clear the console for next action.
                        clearConsole();
                        // Call the character creator function.
                        printLetterByLetter("Lets create a character!");
                        break;
                    case 2:
                        // Clear the console for the next action.
                        clearConsole();
                        // Quit the game.
                        endMenuLoop = true;
                        break;
                    default:
                        clearConsole();
                        printLetterByLetter("You did not enter a number in range. Please try again.");
                        printLetterByLetter("Press Enter to Continue...");
                        scanner.nextLine();
                        clearConsole();
                }

            } else {
                clearConsole();
                printLetterByLetter("Your response was not a number. Please try again.");
                printLetterByLetter("Press Enter to Continue...");
                scanner.nextLine();
                clearConsole();
            }
        }

        // Create an end message.
        printLetterByLetter("Thanks for playing! See you around!");

        // After Game finishes close the scanner in use.
        scanner.close();
    }
}
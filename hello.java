/**
 * Hello Class Main - Start with this file and edit as we go.
 */

 // Import some libraries to use.
 import java.util.Scanner; // Import the scanner class to read inputs from user.
 import java.util.ArrayList; // Import the ArrayList class to create ArrayLists in program.

 // hello and main functions.
 public class hello {

    // Function that Adds two numbers.
    public static int add(int numOne, int numTwo) {
        // Add the numbers together.
        int sum = numOne + numTwo;
        // Now return.
        return sum;
    }

    // Main Function.
    public static void main(String[] args) {
        // Create a new scanner object to obtain the inputs.
        Scanner scanner = new Scanner(System.in); // Must live inside of main.

        // Different Variables in Java.
        int num = 5;
        String word = "Hello";
        double per = 1.5;
        boolean magicAns = false;
        String userResponse;
        int userNum;

        // Print the line of code to the output.
        System.out.println(word + ", the number is: " + num + ".\nThe double is: " + per + ".\n" + "The Magic Answer is: " + magicAns + ".");
        
        // Ask user for a favorite food.
        System.out.println("What is your favorite food? Please Enter: "); // Create a spot for the input.
        userResponse = scanner.nextLine(); // Look at the next line.
        System.out.println(userResponse + ", huh? Sounds delish!"); // Display this to the user.
        
        // Ask for a favorite number.
        System.out.println("What is your favorite Number? Please Enter: "); // Create the spot for the input.
        userNum = scanner.nextInt(); // This will look for the next number input.
        // Create a test if statement to see if you can do it.
        if (userNum == 10) {
            // Display special message.
            System.out.println("Oh no way! Your favorite number is " + userNum + "!? That is mine too!!");
        } else {
            // Display normal message.
            System.out.println(userNum + "? That is not a bad number at all! I like it! :)");
        }

        // Call a function.
        int numOne = 25;
        int numTwo = 25;
        int ans = add(numOne, numTwo);
        System.out.println("I can also call a function!\nHere is my answer after I added these numbers: " + ans);

        // Test different loops. Also use a ArrayList.

        System.out.println("Watch me count!");
        for (int i = 0; i <= 5; i++) {
            System.out.println("Number: " + i);
        }

        boolean leaveLoop = false;
        String userAns;
        String leave = "leave";

        while (leaveLoop != true) {

            System.out.println("I am testing a while loop. Please enter 'leave' to exit the loop: ");
            userAns = scanner.nextLine();

            if ((userAns.toLowerCase()).equals(leave)) {
                // Set leave loop to leave this loop.
                leaveLoop = true;
            } else {
                // Do not leave loop.
                System.out.println("You cannot leave until you type 'leave'.");
                leaveLoop = false;
            }
        }

        // Guessing game using do-while loop.
        int magicNum = 10;
        int gueNum = 0;
        int resNum;
        boolean gamOve = false;

        System.out.println("Let's play a number game! Guess a number and see if you are right!");

        do {
            System.out.println("Number of guesses: " + gueNum);
            // Add 1 to gueNum because we are currently guessing.
            gueNum++;

            // Let the player guess the number now. Let's see if they can get out.
            System.out.println("What is your guess? ");
            resNum = scanner.nextInt();

            // Test to see if we break the loop.
            if (resNum == magicNum) {
                // Break out of the loop you win!
                System.out.println("You guessed it! The answer was: " + magicNum);
                gamOve = true;
            } else {
                // Keep the loop going. Give them a hint.
                if (resNum < magicNum) {
                    System.out.println("The number is 'higher'.");
                } else if (resNum > magicNum) {
                    System.out.println("The number is 'lower'.");
                }
            }
        } while (gamOve == false);

        // Foreach loop and ArrayList test.
        ArrayList<String> fruits = new ArrayList<>(); // Create the ArrayList.

        // Add elements to it.
        fruits.add("Apple");
        fruits.add("Pineapple");
        fruits.add("Peach");
        fruits.add("Watermelon");

        // Print out the list.
        System.out.println("Here are my fruits I have: " + fruits);

        // Use for-each loop to display fruit with indexs then ask the user to edit index 1.
        int fruInd = 0;
        System.out.println("Here are my fruits I have, with their indexes: ");
        for (String fruit : fruits) {
            // Display them with indexes.
            System.out.println(fruit + ": " + fruInd);
            // Add 1 to the index for the next fruit.
            fruInd++;
        }

        String userFruit;
        System.out.println("I don't really like " + fruits.get(1) + ".");
        System.out.println("Can you change it to something else for me?");
        scanner.nextLine(); // Consume the empty string from the nextInt earlier. This happens because nextInt creates an empty string.
        // To fix this write something like this,
        // blahblah = scanner.nextInt()
        // scanner.nextLine() This way it gets consumed after the int is used.
        userFruit = scanner.nextLine();

        // Now change the list item.
        fruits.set(1, userFruit);

        System.out.println("Here is my fruits now. I like the change: " + fruits);

        // Now remove a fruit.
        System.out.println("I am going to remove a fruit.");
        fruits.remove(0);
        System.out.println("Here are my fruits now: " + fruits);

        // Close scanner to save on resources. Good Practice.
        scanner.close();
    }
 }
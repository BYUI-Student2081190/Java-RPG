/**
 * Hello Class Main - Start with this file and edit as we go.
 */

 // Import some libraries to use.
 import java.util.Scanner; // Import the scanner class to read inputs from user.

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

        // Close scanner to save on resources. Good Practice.
        scanner.close();
    }
 }
/**
 * This is the Game Class - This is where everything
 * in the main game will run.
 */

// Imported Libraries.
import java.util.Scanner; // Import the scanner class to read inputs from user.
import java.util.Arrays; // This is used for conversions of data.
import java.util.ArrayList; // Import the ArrayList class to create ArrayLists in program.
import java.util.HashMap; // Import the HashMap class to create HashMaps, and also to create a storage for enemies and maybe items.

public class Game {
    // Global Variables.
    private static Scanner scanner = new Scanner(System.in); // Added Scanner as a global variable.
    private static int gameSpeed = 25; // This changes how fast text flows in the game. This is currrently 25 miliseconds.
    public static Character character; // Default = null. This is the character made by the user for the game.
    private static HashMap<Integer, String> monsterHashMap = new HashMap<>(); // This will store all the monsters.
            
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

        // This function creates all the monster data in the hashmap before the game starts.
        private static void initMonsters() {
            // Start adding the data to the HashMap.
            // Enemy rules: enemyName, enemyId, enemyHealth, enemyAttack, enemyMind, enemyArmor, enemyMagicDef, enemyExpDrop, dropRate
            monsterHashMap.put(001, "Goblin!--!--!001!--!--!20!--!--!10!--!--!0!--!--!0!--!--!0!--!--!25!--!--!80");

            // Return to the main function.
            return;
        }

        // This function displays the battle UI with the enemy name and hp.
        private static void displayMonsterData(Enemy currEnemy) {
            // Make it so if their health goes below 0 that it displays as 0 on the ui.
            int enemyHealth;
            int characterHealth;

            // Do this for the enemy.
            if (currEnemy.isDead()) {
                enemyHealth = 0;
            } else {
                enemyHealth = currEnemy.getEnemyHealth();
            }

            if (character.isDead()) {
                characterHealth = 0;
            } else {
                characterHealth = character.getHealth();
            }
            // Display it to the user. This makes it easier to read down below.
            System.out.println("Enemy Name: " + currEnemy.getEnemyName() + "     HP: " + enemyHealth);
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Name: " + character.getCharacterName() + "     HP: " + characterHealth + " MP: " + character.getMagic());
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println();
        }

        // This function handles rpg combat with the enemy.
        private static void battleManager() {
            // Create the enemy you will fight edit this to be based on level for now just make the goblin.
            String monsterData = monsterHashMap.get(001);

            // Now split the data to make the monster.
            String[] monsterDataArray = monsterData.split("!--!--!");
            // Convert to an ArrayList using the Array class.
            ArrayList<String> monsterArrayList = new ArrayList<>(Arrays.asList(monsterDataArray));

            // Create variables to hold each enemy's stats.
            String enemyName = "Nothing";
            int enemyId = 0;
            int enemyHealth = 0;
            int enemyAttack = 0;
            int enemyMind = 0;
            int enemyArmor = 0;
            int enemyMagicDef = 0;
            int enemyExpDrop = 0;
            int dropRate = 0;
            int loopCount = 1;

            // Now loop through the data and create the monster for the battle.
            for (String stat : monsterArrayList) {
                // Variable to hold a number version of stat.
                int numStat = 0;
                // For each of these test if they are num. Also save them with the attribute that they deserve.
                if (isInt(stat)) {
                    // Make this equal to the stat as a num.
                    numStat = Integer.parseInt(stat);
                }

                switch (loopCount) {
                    case 1:
                        enemyName = stat;
                        break;
                    case 2:
                        enemyId = numStat;
                        break;
                    case 3:
                        enemyHealth = numStat;
                        break;
                    case 4:
                        enemyAttack = numStat;
                        break;
                    case 5:
                        enemyMind = numStat;
                        break;
                    case 6:
                        enemyArmor = numStat;
                        break;
                    case 7:
                        enemyMagicDef = numStat;
                        break;
                    case 8:
                        enemyExpDrop = numStat;
                        break;
                    case 9:
                        dropRate = numStat;
                        break;
                }

                // Now add one to loop count to keep it consistant with the data.
                loopCount++;
            }

            // Now create the enemy object.
            Enemy currEnemy = new Enemy(enemyName, enemyId, enemyHealth, enemyAttack, enemyMind, enemyArmor, enemyMagicDef, enemyExpDrop, dropRate);

            // Now display the enemy and start the battle in a loop.
            while (currEnemy.isDead() != true && character.isDead() != true) { // Make sure both the player and the enemy are not dead.
                // Create a variable to hold the user response.
                String userResponse;
                // Create a variable to let the enemy know it can do it's turn.
                boolean enemyTurnActive = false; // If this is true it can.
                
                clearConsole(); // Put this here just in case.
                displayMonsterData(currEnemy);
                printLetterByLetter("What would you like to do?"); // Start of player turn.
                printLetterByLetter("1.) Attack");
                printLetterByLetter("Please select the number of the option you would like: ");
                userResponse = scanner.nextLine();

                // Check the response to make sure it is ok.
                if (isInt(userResponse)) {
                    // We can now use it and see if it is a valid option.
                    int choice = Integer.parseInt(userResponse);

                    switch (choice) {
                        case 1:
                            // Go through with this action, which is attack.
                            // Call the attack function from the character and get the damage.
                            int characterDamage;
                            characterDamage = character.attackDamage();

                            // Call the calcDamage function from the enemy.
                            int enemyDamageTaken;
                            enemyDamageTaken = currEnemy.damageTaken(characterDamage); // This is what gets displayed.

                            // Display result of attack to user.
                            clearConsole();
                            displayMonsterData(currEnemy);
                            printLetterByLetter("You attack, and the " + currEnemy.getEnemyName() + " took " + enemyDamageTaken + " HP in damage.");
                            printLetterByLetter("Press Enter to Continue...");
                            scanner.nextLine();

                            // Set the enemy turn to active so the game can do it's turn.
                            enemyTurnActive = true; // Now the enemy can respond.

                            // Break case.
                            break;
                        default:
                            // Let the user know their input did nothing and needs to be inputed again.
                            // Set the enemy turn to not active so the game can loop back to the start.
                            enemyTurnActive = false;
                    }
                } else {
                    // Tell the user their error.
                    clearConsole();
                    printLetterByLetter("Your input was not a number. Please input the number matching the action you want.");
                    printLetterByLetter("Press Enter to Continue...");
                    scanner.nextLine();
                    clearConsole();
                }

                // Now the enemy's turn.
                if (currEnemy.isDead() != true && enemyTurnActive) {
                    // Now run the enemy's attack.
                    int enemyAttackDamage;
                    enemyAttackDamage = currEnemy.attackDamage();

                    // Calculate damage done to the player.
                    int characterDamageTaken;
                    characterDamageTaken = character.damageTaken(enemyAttackDamage);

                    // Display it to the player.
                    clearConsole();
                    displayMonsterData(currEnemy);
                    printLetterByLetter("The " + currEnemy.getEnemyName() + " attacks " + character.getCharacterName() + " and " + character.getCharacterPronoun() + " took " + characterDamageTaken + " HP in damage.");
                    printLetterByLetter("Press Enter to Continue...");
                    scanner.nextLine();
                }
            }

            // Check to see if the player has been defeated or the enemy has. Give messages based on those conditions.
            if (character.isDead()) {
                clearConsole();
                displayMonsterData(currEnemy);
                printLetterByLetter(character.getCharacterName() + " has been defeated...");
                printLetterByLetter("Press Enter to Continue...");
                scanner.nextLine();
            } else {
                clearConsole();
                displayMonsterData(currEnemy);
                printLetterByLetter(currEnemy.getEnemyName() + " has been defeated! " + character.getCharacterName() + " has won the battle!");
                printLetterByLetter(character.getCharacterName() + " has gained " + currEnemy.obtainExp() + " EXP!");
                // Add the exp to the character and test for levels.
                // Add condition if the character levels up.
                printLetterByLetter("Press Enter to Continue...");
                scanner.nextLine();
            }

            // Now return to the previous function.
            return;
        }

        // This function is used to run the quest that the player with run on.
        private static void questManager() {
            // Add the menu to choose the quest. This function will work heavily with the battle function.
            // Add some story to introduce the player to the world.
            if (character.getCharacterFirstTimeStat()) {
                // Quickly set the character's firsttimestat to false.
                character.setCharacterFirstTimeStat();

                // If a character is brand new this plays.
                printLetterByLetter("Sue the Guild Receptionist:");
                printLetterByLetter("Welcome to the 'Adventurer's Guild' now I bet you are excited to travel the world");
                printLetterByLetter("in search of treasure and the like. But let me warn you the evil and most cruel");
                printLetterByLetter("'Wizard' of the dark has taken over the country. He has made his monsterous minions");
                printLetterByLetter("take over the other towns and areas in the land. I will not try to stop you if you");
                printLetterByLetter("insist on going out there. But don't come crying to me if you get beaten out there.");
                System.out.println();
                printLetterByLetter("Press Enter to continue...");
                scanner.nextLine();

                // Next part of story.
                clearConsole();
                printLetterByLetter("Mark the Guild Master:");
                printLetterByLetter("Now Sue, I don't need you scaring another brave person out of this guild. Let me remind");
                printLetterByLetter("you who gives you your paycheck every evening. Welcome " + character.getCharacterName() + " to our guild.");
                printLetterByLetter("I am guessing you are a brave soul who wants to take on the evil wizard right? Well you could not have");
                printLetterByLetter("come to a better place! We need more young " + character.getCharacterStringGender() + "s like you in the world.");
                printLetterByLetter("Well if you think you got what it takes, I suggest you accept a quest and see if you can run all the way");
                printLetterByLetter("through it! Good luck! Sue make sure to take good care of this " + character.getCharacterStringGender() + ".");
                System.out.println();
                printLetterByLetter("Press Enter to continue...");
                scanner.nextLine();

                // Final part of story with user input to go on the quest.
                clearConsole();
                printLetterByLetter("Sue the Guild Receptionist:");
                printLetterByLetter("*sigh* Stinking Mark, always getting on me like that. Well I guess I can get you set up now.");
                printLetterByLetter("Here is how a quest runs, you go out and fight your way through the quest, and then you encounter");
                printLetterByLetter("a bigger monster at the end. If you end up getting defeated that is ok, just come back here and we will");
                printLetterByLetter("stitch you back together again, and no that is not in my job description. You can either do a small,");
                printLetterByLetter("medium, or large quest. Each one requires you to fight a different number of monsters before you finish.");
                printLetterByLetter("Since you are new, I suggest a 'small' quest, but who am I to stop you?");
                System.out.println();
                printLetterByLetter("Press Enter to continue...");
                scanner.nextLine();
            } else {
                // Special story for returning character.
                printLetterByLetter("Sue the Guild Receptionist:");
                printLetterByLetter("Oh hey welcome back! Is that scrape new? I am only pulling your leg, don't look like I hit you with");
                printLetterByLetter("a chicken or something. Jeez, what did I do to deserve working with you?");
                System.out.println();
                printLetterByLetter("Press Enter to continue...");
                scanner.nextLine();
            }

            // Option menu. Create a loop and some humor.
            boolean breakLoop = false;
            boolean firstTime = true; // Create a goofy variable to make Sue upset at the player if they do not select a proper option.
            int choice = 0; // Place this up here so it can be used after the loop breaks.

            while (breakLoop != true) {
                clearConsole();
                if (firstTime == true){
                    // First time message.
                    printLetterByLetter("Sue the Guild Receptionist:");
                    printLetterByLetter("Ok " + character.getCharacterName() + ", what type of quest are you thinking of doing?");
                    System.out.println();
                    printLetterByLetter("1.) Small Quest (About: 5 Monsters)");
                    printLetterByLetter("2.) Medium Quest (About: 10 Monsters)");
                    printLetterByLetter("3.) Large Queset (About: 15 Monsters)");
                    System.out.println();
                    printLetterByLetter("Hun, please tell me the number of the option you would like to do.");
                    // Quickly set firsttime to false.
                    firstTime = false;
                } else {
                    // Second time message.
                    printLetterByLetter("Sue the Guild Receptionist:");
                    printLetterByLetter(character.getCharacterName() + ", hun, this honestly is not that hard to do.");
                    printLetterByLetter("Just tell me the number of the one you want to do out of these three:");
                    System.out.println();
                    printLetterByLetter("1.) Small Quest (About: 5 Monsters)");
                    printLetterByLetter("2.) Medium Quest (About: 10 Monsters)");
                    printLetterByLetter("3.) Large Queset (About: 15 Monsters)");
                    System.out.println();
                    printLetterByLetter("Hun, if you just do this, then we can both get a break from eachother...");
                }
                // Create a variable to hold the user response.
                String userResponse;
                userResponse = scanner.nextLine();

                // Check the response and send the player on their quest.
                if (isInt(userResponse)){
                    // Parse the int and move on.
                    choice = Integer.parseInt(userResponse);

                    // Check to see if choice is in range.
                    if (choice >= 1 && choice <= 3) {
                        // Set the loop to break because choice is good.
                        clearConsole();
                        breakLoop = true;
                    } else {
                        clearConsole();
                        printLetterByLetter("Your response was not a selectable number, please enter 1, 2, or 3.");
                        printLetterByLetter("Press Enter to continue...");
                        scanner.nextLine();
                        clearConsole();
                    }
                } else {
                    // Let the user know their error.
                    clearConsole();
                    printLetterByLetter("Your response was not a number, please enter a number.");
                    printLetterByLetter("Press Enter to continue...");
                    scanner.nextLine();
                    clearConsole();
                }
            }
            // Create a varible to hold how many monsters the player must face.
            int encounters;

            switch (choice) {
                case 1:
                    encounters = 5; // Small.
                    break;
                case 2:
                    encounters = 10; // Medium.
                    break;
                case 3:
                    encounters = 15; // Large.
                    break;
                default:
                    encounters = 5; // Defaults to small if problem happens.
            }
            // Create one last piece of story to let the player know everything worked.
            printLetterByLetter("Sue the Guild Receptionist:");
            printLetterByLetter("You are all set hun, knock em dead!");
            System.out.println();
            printLetterByLetter("Press Enter to continue... are you scared?");
            scanner.nextLine();
            clearConsole();

            // Now create a for loop that calls the battle function to create battles based on the encounters.
            for (int i = 1; i <= encounters; i ++) {
                // Clear the console on each loop just in case it is needed.
                clearConsole();
                // Make sure the character is still alive each loop.
                if (character.isDead() != true) {
                    // Let the player get their barrings and start them with this message.
                    printLetterByLetter("As you go about your quest a monster appears! Battle: " + i);
                    
                    printLetterByLetter("Press Enter to begin the match!");
                    scanner.nextLine();
                    clearConsole();

                    // Call the function.
                    battleManager();
                } else {
                    // Break the loop because the player has been defeated.
                    break;
                }
            }

            // Create story for a sucessful run, and a not successful run, also heal the character at the end of both.
            clearConsole();

            if (character.isDead()) {
                // Create story to react to the dead character.
                printLetterByLetter("Sue the Guild Receptionist:");
                printLetterByLetter("Huh who's that? WHAT!? You say you found " + character.getCharacterPronoun() + " out there knocked out. Thank you for bringing " + character.getCharacterPronoun() + " to us.");
                printLetterByLetter("We will treat " + character.getCharacterPronoun() + " right away.");
                System.out.println();
                printLetterByLetter("How are you feeling hun? You look like you are doing better. Don't scare me like that! Come back after getting some rest...");
                System.out.println();
                printLetterByLetter("Press Enter to Continue...");
                scanner.nextLine();
                clearConsole();
            } else {
                // Create story to react to the winning character.
                printLetterByLetter("Sue the Guild Receptionist:");
                printLetterByLetter("Welcome back hun, looks like you survived. That's a first.");
                printLetterByLetter("Come back when you want to challege the 'Wizard's' forces again you hear?");
                System.out.println();
                printLetterByLetter("Press Enter to Continue...");
                scanner.nextLine();
                clearConsole();
            }

            // Now fully heal the character.
            character.fullHeal();

            // Now return to the past function.
            return;
        }
    
        // This function contains the Character Creator.
        private static void characterCreator() {
            // Create the menu.
            boolean leaveMenu = false;
            String firstName;
            String lastName;
            int gender = 0;
            int age = 0;
            String species;
            int job = 0;
            String userInput;
    
            // Create a UI for them to type in the information.
            printLetterByLetter("Lets start creating your dream character!");
            printLetterByLetter("This can be either yourself, or someone you make up, it is all up to you!");
            printLetterByLetter("First Question what is their first name? ");
            firstName = scanner.nextLine();
    
            clearConsole();
            printLetterByLetter("Second Question what is their last name? ");
            lastName = scanner.nextLine();
    
            clearConsole();
            while (leaveMenu != true) {
                printLetterByLetter("Are they: ");
                printLetterByLetter("1.) Male");
                printLetterByLetter("2.) Female");
                printLetterByLetter("Type the number of which one they are: ");
                userInput = scanner.nextLine();
    
                // Test the input to see if it is a number.
                if (isInt(userInput)) {
                    // Convert to number.
                    int choice = Integer.parseInt(userInput);
    
                    switch (choice) {
                        case 1:
                            // Set the gender of the character.
                            gender = choice;
                            // Kill loop.
                            leaveMenu = true;
                            // Clear Console.
                            clearConsole();
                            // break.
                            break;
                        case 2:
                            gender = choice;
                            leaveMenu = true;
                            clearConsole();
                            break;
                        default:
                            clearConsole();
                            printLetterByLetter("Your input was not 1 or 2. Please make sure to enter only 1 or 2.");
                            printLetterByLetter("Press Enter to Continue...");
                            scanner.nextLine();
                            clearConsole();
                    }
                } else {
                    clearConsole();
                    printLetterByLetter("Your input was not a number. Please enter a number.");
                    printLetterByLetter("Press Enter to Continue...");
                    scanner.nextLine();
                    clearConsole();
                }
            }
    
            // Set menu loop to false again.
            leaveMenu = false;
    
            // Get their age, and make sure it is an int.
            while (leaveMenu != true) {
                printLetterByLetter("What is their age? ");
                userInput = scanner.nextLine();
    
                if (isInt(userInput)) {
                    // Break the loop.
                    leaveMenu = true;
                    // Convert to int.
                    age = Integer.parseInt(userInput);
                    clearConsole();
                } else {
                    // Keep looping until they put a number.
                    clearConsole();
                    printLetterByLetter("Your input was not a number. Please enter a number.");
                    printLetterByLetter("Press Enter to Continue...");
                    scanner.nextLine();
                    clearConsole();
                }
            }
    
            // After the loop set the loop break to false again.
            leaveMenu = false;
    
            // Now get the species.
            printLetterByLetter("What species are they? ");
            species = scanner.nextLine();
            clearConsole();
    
            // Now get the job with a loop.
            while (leaveMenu != true) {
                printLetterByLetter("What job are they: ");
                printLetterByLetter("1.) Warrior");
                printLetterByLetter("2.) Mage");
                printLetterByLetter("3.) Healer");
                printLetterByLetter("4.) Clown");
                printLetterByLetter("Type the number of which one they are: ");
                userInput = scanner.nextLine();
    
                // Test the input to see if it is a number.
                if (isInt(userInput)) {
                    // Convert to number.
                    int choice = Integer.parseInt(userInput);
    
                    switch (choice) {
                        case 1:
                            // Set the gender of the character.
                            job = choice;
                            // Kill loop.
                            leaveMenu = true;
                            // Clear Console.
                            clearConsole();
                            // break.
                            break;
                        case 2:
                            job = choice;
                            leaveMenu = true;
                            clearConsole();
                            break;
                        case 3:
                            job = choice;
                            leaveMenu = true;
                            clearConsole();
                            break;
                        case 4:
                            job = choice;
                            leaveMenu = true;
                            clearConsole();
                            break;
                        default:
                            clearConsole();
                            printLetterByLetter("Your input was not one of the numbers. Please make sure to enter on of the listed numbers.");
                            printLetterByLetter("Press Enter to Continue...");
                            scanner.nextLine();
                            clearConsole();
                    }
                } else {
                    clearConsole();
                    printLetterByLetter("Your input was not a number. Please enter a number.");
                    printLetterByLetter("Press Enter to Continue...");
                    scanner.nextLine();
                    clearConsole();
                }
            }
    
            // Now create the character.
            character = new Character(firstName, lastName, gender, age, species, job);

            // Now display the created character for the user.
            printLetterByLetter("Here is your finished character:");
            System.out.println();
            String stats = character.getStats();
            printLetterByLetter(stats);
            System.out.println();
            printLetterByLetter("Press Enter to Continue...");
            scanner.nextLine();
            clearConsole();

            // Now return to the previous function.
            return;
    }

    // This function contains the Character Menu.
    private static void characterMenu() {
        // Create new menu.
        boolean leaveMenu = false;
        String userInput; // Empty user input varible.

        while (leaveMenu != true) {
            printLetterByLetter("Welcome to the Character Creator!");
            printLetterByLetter("Here you can make, save, and even load characters you like for the game.");
            printLetterByLetter("What would you like to do today?");
            printLetterByLetter("1.) Create New Character.");
            printLetterByLetter("2.) Save Created Character.");
            printLetterByLetter("3.) Load In Previous Character.");
            printLetterByLetter("4.) View Current Character.");
            printLetterByLetter("5.) Go Back to Main Menu.");
            printLetterByLetter("Please type the number of the option you would like to do: ");
            userInput = scanner.nextLine();
            
            // Check to see if input is a number.
            if (isInt(userInput)) {
                // Convert the type.
                int choice = Integer.parseInt(userInput);

                // Select the option.
                switch (choice) {
                    case 1:
                        // Clear the console.
                        clearConsole();
                        // Call the character creator function.
                        characterCreator();
                        // Break the case.
                        break;
                    case 2:
                        // Clear the console.
                        clearConsole();
                        // Call the save character function.
                        printLetterByLetter("Lets save them!"); // Add this later.
                        // Break the case.
                        break;
                    case 3:
                        // Clear the console.
                        clearConsole();
                        // Call the load character function.
                        printLetterByLetter("Lets load them!"); // Add this later.
                        // Break the case.
                        break;
                    case 4:
                        // Clear the console.
                        clearConsole();
                        // Call the character stats function, only if it is not null.
                        if (character == null) {
                            // Encourage them to make a character because one does not exsist yet.
                            printLetterByLetter("Your do not have a character active yet.");
                            printLetterByLetter("Please go load one, or make a new one.");
                            printLetterByLetter("Press Enter to Continue...");
                            scanner.nextLine();
                            // Clear the console again.
                            clearConsole();
                        } else {
                            // View the character.
                            printLetterByLetter("Character's current stats: ");
                            System.out.println();
                            printLetterByLetter(character.getStats());
                            System.out.println();
                            printLetterByLetter("Press Enter to Continue...");
                            scanner.nextLine();
                            // Clear the console again.
                            clearConsole();
                        }
                        // Break the case.
                        break;
                    case 5:
                        // Clear the console.
                        clearConsole();
                        // Set leave menu to true to leave the function.
                        leaveMenu = true;
                        // Break the case.
                        break;
                    default:
                        // Clear the console.
                        clearConsole();
                        // Let the user know the mistake.
                        printLetterByLetter("Your number was not one of the options. Please select one of the options.");
                        printLetterByLetter("Press Enter to Continue...");
                        scanner.nextLine();
                        // Clear the console again.
                        clearConsole();
                }
            } else {
                // Give them the first error input.
                clearConsole();
                printLetterByLetter("Your input was not a number. Please enter the number of the option.");
                printLetterByLetter("Press Enter to Continue...");
                scanner.nextLine();
                clearConsole();
            }
        }
        // Now return to the previous function.
        return;
    }

    // Main class. This runs at the start.
    public static void main(String[] args) {
        // Before the game even runs, start preparing game.
        initMonsters();

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
            // Create the character.
            printLetterByLetter("1.) Create Character");
            // Quest Option. (Cannot go on a quest until the character has been created.)
            printLetterByLetter("2.) Go On a Quest");
            // Add Settings Option.
            printLetterByLetter("3.) Quit");
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
                        characterMenu();
                        break;
                    case 2:
                        // Clear the console for next action.
                        clearConsole();
                        // Check and see if a character has been made, or loaded.
                        if (character == null) {
                            // Let the player know they need to have a character before they can go on a quest.
                            printLetterByLetter("I know you are excited to go on a quest, however...");
                            printLetterByLetter("It would be wise to have a character before you go.");
                            printLetterByLetter("I don't think you can do much in the state you are in.");
                            System.out.println();
                            printLetterByLetter("Press Enter to return to the previous menu, and please come back\nwith a character.");
                            scanner.nextLine(); 
                            // After they press enter clear the console.
                            clearConsole();
                        } else {
                            // Clear the console again.
                            clearConsole();
                            // Call the next function to start the quest.
                            questManager();
                        }
                        // Break the case.
                        break;
                    case 3:
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
    }
}
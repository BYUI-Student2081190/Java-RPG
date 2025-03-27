# Overview

The goal of this little project was to prove to myself I could make an RPG like game. I have always loved games like Final Fantasy and I have always wanted to make one. I decided since I wanted to learn Java this was the perfect opportunity for me to do this. My purpose was to make sure I could understand and code in Java within 2 weeks of starting this project. This was intense and I learned a lot about Java and RPG like games in general. I also learned more about Java's unique and different syntax, I am pretty used to C# so Java was a tiny bit different than it, but overall Java just felt like a distant cousin to C#. Which made understandning it very easy.

This project is very crude right now but it allows you to make a character, give them a job, save that character, load that character, fight three unique enemies, and go on a battle gauntlet style game where you have to win a certain number of battles to win. It also features a working level up system and stat growth. One of the more fun features is a little fun story that I came up with, it is super simple but keeps the game a little more entertaining. This was an amazing growth experience and I hope to spend more time with this project to keep improving it in every way possible.

# Development Environment

To develop this software I used VSCode. To do this I had to install these extensions: Language Support for Java™ by Red Hat, Debugger for Java,Test Runner for Java, Maven for Java, Project Manager for Java, Visual Studio IntelliCode. These all came in the Java Extension Pack on VSCode's website. 

Because I was using Java I decided to use about ten different libraries that the language had. I used "scanner" this library allowed me to take in user inputs inside the terminal for menu and gameplay options. I also used "Arrays" and "ArrayList" these were used to store data in a list and "Arrays" was used to convert a normal Java array into an "ArrayList". I also used "HashMap" this is pretty much a Java dictonary. I used it to save enemy data so I could turn that data into a enemy object when a battle began. I used "Random" to help generate random numbers for leveling up and adjusting character stats on level. I used "BufferedWriter", "FileWriter", "BufferedReader", "FileReader", and "IOException". These were all used to read and write to text files to save the player's character, and "IOException" was used to help throw errors if a problem happened with the file we were using. All these libraries really helped me code this project and helped keep it orginized.

# Useful Websites

- [Visual Studio Code - Getting Started with Java in VSCode](https://code.visualstudio.com/docs/java/java-tutorial)
- [W3Schools - Java Variables](https://www.w3schools.com/java/java_variables.asp)
- [W3Schools - Java User Input (Scanner Class)](https://www.w3schools.com/java/java_user_input.asp)
- [W3Schools - Java Conditions and If Statements](https://www.w3schools.com/java/java_conditions.asp)
- [W3Schools - Java Switch](https://www.w3schools.com/java/java_switch.asp)
- [W3Schools - Java Operators](https://www.w3schools.com/java/java_operators.asp)
- [W3Schools - Java Methods](https://www.w3schools.com/java/java_methods.asp)
- [W3Schools - Java For Loops](https://www.w3schools.com/java/java_for_loop.asp)
- [W3Schools - Java While Loops](https://www.w3schools.com/java/java_while_loop.asp)
- [W3Schools - Java Do-While Loops](https://www.w3schools.com/java/java_while_loop_do.asp)
- [W3Schools - Java For-Each Loops](https://www.w3schools.com/java/java_foreach_loop.asp)
- [W3Schools - Java Arrays](https://www.w3schools.com/java/java_arrays.asp)
- [W3Schools - Java ArrayList](https://www.w3schools.com/java/java_arraylist.asp)
- [W3Schools - Java HashMaps](https://www.w3schools.com/java/java_hashmap.asp)
- [W3Schools - Java Classes and Objects](https://www.w3schools.com/java/java_classes.asp)
- [W3Schools - Java Read Files](https://www.w3schools.com/java/java_files_read.asp)
- [YouTube - Coding With John: Java File Input/Output - It's Way Easier Than You Think](https://www.youtube.com/watch?v=ScUJx4aWRi0)

# Future Work

- One thing I want to add to this game is items. I want the user to be able to collect items from defeated monsters. There is actually a stat in the Enemy class that was going to handle enemy drop rates for items but due to the dead line I gave myself this was scrapped later in the project.
- One thing I would like to improve on the game is to make it so a character can actually use all their stats. They have so many and I was planning to give them the ability to use magic, skills, and also take different forms of damage from enemies like magic damage and so on. This boils down to I want to improve the combat in my game. It needs a little bit more work.
- The final thing I want to fix right now is how damage and exp needed to level up again is calculated in the game. Right now it works fine for a basic RPG but if this was a long term game this would need to be fixed and managed a little better than how I did it here.
/*
* This program gets user's choice, converts the choice to integer in enum,
* generate random number between 0 to 2, matches with these two numbers
* and show the converted random choice and result.
*
* @author  Jay Lee
* @version 1.0
* @since   2020-05-09
*/
// package ca.mths.assignment.assignment02.java.main;

import java.util.Scanner;
import java.util.Random;

public final class RockPaperScissors {
    // constant
    /** Rock, paper and scissors. */
    static final int CHOICES = 3;

    private RockPaperScissors() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    public enum Choice {
        /** Rock : 0, Paper : 1, Scissors : 2. */
        ROCK(0), PAPER(1), SCISSORS(2);

        /** Integer value of rock, paper scissors. */
        private final int value;

        Choice(final int num) {
            value = num;
        }
        /**
        * This method returns choice as integer.
        * @return value
        */
        public int choiceNumber() {
            return value;
        }
    }

    /**
    * This method gets gets user's choice, converts the choice to integer,
    * matches with random number and shows the random choice and result.
    * @param args
    */
    public static void main(final String[] args) {
        Scanner myObj = new Scanner(System.in);
        Random random = new Random();
        Choice userChoice;
        String computerChoice;
        String result = "";

        // Input
        System.out.print("Rock, Paper, Scissors?\nYOU: ");
        String userInput = myObj.nextLine();

        // Generate random number for computer's choice
        int randomChoice = random.nextInt(CHOICES);

        try {
            userChoice = Choice.valueOf(userInput.toUpperCase());

            // Check win, lose or tie
            if (userChoice.choiceNumber() == randomChoice) {
                result = "tie!";
            } else if (userChoice.choiceNumber()
                                == (randomChoice + 1) % CHOICES) {
                result = "win!";
            } else {
                result = "lose!";
            }
            // Convert computer's choice to String ex: ROCK => Rock
            computerChoice = Choice.values()[randomChoice].name();
            computerChoice = computerChoice.substring(0, 1)
                             + computerChoice.substring(1).toLowerCase();

            // Output
            System.out.println("COM: " + computerChoice);
            System.out.println("You " +  result);

        } catch (Exception invalidInput) {
            System.err.print("Invalid input.");
        }

        System.out.println("\nDone.");
    }
}

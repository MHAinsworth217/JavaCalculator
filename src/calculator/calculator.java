// Grouped in calculator package
package calculator;

// Import relevant packages

import java.nio.charset.IllegalCharsetNameException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class calculator {

    // Initialise variables
    static double firstNum, secondNum;
    static int selection;
    static String yn;

    public static void main(String[] args) {

        // Create new scanner called input for user
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Matt's calculator!");
        System.out.println("Please enter the first number: ");

        // While loop for error handling
        while (true) {
            try {
                firstNum = input.nextDouble();
                break;
            } catch (InputMismatchException e) { // Catches if the user doesn't enter a double
                System.out.println("Sorry I don't understand. Please enter a number.");
                input.next();
            }

        }
        System.out.println("Please enter the second number: ");
        // While loop for the same as the first number
        while (true) {
            try {
                secondNum = input.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Sorry I don't understand. Please enter a number.");
                input.next();
            }

        }
        // Blank line
        System.out.println("");
        System.out.println("What would you like to do with these numbers?" +
                "\n1: Add" +
                "\n2: Subtract" +
                "\n3: Multiply" +
                "\n4: Divide" +
                "\n0: Exit");
        // While loop to ensure the user enters a double within the range
        while (true) {
            try {
                selection = input.nextInt();
                if (!(selection == 1)
                        && !(selection == 2)
                        && !(selection == 3)
                        && !(selection == 4)
                        && !(selection == 0)) {
                    System.out.println("Please enter a valid number from the following:" +
                            "\n1: Add" +
                            "\n2: Subtract" +
                            "\n3: Multiply" +
                            "\n4: Divide" +
                            "\n0: Exit");
                } else
                    break;
            } catch (InputMismatchException e) {
                System.out.println("Sorry I don't understand. Please enter a number.");
                input.next();
            }
        }

        // Create new instance of Number Cruncher called maths
        NumberCruncher maths = new NumberCruncher();

        // Run the setAns method
        maths.setAns(selection, firstNum, secondNum);
        // Print the answer
        System.out.println("The answer is " + maths.getAns());
        System.out.println("");
        input.nextLine();

        while (true) {
            System.out.println("Would you like to do something else with this number? y/n");
            yn = input.nextLine();
            if (yn.toLowerCase().equals("y")) {
                firstNum = maths.getAns();
                System.out.println("Please enter another number");
                while (true) {
                    try {
                        secondNum = input.nextDouble();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Sorry I don't understand. Please enter a number.");
                        input.next();
                    }
                }
                System.out.println("What would you like to do with these two numbers:" +
                        "\n1: Add" +
                        "\n2: Subtract" +
                        "\n3: Multiply" +
                        "\n4: Divide" +
                        "\n0: Exit");
                while (true) {
                    try {
                        selection = input.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("I don't understand, please enter a number from the following:" +
                                "\n1: Add" +
                                "\n2: Subtract" +
                                "\n3: Multiply" +
                                "\n4: Divide" +
                                "\n0: Exit");
                        input.next();
                    }
                }
                if (!(selection == 1)
                        && !(selection == 2)
                        && !(selection == 3)
                        && !(selection == 4)
                        && !(selection == 0)) {
                    System.out.println("Please enter a valid number from the following:" +
                            "\n1: Add" +
                            "\n2: Subtract" +
                            "\n3: Multiply" +
                            "\n4: Divide" +
                            "\n0: Exit");
                } else {
                    maths.setAns(selection, firstNum, secondNum);
                }
                System.out.println("The answer is " + maths.getAns());
                input.nextLine();
            } else if (yn.toLowerCase().equals("n")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Please enter either y or n.");
            }
        }
    }
}
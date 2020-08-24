// Grouped in package: calculator
package calculator;

// Import the correct packages
import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberCruncher {
    // Initialise answer variable
    private double ans;

    // Setter method to set the answer of the calculation
    public void setAns(int selection, double firstNum, double secondNum) {
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                // Addition
                if (selection == 1) {
                    ans = firstNum + secondNum;
                    break;
                // Subtraction
                } else if (selection == 2) {
                    ans = firstNum - secondNum;
                    break;
                // Multiplication
                } else if (selection == 3) {
                    ans = firstNum * secondNum;
                    break;
                //Division
                } else if (selection == 4) {
                    ans = firstNum / secondNum;
                    break;
                } else if (selection == 0) {
                    System.exit(0);
                    System.out.println("Goodbye!");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Sorry, I didn't understand. Please enter an integer from the options.");
                input.next();
                continue;
            }
        }
    }

    // Getter method to get the answer
    public double getAns(){
        return ans;
    }
}

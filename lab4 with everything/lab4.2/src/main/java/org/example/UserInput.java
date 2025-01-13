package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static int getUserNum(){
        // Declare the variables
        int num = 0;

        // Input the integer
        System.out.println("Enter the integer: ");
        try {
            // Read the next integer from the screen
            num = UserInput.scanner.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("PLEASE ENTER INTGER ONLY");
            scanner.next(); // Clear the invalid input from the scanner
        }
        // Display the integer
        System.out.println("Entered a number is: " + num);
        if (num <=0 ){
            System.out.println("INVALID INTGER");
            return getUserNum();
        }
        return num;
    }

}

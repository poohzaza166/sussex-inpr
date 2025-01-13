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
            UserInput.scanner.next(); // Clear the invalid input from the scanner
        }
        // Display the integer
        System.out.println("Entered a number is: " + num);
        if (num <=0 ){
            System.out.println("INVALID INTGER");
            return getUserNum();
        }
        return num;
    }

    public static String getUserString(){
        String target = "";
        System.out.println("Enter the String: ");
        try {
            target = UserInput.scanner.nextLine();
        }
        catch (InputMismatchException e){
            System.out.println("some how this error it self out if so you did somethign really bad");
            UserInput.scanner.next();
        }
        if (target.equals("")){
            System.out.println("Please enter the actual string and not leave it emtpy");
            return getUserString();
        }
        return target;
    }

}

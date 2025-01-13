import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// replaced helper utils input class with my own implementation
// This code is written by Bhumin Sabsrisupachai for use in corse work
// ideally should not be reproduced or coppied without perission

public class UserInput {
    private static Scanner scanner = new Scanner(System.in);
    private static final Pattern emailPattern = Pattern.compile("\\w+@\\w+\\.(com|net|org|edu|ac\\.uk){1}");

    public static int getUserNum(){
        // Declare the variables
        int num = -1;

        // Input the integer
        System.out.println("Enter the integer: ");
        try {
            // Read the next integer from the screen
            num = UserInput.scanner.nextInt();
            UserInput.scanner.nextLine();
        }
        catch (InputMismatchException e){
            System.out.println("PLEASE ENTER INTGER ONLY");
            UserInput.scanner.next(); // Clear the invalid input from the scanner
        }
        // Display the integer
        System.out.println("Entered a number is: " + num);
        return num;
    }

    public static int getUserNum(String input){
        System.out.println(input);
        return getUserNum();
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

    public static String getUserString(String input){
        System.out.println(input);
        return getUserString();
    }

    public static String getNullableString(){
        System.out.println("Enter the String: ");
        String target = UserInput.scanner.nextLine();
        return target;
    }

    public static String getNullableString(String input){
        System.out.println(input);
        return getUserString();
    }

    public static String getUserEmail(){
        String target = "";
        System.out.println("Please enter a email");
        try{
            target = UserInput.scanner.next();
            UserInput.scanner.nextLine();
        }
        catch (InputMismatchException e){
            System.out.println("some how this error it self out if so you did somethign really bad");
            UserInput.scanner.next();
        }
        if (target.equals("")){
            System.out.println("Please enter somethign like a valid email address");
            return getUserEmail();
        }
        Matcher matcher = emailPattern.matcher(target);
        if (!matcher.find()){
            System.out.println("Malformed email address try again");
            return getUserEmail();
        }
        return target;
    }

    public static String getUserEmail(String input){
        System.out.println(input);
        return getUserEmail();
    }
}

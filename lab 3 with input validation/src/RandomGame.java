import java.awt.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RandomGame {

    private static int guessNum = 0;
    private static Scanner scanner = new Scanner(System.in);
    private static int numAttempt = 10;


    private static int genrateNumber(){
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int mysteryNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        RandomGame.guessNum = mysteryNumber;
        return mysteryNumber;
    }


    private static int getUserNum(){
        // Declare the variables
        int num = 0;

        // Input the integer
        System.out.println("Enter the integer: ");
        try {
            // Read the next integer from the screen
            num = RandomGame.scanner.nextInt();
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

    // this function validate if the user guessed correctly
    // this function also return true when guess is correct
    private static boolean checkGuess(int guess){
        if (guess > RandomGame.guessNum){
         System.out.println("Hey your Guest is too high");
         return false;
         }
         else if (guess < RandomGame.guessNum ) {
             System.out.println("hey your guest is too low");
             return false;
         }
         else {
             return true;
         }
        }

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        RandomGame.genrateNumber();
        System.out.println("please enter the ammount of attempt you are goning to give your self");
        RandomGame.numAttempt = RandomGame.getUserNum();
        System.out.println("ok begining the game!");
        System.out.printf("giveing you a total of %d try \n", numAttempt);

        boolean hasGuessedCorrectly = false;


        while (!hasGuessedCorrectly) {
            int num = RandomGame.getUserNum();
            hasGuessedCorrectly = checkGuess(num);
            numAttempt --;
            if (numAttempt <= 0){
                System.out.println(numAttempt);
                System.out.println("you have rand out of attempt");
                break;
            }

        }
        if (hasGuessedCorrectly == true) {
            System.out.printf("Congraguation you have guessed the correct number \nIt took you %d try.\n", numAttempt);
        }
        RandomGame.scanner.close(); // free the resource
    }
}

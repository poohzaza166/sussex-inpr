import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class RandomGame {

    private static int guessNum = 0;
    private static Scanner scanner = new Scanner(System.in);
    private static int numAttempt = 0;


    private static int genrateNumber(){
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int mysteryNumber = random.nextInt(upperBound java formatted string- lowerBound + 1) + lowerBound;
        RandomGame.guessNum = mysteryNumber;
        return mysteryNumber;
    }


    private static int getUserNum(){
        // Declare the variables
        int num;

        // Input the integer
        System.out.println("Enter the integer: ");

        // Read the next integer from the screen
        num = RandomGame.scanner.nextInt();

        // Display the integer
        System.out.println("Entered integer is: " + num);

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


        boolean hasGuessedCorrectly = false;


        while (!hasGuessedCorrectly) {
            int num = RandomGame.getUserNum();
            hasGuessedCorrectly = checkGuess(num);
            numAttempt += 1;

        }
        System.out.printf("Congraguation you have guessed the correct number \nIt took you %d try.\n", numAttempt);
        RandomGame.scanner.close(); // free the resource
    }
}

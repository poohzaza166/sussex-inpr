package org.example;


import java.util.ArrayList;
import java.util.Random;

public class CodeGen    {
    private static final int MIN_CODE = 100;
    private static final int MAX_CODE = 999;

    public static void main() {
        // Generate the target 3-digit code
        int targetCode = generateRandom3DigitCode();
        System.out.println("Target Code: " + targetCode);

        // ArrayList to store generated codes
        ArrayList<Integer> generatedCodes = new ArrayList<>();

        // Generate random 3-digit codes until a match is found
        int generatedCode;
        int attempts = 0;
        int matchedCodeInstance = 0;

        // TO DO - the loop
        boolean match = false;
        while (!match){
            generatedCode = generateRandom3DigitCode();
            if (generatedCode == targetCode){
                match = true;
                System.out.println("the matching number is " + generatedCode);
            }
            attempts += 1;
            if (generatedCodes.contains(generatedCode) == false){
                generatedCodes.add(generatedCode);
                System.out.println("finally a new code had been found");
            }
            else {
                matchedCodeInstance +=1;
                System.out.println("same code have been found");
            }

        }


        System.out.println("Match found after " + attempts + " attempts.");

        // Print the generated codes
        System.out.println("Generated Codes: " + generatedCodes);
        System.out.println("the program have genrated the code that is aleardy in the list " + matchedCodeInstance + "times");
    }


    /**
     * Generates a random 3-digit code.
     *
     * @return The randomly generated 3-digit code.
     */
    private static int generateRandom3DigitCode() {
        Random random = new Random();
        return MIN_CODE + random.nextInt(MAX_CODE - MIN_CODE + 1);
    }

}

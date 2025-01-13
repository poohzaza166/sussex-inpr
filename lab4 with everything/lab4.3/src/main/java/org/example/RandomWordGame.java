package org.example;

import java.sql.SQLOutput;
import java.util.Random;

public class RandomWordGame {
    static String[] wordList = {"cat",
            "mouse",
            "dogs"};

    static int turnCount = 0;
    static int index = 0;

    /// This is a validation function to check if the instance contained the rigth character or word or not
    // return 0 if correct
    // return 1 if partially correct
    // return 2 if fail
    private static int isCorrect(String target){
        //check if word guest correct
        if (wordList[index].contentEquals(target)){
            return 0;
        }
        else if (wordList[index].contains(target)){
            return 1;
        }

        else{
            return 2;
        }
    }

    private static void pickWord(){
        Random random = new Random();
        index = random.nextInt(wordList.length);
        // debuging code
        System.out.println(wordList[index]);
    }

    private static String compareStrings(String str1, String str2) {
        // Make strings same length by padding shorter one with spaces
        int maxLength = Math.max(str1.length(), str2.length());
        str1 = String.format("%-" + maxLength + "s", str1);
        str2 = String.format("%-" + maxLength + "s", str2);

        StringBuilder result = new StringBuilder();

        // Compare each character
        for (int i = 0; i < maxLength; i++) {
            // Check if current character exists in str2 anywhere
            char currentChar = str1.charAt(i);
            if (str2.indexOf(currentChar) != -1) {
                result.append(currentChar);
            } else {
                result.append('_');
            }
        }

        return result.toString();
    }

    private static void setGuest(){
        System.out.println("please enter the number of guess turn you might want to have");
        turnCount = UserInput.getUserNum();
    }

    private static void gameLoop(){
        // init actual variable
        String guessChar  = "";
        int iscorrect = 2;

        while (iscorrect != 0){
            String userInput = UserInput.getUserString();
            iscorrect = isCorrect(userInput);

            if( iscorrect == 1){
                guessChar = compareStrings(wordList[index], userInput+=guessChar);
                System.out.println(guessChar);
                // extra check if user type all the guess in correctly
                iscorrect = isCorrect(guessChar.replaceAll("_",""));

            }

            switch (turnCount){
                case 0:
                    System.out.println("you have went over the your estimated turn that you have set your self");
                case 1:
                    System.out.println("you have ONE MORE turn left");
                default:
                    if (turnCount > 0){
                        System.out.println("you have mutiple turn left");
                    }
                    else {
                        System.out.printf("you have use %d guessd more than estimate \n", turnCount * -1);

                    }
            }
            turnCount --;
            System.out.println("your guess is incorrect");
        }
    }
    public static void initGame(){
        System.out.println("starting the game");
        pickWord();
        setGuest();
        gameLoop();
    }
}

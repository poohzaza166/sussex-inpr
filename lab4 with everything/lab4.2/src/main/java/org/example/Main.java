package org.example;

public class Main {

    static int processNum(int input){
        int outputNumber = 0;
        int mod = 10;
        while (input > 0){
            int digit = input % mod;
            System.out.println("extracting digit");
            System.out.println(digit);
            outputNumber = digit + outputNumber;
//            mod = mod * 10;
            input = input/10;
        }
        System.out.println("adding them up");
        return outputNumber;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("please enter a number");
        int out = processNum(UserInput.getUserNum());
        System.out.println(out);
    }
}
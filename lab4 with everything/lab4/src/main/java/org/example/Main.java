package org.example;

import java.util.InputMismatchException;
//genrate mut table
public class Main {
    static int userNum = 1;

    static int calNum(int x, int y){
        return x*y;
    }

    static void genrateMuttable(int range){
        for (int i = 1; i <= range; i++){
            System.out.printf("%d x = %d = %d \n", userNum, i, calNum(userNum,i));
        }
        System.out.println("done Genrating mut table");
    }

    public static void main(String[] args) {
        System.out. println("Hello world!");
        System.out.println("please enter userNumber to create a mut table");
        userNum = UserInput.getUserNum();
        System.out.println("now please enter the range of the loop");
        int loopCount = UserInput.getUserNum();
        System.out.println("starting the program");
        genrateMuttable(loopCount);
    }
}
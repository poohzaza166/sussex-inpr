package main;

import java.util.LinkedHashSet;

public class PinCracker {

    public static LinkedHashSet<Integer> triedPin = new LinkedHashSet<>();

    public static int crackPinRandom(){
        return (int) (Math.random() * 9999);
    }

    public static int crackPinRandomNoRepeats(){
        if (triedPin.isEmpty()){
            System.out.println("empty");
            triedPin.addLast(0000);
            return 0000;
        }
        int num =  triedPin.getLast() + 1;
        triedPin.addLast(num);
        System.out.println(num);
        return num;
    }
}

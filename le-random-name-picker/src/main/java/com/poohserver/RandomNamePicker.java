package com.poohserver;
import java.util.HashSet;
import java.util.Random;

public class RandomNamePicker {
    public static final String[] leRandomName = {"Nan",
    "Asuna",
    "alpha"};

    public static HashSet<String> = new HashSet<String>();
    public static Random ran = new Random();

    public static String randomizeName(){
        return leRandomName[ran.nextInt(leRandomName.length)];
    }
//    public static String pickRandomNameNoRepeat(){
//
//    }
}

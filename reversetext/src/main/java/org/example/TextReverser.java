package org.example;

public class TextReverser {
    public static String reverseText(String message){
        String newString = new String();
        for(int i=message.length()-1; i >=0; i--){
            newString += message.charAt(i);
        }
//        System.out.println(newString);
        return newString;
    }
}

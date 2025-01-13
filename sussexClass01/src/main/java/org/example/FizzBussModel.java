package org.example;

public class FizzBussModel {
    public static void main() {

        System.out.println("Hello world!");
        for (int i=1; i <=100; i++) {
            if (i % 2 == 0){
                System.out.println("fizz");
            }
            if (i % 3 == 0){
                System.out.println("buzz");
            }
            if (i % 2 == 0 && i % 3 == 0){
                System.out.println("fizz buzz");
            }
            else {
                System.out.println(i);
            }
        }

    }
}

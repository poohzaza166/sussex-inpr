package com.poohserver;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Car car = new Car("test", "modelname", 2019, 100);
        car.displayInfo();
        System.out.println(car.applyDiscount(10));
    }
}
package com.poohserver;

public class Car {
    String make;
    String model;
    int year;
    double price;
    public Car(String make, String model, int year,double price){
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Make "+ this.make + "\nmodel \n" + this.model + "\nyear\n" + this.year + "\nprice\n" + this.price;
    }

    public void displayInfo(){
        System.out.println(this.toString());
    }

    public float applyDiscount(double discountPercent){
        int discountPrice = (int) (this.price * (discountPercent / 100));
        return (float) (this.price - discountPrice);
    }
}

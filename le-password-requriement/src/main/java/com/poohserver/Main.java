package com.poohserver;


public class Main {
    public static void main(String []args){
        System.out.println("hello world");
        System.out.println("please enter a password");
        System.out.println(PasswordValidator.validateLePassword(UserInput.getUserString()));
    }}
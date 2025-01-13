package main;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        PINCode newPin = new PINCode();
//        PinCracker cracker = new PinCracker();
        boolean isCracked = false;
        System.out.pr`intln(newPin.getCurrentPIN());
        int pin = 0;
        while(!isCracked){
            pin = PinCracker.crackPinRandomNoRepeats();
            isCracked = newPin.equalPin(String.valueOf(pin));
//            System.out.println(pin);
        }
        System.out.println(newPin.getCurrentPIN());
        System.out.println(pin);
        System.out.println("now cracking code with le random method");
    }
}
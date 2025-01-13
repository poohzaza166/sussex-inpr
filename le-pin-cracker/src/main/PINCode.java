package main;

import java.util.Random;

class PINCode {
    private String currentPIN;

    private String generateRandomPIN() {
        Random random = new Random();
        int pin = 1000 + random.nextInt(9000); // Generates a random number between 1000 and 9999
        return String.valueOf(pin);
    }

    public PINCode(){
        this.currentPIN = generateRandomPIN();
    }
    public String getCurrentPIN(){
        return this.currentPIN;
    }

    public boolean equalPin(String checkPin){
        if (this.currentPIN.equals(checkPin)) {
            return true;
        }
        return false;
    }

}
package com.poohserver;
import java.util.function.Predicate;
import java.util.HashMap;
import java.util.Map;

public class PasswordValidator {
    public static boolean validateLePassword(String password){
        // check length of the password
        if (!(password.length() >= 8)){
            return false;
        }
        Map<String, Predicate<Character>> rules = new HashMap<>();
        rules.put("uppercase", Character::isUpperCase);
        rules.put("lowercase", Character::isLowerCase);
        rules.put("digit", Character::isDigit);
        rules.put("special", ch -> !Character.isLetterOrDigit(ch));
        // create hashmap to store the result
        Map<String, Boolean> results = new HashMap<>();
        // iterate through each rule
        for (String ruleName : rules.keySet()) {
            Predicate<Character> rule = rules.get(ruleName);
            boolean matches = password.chars().anyMatch(c -> rule.test((char) c));
            results.put(ruleName, matches);
        }

        // Ensure all conditions are met
        return results.values().stream().allMatch(Boolean::booleanValue);
    }

}

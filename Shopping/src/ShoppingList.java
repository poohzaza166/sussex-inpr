import java.util.ArrayList;

public class ShoppingList {
    // Stores the path to the data file
    private final String DATAFILE = "mainlist.txt";
    // Make an ArrayList field called shoppingList
    private ArrayList<String> shoppingList;

    /**
     * Constructor for the ShoppingList class
     */
    public ShoppingList() {
        // As this method returns an ArrayList we don't need to use new here
        // This will read the whole shopping list into the ArrayList
        shoppingList = FileIO.readDataFromFile(DATAFILE);
    }

//    /**
//     * Asks the user to input an item to find
//     *
//     * @param message the message to print out
//     * @return the String value of the item
//     */
//    public String getUserInput(String message) {
//        // Implement user input logic here
//        return ""; // Placeholder, modify as needed
//    }

    /**
     * Complete the method to print the shopping list using any kind of iteration you
     * select
     */
    public void printList() {
        for (String item : shoppingList) {
            System.out.println(item);
        }
    }

    /**
     * Complete the method to find an item in the shopping list using any means you
     * prefer
     *
     * @param item the item to find
     * @return the index of the item or -1 if it is not found
     */
    public int findItem(String item) {
        return shoppingList.indexOf(item);
    }

    /**
     * Add an item to the shopping list
     *
     * @param item item to add
     */
    public void addItem(String item) {
        shoppingList.add(item);
    }

    /**
     * Complete the method to remove an item from the shoppingList
     *
     * @param item the item to find
     * @return true if the item was successfully removed
     */
    public boolean removeItem(String item) {
        return shoppingList.remove(item);
    }

    /**
     * Orders the list alphabetically A to Z
     */
    public void orderListAtoZ() {
        shoppingList.sort(String::compareToIgnoreCase);
    }

    /**
     * Orders the list alphabetically Z to A
     */
    public void orderListZtoA() {
        shoppingList.sort((s1, s2) -> s2.compareToIgnoreCase(s1));
    }
}

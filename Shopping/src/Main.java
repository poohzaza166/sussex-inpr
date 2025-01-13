import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;

public class Main {

    static ShoppingList shoppingList = new ShoppingList();

    static final String[] menuList = {"sort a-z", "sort z-a",
            "addstuff",
            "remove something",
            "find something",
            "print list",
            "exit"};

    public static void printMenu(){
        for(int i=0; i < menuList.length; i++){
            System.out.printf("%d). %s\n", i, menuList[i]);
        }
    }

    public static String convertBool2SuccessFail(boolean results){return results ? "success" : "failed";}
    public static int menuChooser(int options) {
        switch (options) {
            case 0: // sort a-z
                shoppingList.orderListAtoZ();
                break;
            case 1: // sort z-a
                shoppingList.orderListZtoA();
                break;
            case 2: // add stuff
                shoppingList.addItem(UserInput.getUserString("Please enter the item you want to add:"));
                break;
            case 3: // remove stuff
                boolean results = shoppingList.removeItem(UserInput.getUserString("please enter the name of the item you wanted to remove please"));
                System.out.println(convertBool2SuccessFail(results));
                break;
            case 4: // find something
                int result = shoppingList.findItem(UserInput.getUserString("please enter the name of the item you wanted to find"));
                if (result >= 0) {
                    System.out.println("Item exists at index " + result);
                } else {
                    System.out.println("Item you requested is not found");
                }
                break;
            case 5: // print the list
                shoppingList.printList();
                break;
            case 6: // exit
                return 1;
            default:
                System.out.println("Invalid option selected");
                break;
        }
        return 0;
    }

        public static void main(String[] args) {
        // Instantiate the ShoppingList class
        int exit = 0;
        while (exit == 0) {
            printMenu();
            exit = menuChooser(UserInput.getUserNum());
        }
         shoppingList.orderListAtoZ();
        shoppingList.printList();
        }
}

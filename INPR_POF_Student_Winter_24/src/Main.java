import StudentDataStruct.Students;

public class Main {
    // main program entry point
    public static void main(String[] args) {
        Menu menu = new Menu();
//        starting the program
        Students students = new Students();
        students.addStudentsFromFile();
        int exit = 0;
        while (exit == 0){ // keep looping until done
            menu.showMenu();
            exit = menu.selectFunction(UserInput.getUserNum(), students);
        }
    }
}

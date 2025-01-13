import StudentDataStruct.Student;
import StudentDataStruct.StudentSearchOutput;
import StudentDataStruct.Students;

/**
 * Complete  the Menu class that displays a menu of options to the user and allows the user to interact with the
 * StudentDataStruct.Students class.
 * Add methods / code to support all the options below.
 * The code should loop until the user chooses to exit.
 */
public class Menu {
    private final String[] menuItems = {
            "Add student",
            "Print students",
            "Save students to file",
            "Load students from file",
            "Select random student with no repeats",
            "Search for student by name",
            "Exit"
    };

    /**
     * this method print all of the student in the student data structure object
     * @param students
     */
    public static void printAllFoundedStudent(StudentSearchOutput students){
        System.out.println("OK this is what i found");
        if (students.matchedFound == 0) System.out.println("no student found");
        for (Object student1: students.StudentArrayList){
            Student student = (Student) student1; // type casted because the class outputed a genreic object class
            System.out.println(student.toString());
        }
    }

    /**
     * this method Display the menu and the options to the user
     */
    public void showMenu( ) {
        for (int i=0; i < menuItems.length; i++){
            System.out.printf("%d, %s\n", i ,menuItems[i]);
        }
        System.out.println("Please enter your Options:");
    }

    /**
     * this method return a new student object base on the input provided
     * @return Student object
     */
    public static Student studentDataEntry(){
        Student student = new Student(
            UserInput.getUserString("Please enter firstname"), //first name
            UserInput.getUserString("Please Enter LastName"), //lastname
                UserInput.getUserNum("enter the age"), //age
                UserInput.getUserString("enter the group"), //group
                UserInput.getUserString("enter the country") //country
//                UserInput.getUserEmail("enter the thing") //email
        );
        student.generateEmail();
        return student;
    }

    /**
     * this function is responsable for deciding what do and if exit return 1 if not return 0
     * @param input menu options
     * @param students data structure to act apon
     * @return 1 or 0 1 for exit 0 for continue
     */
    public static int selectFunction(int input, Students students){
        switch (input){
            case 0: // adding student
                students.add(studentDataEntry());
                return 0;
            case 1: // print all Student
                students.printStudents();
                return 0;
            case 2: // save stuident to file
                students.saveStudentsToFile();
                return 0;
            case 3: // load student from file
                students.addStudentsFromFile();
                return 0;
            case 4: //select randomStudent
                Student student = students.getRandomStudentNoRepeats();
                System.out.println(student.toString());
                return 0;
            case 5: //search for student by name
                printAllFoundedStudent(students.searchStudentByName(UserInput.getUserString()));
                return 0;
            case 6: //exit
                System.out.println("good bye");
                return 1;
//            case 7: // debug print format lst name
//                System.out.println(students.getRandomStudentNoRepeats().formatLastName());
//                return 0;
            default:
                System.out.println("Invalid options! try again");
                return 0;
        }
    }


}

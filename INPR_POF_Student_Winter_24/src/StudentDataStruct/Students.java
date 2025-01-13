package StudentDataStruct;
import FileIO.FileIO;
import FileIO.FileIOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Students {
    private ArrayList<Student> students;

    private HashSet<Student> studentSet;

    private HashSet<Student> exportedStudentSet;
    /**
     * Constructor for the StudentDataStruct.Students class
     */
    public Students() {
        students = new ArrayList<>();
        studentSet = new HashSet<>();
        exportedStudentSet = new HashSet<>();
    }

    /**
     * Adds a student to the list
     * @param studentData a CSV String of the relevant student data to add
     */
    public void add(String studentData){
        Student student = new Student(studentData);
        if (!studentSet.contains(student)) {
            students.add(student);
            studentSet.add(student); // faster lookup
        }
        else System.out.println("contained duplicate ignoring");
    }

    /**
     * Adds a student to the list uses polymorphism
     * @param student the student to add
     */
    public void add(Student student) {
        if (!studentSet.contains(student)) {
            students.add(student);
            studentSet.add(student);
        }
        else System.out.println("contained duplicate ignoring");

    }

    /**
     * Returns a list of students as a list of strings
     * @return the aan Array List of students
     */
    public ArrayList<String> getStudentList() {
        ArrayList<String> register = new ArrayList<>();
        for (Student student : students) {
            register.add(student.toString());
        }
        return register;
    }

    /**
     * Reads the list of students from a CSV file
     */
    public void addStudentsFromFile()  {
        try {
            ArrayList<String> studentList = FileIO.readDataFromFile(FileIO.DATA_FILE);
            for (String studentData : studentList) {
                add(studentData);
            }
        } catch (FileIOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Prints the list of students
     */
    public void printStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    /**
     * Complete the method to search for a student by name or partial name
     * @param name - the name or partial name to search for
     * @return the student if found, null otherwise - extension task if more than one match return all matches
     */
    public StudentSearchOutput searchStudentByName(String name) {
        String searchTerm = name.toLowerCase().trim(); // normalise searchquery
        StudentSearchOutput founded = new StudentSearchOutput();

        for (Student student : this.studentSet ){

            String studentName = student.getStudentName().toLowerCase();
//            System.out.println(studentName);

            if (studentName.contains(searchTerm)) {

                founded.addStudent(student);
            }

        }
        return founded;
    }

    /**
     * Saves the current list of students to a CSV file
     */
    public void saveStudentsToFile() {
        try {
            FileIO.writeDataToFile(FileIO.DATA_FILE, this);
        } catch (FileIOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Complete a method that selects a random student from the list with no repeats
     * Once all students have been selected - print out a message to say that all students have been
     * selected and start selecting again. Use any logical mechanism to achieve this.
     * @return the random student
     */
    public Student getRandomStudentNoRepeats() {
        // define a list druing runntime that i see that i have not picked any one new yet
        Random randomizer = new Random();
        Student random = students.get(randomizer.nextInt(students.size()));
        // reset the list if the length is the saem as the original
        if (exportedStudentSet.size() >= students.size()-1 ){
            exportedStudentSet.clear();
            System.out.println("did stuff");
        }

        for (Student student: exportedStudentSet){
            if (student == random){
                return getRandomStudentNoRepeats();
            }
        }
        exportedStudentSet.add(random);
        return random;
    }
}

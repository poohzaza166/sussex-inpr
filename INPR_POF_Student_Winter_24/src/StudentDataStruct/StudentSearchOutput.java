package StudentDataStruct;

import java.util.ArrayList;

/**
 * this is a wrapper class for the return type for student search
 */
public class StudentSearchOutput {

    public ArrayList StudentArrayList;
    public int matchedFound = 0;
    public StudentSearchOutput(Student student){
        this.StudentArrayList = new ArrayList();
        this.StudentArrayList.add(student);
        this.matchedFound = 1;
    }

    // overloading the constructor method
    public StudentSearchOutput(ArrayList<Students> students){
        this.StudentArrayList = students;
        this.matchedFound = students.size();
    }

    public StudentSearchOutput(){
        this.matchedFound = 0;
        this.StudentArrayList = new ArrayList<>();
    }

    public void addStudent(Student student){
        this.StudentArrayList.add(student);
        this.matchedFound +=1;
    }

    public int getMatchedFound(){return this.matchedFound;}
}

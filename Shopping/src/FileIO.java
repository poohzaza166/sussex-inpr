import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileIO {
    public static ArrayList<String> readDataFromFile(String fileName) {
        ArrayList<String> fileData = new ArrayList<>();
        try {
            File dataFile = new File(fileName);
            Scanner myReader = new Scanner(dataFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //Remove the carriage return & line feed
                fileData.add(data.replaceAll("[\r\n]", ""));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        //shuffle is a method in the collections library that will shuffle a
        //list into a random order
        Collections.shuffle(fileData);
        return fileData;
    }
}

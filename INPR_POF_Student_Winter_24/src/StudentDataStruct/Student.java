package StudentDataStruct;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String group;

    private String country;
    private String email;

    public Student(String firstName, String lastName, int age, String group, String country, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.group = group;
            this.country = country;
            this.email = email;
        }

    public Student(String firstName, String lastName, int age, String group, String country) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.group = group;
            this.country = country;
            email = generateEmail();
        }

    public Student(String studentData) {
        String[] data = studentData.split(",");
        this.firstName = data[0];
        this.lastName = data[1];
        this.age = Integer.parseInt(data[2]);
        this.group = data[3];
        this.country = data[4];
        this.email = data[5];
    }

    /**
     * Complete the method that formats the last name to have the first letter in uppercase if the last name is one word
     * If the last name is two words with a hyphen e.g. el-Sabir, the first letter of the first word should not be upper case
     * , all subsequent words will have the first letter uppercase and the remaining letters lower case
     *
     * this method get the last name and formatt it  and reutrn a string that is formatted
     * @return String of formatted last name
     */
    public String formatLastName() {
        // Matches a string of lowercase letters, optionally followed by a hyphen and another lowercase sequence
        Pattern pattern = Pattern.compile("^(\\p{Lower}+)(?:-(\\p{Lower}+))?$");
        Matcher matcher = pattern.matcher(lastName.toLowerCase());

        // Use Matcher.replaceAll with a lambda to process the match
        return matcher.replaceAll(m -> {
            String firstPart = capitalize(m.group(1));
            String secondPart = m.group(2) != null ? "-" + capitalize(m.group(2)) : "";
            return firstPart + secondPart;
        });
    }


    private String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    public String getStudentName() {
        return firstName + " " + formatLastName();
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    /**
     * this method set the email for the user object and return the email that was set to the object
     * @return String email
     */
    public String generateEmail() {
        String email = firstName.substring(0, 1).toLowerCase() + lastName.substring(0, 1).toLowerCase() +
                getRandomNumber(100, 999) + "@sussex.ac.uk";

        this.email = email;
        return email;
    }


    @Override
    public String toString() {
        return firstName + "," +
                formatLastName() + "," +
                age + "," +
                group + "," +
                country + "," +
                email;
    }
}

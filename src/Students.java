package src;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;

/**
 * Students Class for creating a list of student objects to interact with
 * @author Joseph Alam
 */
public class Students {
    
    private static Students instance = null;
    private ArrayList<Student> students;

    /**
     * Initializes Students class by loading students from DataLoader
     */
    private Students() {
        students = DataLoader.getStudents();
    }

    /**
     * Creates an instance of the Students class if one does not already exist
     * @return instance of the Students class
     */
    public static Students getInstance() {
        if(instance == null) {
            instance = new Students();
        }
        return instance;
    }

    /**
     * Returns the list of students
     * @return ArrayList<Student>: Array of student objects
     */
    public ArrayList<Student> getStudents() {
        return students;
    }
    /**
     * Find a student object by username and password
     * @param username Student's username
     * @param password Student's password
     * @return Student object
     */
    public Student getStudent(String username, String password) {
        for(Student student : students) {
            if(username == student.username && password == student.getPassword()) {
                return student;
            }
        }
        return null;
    }
    /**
     * Find a student object by the ID
     * @param id The ID of the student object
     * @return Student object
     */
    public Student getStudent(UUID id) {
        for(Student student : students) {
            if(id == student.getId()) {
                return student;
            }
        }
        return null;
    }
    /**
     * Checks to see if a user exists already
     * @param userName String of the user's username
     * @return boolean of whether or not username exists already
     */
    public boolean haveUser(String userName) {
        for(Student student : students) {
            if(student.username.equals(userName)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Adds a student to the list of students
     * @param name Student's name
     * @param email Student's email
     * @param password Student's password
     * @param dateOfBirth Student's date of birth
     * @param sex Student's sex
     * @param gender Student's gender
     * @param available Whether or not student is available to work
     * @param gPA Student's GPA
     * @param campusLocation Student's campus location
     * @param currLevel Student's current level
     * @param currMajor Student's current Major
     * @param currYear Student's current yera
     * @param username Student's username
     * @return boolean of whether or not student was added
     */
    public boolean addStudent(String name, String email, String password, Date dateOfBirth, String sex,
    String gender, Boolean available, double gPA, String campusLocation, String currLevel, String currMajor,
     int currYear, String username) {
        if(haveUser(username))
            return false;
        students.add( new Student(name, email, password, dateOfBirth, sex, gender, null, available, null,
                                  gPA, campusLocation, currLevel, currMajor, currYear, 0.0, username));

        return true;
    }
}
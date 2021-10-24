package src;
import java.util.ArrayList;
import java.util.UUID;

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
}
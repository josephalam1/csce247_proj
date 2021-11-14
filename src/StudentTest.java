package src;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class StudentTest {
    UUID tStudentId = UUID.randomUUID();
    UUID tresumeId = UUID.randomUUID();
    public String name;
    public String username;
    public String email;
    public String phone;
    protected String password = "random";
    private Date dateOfBirth;
    private String sex;
    private String gender;
    public Boolean available;
    public ArrayList<JobListing> savedJobs;
    private double GPA;
    public String campusLocation;
    public String currLevel;
    public String currMajor;
    public int currYear;
    private double rating;
    private Boolean adminPrivilege = false;

    @BeforeEach
    public void setup() {
        Student s1 = new Student(tStudentId, "Odessa", "odessa.chloe@gmail.com", "3521234567", password, new Date(), "F", "F", true, 2.1, "columbia", "junior", "compsci", 3, 3, "odessa.c");
        Student s2 = new Student(tStudentId, "crhis", "student.chris@gmail.com", "1234567890", password, new Date(), "M", "O", true, 2.8, "columbia", "Freshman", "compsci", 1, 4, "student_chris");
    }

    @AfterEach 
    public void tearDown() {
       
    }
    @Test 
    void testStudentName() {
        
    }

    @Test 
    void testStudentEmail() {
        
    }
    @Test 
    void testStudentPhone() {
        
    }
    @Test 
    void testStudentDOB() {
        
    }
    @Test 
    void testStudentSex() {
        
    }
    @Test 
    void testStudentGender() {
        
    }
    @Test 
    void testStudentAvailable() {
       
    }
    @Test 
    void testStudentGPA() {
        
    }
    @Test 
    void testStudentCampusLocation() {
        
    }
    @Test 
    void testStudentCurrLevel() {
        
    }
    @Test 
    void testStudentCurrMajor() {
        
    }
    @Test 
    void testStudentCurrYear() {
        
    }
    @Test 
    void testStudentRating() {
        
    }
    @Test 
    void testStudentUserName() {
        
    }
    @Test 
    void testStudentAdmin() {
      
    }
}

package src;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Student implements User {
    private UUID id;
    private UUID resumeId;
    public String name;
    public String username;
    public String email;
    protected String password;
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

    /**
     * Initializes student object without pre-existing ID
     * @param name Student's name
     * @param email Student's email
     * @param password Student's password
     * @param dateOfBirth Student's birthdate
     * @param sex Student's sex
     * @param gender Student's gender
     * @param openApplications Student's applications
     * @param available If the student is available to work or not
     * @param savedJobs Student's saved jobs
     * @param gPA Student's GPA
     * @param campusLocation Location of USC campus student attends
     * @param currLevel Current level of student
     * @param currMajor Current major of student
     * @param currYear Current year of student
     * @param rating Rating
     * @param username Student's username
     */
    public Student(String name, String email, String password, Date dateOfBirth, String sex,
            String gender, Boolean available, ArrayList<JobListing> savedJobs,
            double gPA, String campusLocation, String currLevel, String currMajor, int currYear, double rating, String username) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.gender = gender;
        this.available = available;
        this.savedJobs = savedJobs;
        this.GPA = gPA;
        this.campusLocation = campusLocation;
        this.currLevel = currLevel;
        this.currMajor = currMajor;
        this.currYear = currYear;
        this.rating = rating;
    }
    /**
     * Initializes student object with a pre-existing ID
     * @param id Student's ID
     * @param name Student's name
     * @param email Student's email
     * @param password Student's password
     * @param dateOfBirth Student's birthdate
     * @param sex Student's sex
     * @param gender Student's gender
     * @param openApplications Student's applications
     * @param available If the student is available to work or not
     * @param savedJobs Student's saved jobs
     * @param gPA Student's GPA
     * @param campusLocation Location of USC campus student attends
     * @param currLevel Current level of student
     * @param currMajor Current major of student
     * @param currYear Current year of student
     * @param rating Rating
     * @param username Student's username
     */
    public Student(UUID id, String name, String email, String password, Date dateOfBirth, String sex,
            String gender, Boolean available, double gPA, String campusLocation, String currLevel, String currMajor, int currYear, double rating, String username) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.gender = gender;
        this.available = available;
        this.GPA = gPA;
        this.campusLocation = campusLocation;
        this.currLevel = currLevel;
        this.currMajor = currMajor;
        this.currYear = currYear;
        this.rating = rating;
    }
    /**
     * Initializes student object with a pre-existing ID and a resume ID
     * @param id Student's ID
     * @param name Student's name
     * @param email Student's email
     * @param password Student's password
     * @param dateOfBirth Student's birthdate
     * @param sex Student's sex
     * @param gender Student's gender
     * @param available If the student is available to work or not
     * @param savedJobs Student's saved jobs
     * @param gPA Student's GPA
     * @param campusLocation Location of USC campus student attends
     * @param currLevel Current level of student
     * @param currMajor Current major of student
     * @param currYear Current year of student
     * @param rating Rating
     * @param username Student's username
     */
    public Student(UUID id, UUID resumeID, String name, String email, String password, Date dateOfBirth, String sex,
            String gender, Boolean available,
            double gPA, String campusLocation, String currLevel, String currMajor, int currYear, double rating, String username) {
        this.id = id;
        this.resumeId = resumeID;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.gender = gender;
        this.available = available;
        GPA = gPA;
        this.campusLocation = campusLocation;
        this.currLevel = currLevel;
        this.currMajor = currMajor;
        this.currYear = currYear;
        this.rating = rating;
    }
    /** 
     * Get the Student's ID
     * @return UUID of student ID
     */
    public UUID getId() {
        return id;
    }
    /**
     * Return the student's resume ID
     * @return UUId of resume ID
     */
    public UUID getResumeId() {
        return this.resumeId;
    }
    /**
     * Set the Resume ID for Student
     * @param id UUID of resume
     */
    public void setResumeId(UUID id) {
        this.resumeId = id;
    } 
    /**
     * Returns the student's password
     * @return String of student password
     */
    public String getPassword() {
        return this.password;
    }
    /**
     * Gets the student's date of birth
     * @return Date of student's birth date
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    /**
     * Sets the student's date of birth
     * @param dateOfBirth Date of student's birth date
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    /**
     * Returns the student's sex
     * @return String of student's sex
     */
    public String getSex() {
        return sex;
    }
    /**
     * Set the student's sex
     * @param sex String of student's sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
    /**
     * Get the student's gender
     * @return String of student's gender
     */
    public String getGender() {
        return gender;
    }
    /**
     * Set the student's gender
     * @param gender String of student's gender
     */ 
    public void setGender(String gender) {
        this.gender = gender;
    }
    /**
     * Get the student's GPA
     * @return double of student's GPA
     */
    public double getGPA() {
        return GPA;
    }
    /**
     * Sets the student's GPa
     * @param gPA double of student's GPA
     */
    public void setGPA(double gPA) {
        GPA = gPA;
    }
    /**
     * gets the stundet's id
     * @return id student's identifacation number
     */
    public UUID getID(){
        return this.id;
    }
    /**
     * Get student's rating
     * @return double of student's rating
     */
    public double getRating() {
        return rating;
    }
    /**
     * Returns the String equivalent for a student object
     */
    public String toString(){
        return "Student Account info: " + "\n" +
        "\nName: " + name + "\nEmail: " + email + 
        "\nDOB: " + this.getDateOfBirth() + "\nSex: " + this.getSex() + 
        "\nGender: " + this.getGender() + 
        "\nGPA: " + this.getGPA() + " Level: " + currLevel + " Year: " + currYear + " Major: " + currMajor;
    }
    public void apply(UUID studentID, UUID resumeID, UUID jobPostingID, Date applicationDate){
        studentID = this.id;
        resumeID = this.resumeId;
        
    }

    /**
     * checks for admin priviliage and deletes listing 
     * @param job to delete and admin rights
     */
    @Override
    public void deleteListing(JobListing job, Boolean admin) {
        admin = adminPrivilege;
        if (admin == true) {
            //jobs.remove(job);
        }
    }

    /**
     * checks for admin priviliage and edits the listing 
     * @param job to edit and admin rights
     */
    @Override
    public void editListing(JobListing job, Boolean admin) {
        admin = adminPrivilege;
        if (admin == true) {
            job.setTitle("Admin edit");
        }
    }
}

package src;

import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;
import java.util.UUID;

public class Student {
    private UUID id;
    public String name;
    public String username;
    public String email;
    protected String password;
    private Date dateOfBirth;
    private String sex;
    private String gender;
    // public StudentProfile profile;
    public ArrayList<Application> openApplications;
    public Boolean available;
    public ArrayList<JobListing> savedJobs;
    private double GPA;
    public String campusLocation;
    public String currLevel;
    public String currMajor;
    public int currYear;
    private double rating;
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
            String gender, ArrayList<Application> openApplications, Boolean available, ArrayList<JobListing> savedJobs,
            double gPA, String campusLocation, String currLevel, String currMajor, int currYear, double rating, String username) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.gender = gender;
        this.openApplications = openApplications;
        this.available = available;
        this.savedJobs = savedJobs;
        GPA = gPA;
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
            String gender, ArrayList<Application> openApplications, Boolean available, ArrayList<JobListing> savedJobs,
            double gPA, String campusLocation, String currLevel, String currMajor, int currYear, double rating, String username) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.gender = gender;
        this.openApplications = openApplications;
        this.available = available;
        this.savedJobs = savedJobs;
        GPA = gPA;
        this.campusLocation = campusLocation;
        this.currLevel = currLevel;
        this.currMajor = currMajor;
        this.currYear = currYear;
        this.rating = rating;
    }
    
    public UUID getId() {
        return id;
    }
    /**
     * Returns the student's password
     * @return String of student password
     */
    public String getPassword() {
        return this.password;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double gPA) {
        GPA = gPA;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String setPreferredName(String name){
        return "";
    }
    public Boolean setAvailable(){
        return true;
    }
    public Application createApp(){
        return null;
    }
    public ArrayList<Application> viewApps(){
        return openApplications;
    }
    public void saveJobListing(JobListing job){
        savedJobs.add(job);
    }
    public ArrayList<JobListing> viewSavedJobs(){
        return savedJobs;
    }
    public ArrayList<String> search(){
        return null;
    }
    public void sort(ArrayList<JobListing> jobList){
        for (int i = 0; i < jobList.size(); i++){
            for ( int j = 0; j < jobList.size(); j++){
                if (jobList.get(i).getTitle().compareTo(jobList.get(j).getTitle()) > 0){
                    Collections.swap(jobList, i, j);
                }
            }
        }
    }
    // User needs to specify what they want to filter by
    public ArrayList<JobListing> filter(ArrayList<JobListing> jobList, int search, String loc, int minHRS, int maxHRS, double pay, Boolean remote, boolean volunteer, ArrayList<String> skills, double rating){
        ArrayList<JobListing> ret = new ArrayList<JobListing>();
        if (search == 1) {
            for (JobListing job : jobList) {
                if (job.getLocation() == loc) {
                    ret.add(job);
                }
            }
        } else if (search == 2) {
            for (JobListing job : jobList) {
                if (job.getMinHours() == minHRS) {
                    ret.add(job);
                }
            }
        } else if (search == 3) {
            for (JobListing job : jobList) {
                if (job.getMaxHours() == maxHRS) {
                    ret.add(job);
                }
            }
        } else if (search == 4) {
            for (JobListing job : jobList) {
                if (job.getLocation() == loc) {
                    ret.add(job);
                }
            }
        } else if (search == 5) {
            for (JobListing job : jobList) {
                if (job.getPay() >= pay) {
                    ret.add(job);
                }
            }
        } else if (search == 6) {
            for (JobListing job : jobList) {
                if (remote = job.isRemote()) {
                    ret.add(job);
                }
            }
        } else if (search == 7) {
            for (JobListing job : jobList) {
                if (job.getRating() >= rating) {
                    ret.add(job);
                }
            }
        } else if (search == 8) {
            for (JobListing job : jobList) {
                if (job.getPay() >= pay) {
                    ret.add(job);
                }
            }
        }
        return ret;
    }
    public void giveRating(Company c, int rating){
        c.setRating(rating);
    }

    public String toString(){
        return "Student Account info: " + "\n" +
        "\nName: " + name + "\nEmail: " + email + 
        "\nDOB: " + this.getDateOfBirth() + "\nSex: " + this.getSex() + 
        "\nGender: " + this.getGender() + 
        "\nGPA: " + this.getGPA() + " Level: " + currLevel + " Year: " + currYear + " Major: " + currMajor;
    }
    
    
}

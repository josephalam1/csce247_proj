package src;

import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;

public class Student {
    private int accType;
    private int id;
    public String name;
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

    public Student(int accType, int id, String name, String email, String password, Date dateOfBirth, String sex,
            String gender, ArrayList<Application> openApplications, Boolean available, ArrayList<JobListing> savedJobs,
            double gPA, String campusLocation, String currLevel, String currMajor, int currYear, double rating) {
        this.accType = accType;
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
    
    public int getAccType() {
        return accType;
    }

    public void setAccType(int accType) {
        this.accType = accType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    public StudentProfile createProfile(){
        return null;
    }
    public Application createApp(){
        return null;
    }
    public ArrayList<Application> viewApps(){
        return openApplications;
    }
    public void saveJobListing(JobListing job){

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
    public ArrayList<String> filter(ArrayList<String> search, String loc, int minHRS, int maxHRS, double pay, Boolean remote, boolean volunteer, ArrayList<String> skills, double rating){
        return skills;
    }
    public Double giveRating(CompanyProfile aProfile){
        return null;
    }

    public String toString(){
        return "Student Account info: " + "\n" +
        "\nName: " + name + "\nEmail: " + email + 
        "\nDOB: " + this.getDateOfBirth() + "\nSex: " + this.getSex() + 
        "\nGender: " + this.getGender() + 
        "\nGPA: " + this.getGPA() + " Level: " + currLevel + " Year: " + currYear + " Major: " + currMajor;
    }
    
    
}

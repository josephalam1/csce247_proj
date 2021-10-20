package src;

import java.util.ArrayList;
import java.util.Collections;

public class Student {
    private int accType;
    private int id;
    public String name;
    public String email;
    protected String password;
    private int dateOfBirth;
    private String sex;
    private String gender;
    public StudentProfile profile;
    public ArrayList<Application> openApplications;
    public Boolean available;
    private boolean adminPrivilege = false;
    public ArrayList<JobListing> savedJobs;

    public Student(String name, int DOB, String sex, String gender){

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
    
}

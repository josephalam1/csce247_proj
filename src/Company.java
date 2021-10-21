package src;

import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;

public class Company {
    private int id;
    public String name;
    public String recruiterEmail;
    protected String password;
    public String address;
    public String hiringRecruiter;
    public String contactInfo;
    public Date dateEstablished;
    public String webSite;
    private double rating;

    //public Company(int id, String name, String email, String address, String hiringRecruiter, String contactInfo){
        // COS added above params needed for companyProfile
    //}
    public Company(int id, String name, String recruiterEmail, String password, String address, 
            String hiringRecruiter, String contactInfo, Date dateEstablished, String webSite, double rating) {
        this.id = id;
        this.name = name;
        this.recruiterEmail = recruiterEmail;
        this.password = password;
        this.address = address;
        this.hiringRecruiter = hiringRecruiter;
        this.contactInfo = contactInfo;
        this.dateEstablished = dateEstablished;
        this.webSite = webSite;
        this.rating = rating;
    }
    
    public JobListing createJob(JobListing job){
        return job;
    }
    public ArrayList<Application> viewApplications(JobListing job){
        return null;
    }
    public void sort(ArrayList<Application> appList){
        for (int i = 0; i < appList.size(); i++) {
            for (int j = 0; j < appList.size(); j++) {
                if (appList.get(i).getPastJobTitle().compareTo(appList.get(j).getPastJobTitle()) > 0) {
                    Collections.swap(appList, i, j);
                }
            }
        }
    }
    public ArrayList<String> filter(ArrayList<String> search, String level, String major, int year, String[] skills, double rating){
        return search;
    }
    public double giveRating(Student s){
        return rating;
    }
    public Student chooseCandidate(Application[] apps){
        return null;
    }
    public void hideFromProfile(String companyProfile) {

    }
    // COS not in UML needed for CompanyProfile
    public String toString(){
        return "\nCompany account info: " + "\n" +
        "\nName: " + name + "\nEstablished: " + dateEstablished + 
        "\nLocation: " + address + "\nWebsite: " + webSite + 
        "\nHiring Recruiter: " + hiringRecruiter + " Email: " + recruiterEmail + " Phone: " + contactInfo;
    }
    
}

package src;

import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;
import java.util.UUID;

public class Company implements User {
    private UUID id;
    public String name;
    public String recruiterEmail;
    public String username;
    protected String password;
    public String address;
    public String hiringRecruiter;
    public String contactInfo;
    public Date dateEstablished;
    public String webSite;
    private double rating;
    public ArrayList<JobListing> jobListings;

    //public Company(int id, String name, String email, String address, String hiringRecruiter, String contactInfo){
        // COS added above params needed for companyProfile
    //}
    /**
     * Initializes company object with pre-existing ID
     * @param id Company's ID
     * @param name Company's name
     * @param recruiterUsername Recruiter's username
     * @param recruiterEmail Recruiter's email
     * @param password Password for the recruiter
     * @param address Company's address
     * @param hiringRecruiter Recruiter's name
     * @param contactInfo Contact information for recruiter/company
     * @param dateEstablished Date the company was established
     * @param webSite URL of the company's website
     * @param rating Rating
     */
    public Company(UUID id, String name, String recruiterUsername, String recruiterEmail, String password, String address, 
            String hiringRecruiter, String contactInfo, Date dateEstablished, String webSite, double rating) {
        this.id = id;
        this.name = name;
        this.recruiterEmail = recruiterEmail;
        this.username = recruiterUsername;
        this.password = password;
        this.address = address;
        this.hiringRecruiter = hiringRecruiter;
        this.contactInfo = contactInfo;
        this.dateEstablished = dateEstablished;
        this.webSite = webSite;
        this.rating = rating;
    }
    /**
     * Initializes company object without a pre-existing ID
     * @param id Company's ID
     * @param name Company's name
     * @param recruiterUsername Recruiter's username
     * @param recruiterEmail Recruiter's email
     * @param password Password for the recruiter
     * @param address Company's address
     * @param hiringRecruiter Recruiter's name
     * @param contactInfo Contact information for recruiter/company
     * @param dateEstablished Date the company was established
     * @param webSite URL of the company's website
     * @param rating Rating
     */
    public Company(String name, String recruiterUsername, String recruiterEmail, String password, String address, 
            String hiringRecruiter, String contactInfo, Date dateEstablished, String webSite, double rating) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.recruiterEmail = recruiterEmail;
        this.username = recruiterUsername;
        this.password = password;
        this.address = address;
        this.hiringRecruiter = hiringRecruiter;
        this.contactInfo = contactInfo;
        this.dateEstablished = dateEstablished;
        this.webSite = webSite;
        this.rating = rating;
    }
    /**
     * Returns the company object's ID
     * @return UUID of company ID
     */
    public UUID getId() {
        return id;
    }
    /**
     * Returns the password for the company object
     * @return String of password
     */
    public String getPassword() {
        return password;
    }
    public JobListing createJob(JobListing job){
        return job;
    }
    public ArrayList<JobListing> getJobListings(){
        return jobListings;
    }

    public void sort(ArrayList<Application> appList){
        for (int i = 0; i < appList.size(); i++) {
            for (int j = 0; j < appList.size(); j++) {
                if (appList.get(i).getApplicationDate().compareTo(appList.get(j).getApplicationDate()) > 0) {
                    Collections.swap(appList, i, j);
                }
            }
        }
    }
    public ArrayList<String> filter(ArrayList<String> search, String level, String major, int year, String[] skills, double rating){
        return search;
    }

    public void giveRating(Student s, double rating){
        s.setRating(rating);
    }

    public double setRating(double rating) {
        return rating;
    }

    // COS not in UML needed for CompanyProfile
    public String toString(){
        return "\nCompany account info: " + "\n" +
        "\nName: " + name + "\nEstablished: " + dateEstablished + 
        "\nLocation: " + address + "\nWebsite: " + webSite + 
        "\nHiring Recruiter: " + hiringRecruiter + " Email: " + recruiterEmail + " Phone: " + contactInfo;
    }
    
    public void deleteUser() {

    }
    public double getRating(){
        return this.rating;
    }
    public void viewApplications(JobListing job) {
    }
}

package src;

import java.util.ArrayList;

public class Company {
    private int accType;
    private int id;
    public String name;
    public String email;
    protected String password;
    public String address;
    public String hiringRecruiter;
    public String contactInfo;
    private boolean adminPrivilege = false;

    public Company(int accType, int id, boolean adminPrivilege, String name, String email, String address, String hiringRecruiter, String contactInfo){
        // COS added above params needed for companyProfile
    }
    public CompanyProfile createProfile(Company a){
        return null;
    }
    public JobListing createJob(JobListing job){
        return job;
    }
    public ArrayList<Application> viewApplications(JobListing job){
        return null;
    }
    public ArrayList<String> sort(ArrayList<Application> applicant){
        return null;
    }
    public ArrayList<String> filter(ArrayList<String> search, String level, String major, int year, String[] skills, double rating){
        return search;
    }
    public double giveRating(StudentProfile aProfile){
        return accType;
    }
    public Student chooseCandidate(Application[] apps){
        return null;
    }

    // COS not in UML needed for CompanyProfile
    public String toString(){
        return "\nCompany";
    }
    
}

package src;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;

/**
 * Companies Class for creating a list of company objects and job objects 
 *    to interact with
 * @author Joseph Alam
 */
public class Companies {
    
    private static Companies instance = null;
    private ArrayList<JobListing> jobs;
    private ArrayList<Company> companies;

    /**
     * Initializes Companies class by loading companies from DataLoader
     */
    private Companies() {
        companies = DataLoader.getCompanies();
        jobs = DataLoader.getJobListings();
    }

    /**
     * Creates an instance of the Companies class if one does not already exist
     * @return instance of the Companies class
     */
    public static Companies getInstance() {
        if(instance == null) {
            instance = new Companies();
        }
        return instance;
    }

    /**
     * Returns the list of companies
     * @return ArrayList<Company>: Array of company objects
     */
    public ArrayList<Company> getCompanies() {
        return companies;
    }
    /**
     * Returns the list of jobs
     * @return ArrayList<Company>: Array of company objects
     */
    public ArrayList<JobListing> getJobs() {
        return jobs;
    }
    /**
     * Returns the list of open jobs
     * @return ArrayList<Company>: Array of company objects
     */
    public ArrayList<JobListing> getOpenJobs() {
        ArrayList<JobListing> openjobs = new ArrayList<JobListing>();
        for (JobListing job : jobs) {
            if (job.open && job.getNumOpenings() > 0) {
                openjobs.add(job);
            }
        }
        return openjobs;
    }
    public JobListing getJobById(UUID id) {
        for(JobListing job : jobs) {
            if(job.getCompanyID().equals(id)) {
                return job;
            }
        }
        return null;
    }
    /**
     * Return list of jobs by the company
     * @param id UUID of the company
     * @return ArrayList<JobListing> of the jobs
     */
    public ArrayList<JobListing> getJobsByCompanyId(UUID id) {
        ArrayList<JobListing> sortedJobs = new ArrayList<JobListing>();
        for(JobListing job : jobs) {
            if(job.getCompanyID().equals(id)) {
                sortedJobs.add(job);
            }
        }
        return sortedJobs;
    }
    /**
     * Find a Company object by recruiter username and password
     * @param username Recruiter's username
     * @param password Recruiter's password
     * @return Company object
     */
    public Company getCompany(String username, String password) {
        for(Company company : companies) {
            if(username.equals(company.username) && password.equals(company.getPassword())) {
                return company;
            }
        }
        return null;
    }
    /**
     * Find a company object by the ID
     * @param id The ID of the company object
     * @return Company object
     */
    public Company getCompany(UUID id) {
        for(Company company : companies) {
            if(company.getId().equals(id)) {
                return company;
            }
        }
        return null;
    }
    /**
     * Checks if the username already exists in list of companies
     * @param username String of recruiter's username
     * @return boolean of whether or not company was added
     */
    public boolean haveCompany(String username) {
        for(Company company : companies) {
            if(company.username.equals(username)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Add a company with the parameters
     * @param name String of company's name
     * @param recruiterUsername String of username for recruiter
     * @param recruiterEmail String of recruiter's email
     * @param password String of recruiter's password
     * @param address String of company's address
     * @param hiringRecruiter String of hiring recruiter's name
     * @param contactInfo String of phone number for recruiter
     * @param dateEstablished Date of date when company was established
     * @param website String of URL
     * @return boolean of whether or not company was added
     */
    public boolean addCompany(String name, String recruiterUsername, String recruiterEmail, String password, String address, 
    String hiringRecruiter, String contactInfo, Date dateEstablished, String website) {
        if (haveCompany(recruiterUsername))
            return false;
        companies.add(new Company(name, recruiterUsername, recruiterEmail, password, address, hiringRecruiter, contactInfo, dateEstablished, website, 0.0));
        DataWriter.saveCompanies();
        return true;
    }
    /**
     * Add job with following parameters
     * @param companyID UUID of company ID
     * @param title String of job title
     * @param location String of job location
     * @param minHours int of minimum number of hours for job posting
     * @param maxHours int of maximum number of hours for job posting
     * @param pay double of pay rate for job posting
     * @param expDate Date of expiration date for job posting
     * @param numOpenings int of number of openings for job
     * @param skillsReq ArrayList<String> of required skills for job
     * @param duties ArrayList<String> of job duties
     * @param description String of job descrption
     * @param minExp String of minimum experience required
     * @param remote boolean of whether or not job is remote
     * @param open boolean of whether or not job is open
     * @return boolean of whether or not job was added
     */
    public boolean addJob(UUID companyID, String title, String location, int minHours, int maxHours,
    double pay, Date expDate, int numOpenings, ArrayList<String> skillsReq, ArrayList<String> duties, String description,
    String minExp, boolean remote, boolean open) {
        jobs.add(new JobListing(companyID, title, location, minHours, maxHours, pay, expDate, numOpenings, skillsReq, duties, description, minExp, remote, open));
        DataWriter.saveJobs();
        return true;
    }
}
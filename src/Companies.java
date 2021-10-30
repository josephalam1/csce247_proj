package src;
import java.util.ArrayList;
import java.util.UUID;

import javax.xml.crypto.Data;

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
     * Find a Company object by recruiter username and password
     * @param username Recruiter's username
     * @param password Recruiter's password
     * @return Company object
     */
    public Company getCompany(String username, String password) {
        for(Company company : companies) {
            if(username == company.username && password == company.getPassword()) {
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
            if(id == company.getId()) {
                return company;
            }
        }
        return null;
    }
}
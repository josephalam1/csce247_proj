package src;

import java.util.ArrayList;
import java.util.UUID;

public class Admin implements User {
    private UUID id;
    private boolean adminPrivilege = true;
    public String userName;
    public String email;
    protected String adminPassword;
    private ArrayList<JobListing> jobs;
    private Companies company = Companies.getInstance();

    public Admin(UUID id, String userName, String adminPassword, String email) {
        this.id = id;
        this.userName = userName;
        this.adminPassword = adminPassword;
        this.email = email;
    } 

    @Override
    public void deleteListing(JobListing job) {
        if (adminPrivilege == true)
            for (JobListing j : jobs) {
                jobs.remove(job);
            }

    }

    @Override
    public void editListing(JobListing job) {
        
    }
     
}

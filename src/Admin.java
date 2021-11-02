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

     /**
     * Initializes company object with pre-existing ID
     * @param id admin's ID
     * @param userName admin's username
     * @param email the admin's email
     * @param adminPassword Password for the admin
     */
    public Admin(UUID id, String userName, String adminPassword, String email) {
        this.id = id;
        this.userName = userName;
        this.adminPassword = adminPassword;
        this.email = email;
    } 


    /**
     * checks for admin priviliage and deletes listing 
     * @param job to delete and admin rights
     */
    @Override
    public void deleteListing(JobListing job, Boolean admin) {
        admin = adminPrivilege;
        if (admin == true)
                jobs.remove(job);
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
            job.setLocation("Admin edit");
        }
    }
     
}

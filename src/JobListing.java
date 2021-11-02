package src;

import java.util.Date;
import java.util.ArrayList;
import java.util.UUID;

public class JobListing {
    private UUID id, companyId;
    private String title, location, description, minExp;
    private int minHours, maxHours, numOpenings;
    private double pay;
    private Date expDate;
    public ArrayList<String> skillsReq;
    public ArrayList<String> duties;
    public boolean remote, open, volunteer;
    /**
     * Initializes a Job Listing with only a company ID
     * @param companyID UUID of company
     */
    public JobListing(UUID companyID) {
        this.id = UUID.randomUUID();
        this.companyId = companyID;
    }
    /**
     * Initializes a Job Listing with the following parameters:
     * @param companyID UUID of company
     * @param title String of job title
     * @param location String of location
     * @param minHours int of minimum number of hours hiring for
     * @param maxHours int of maximum number of hours hiring for
     * @param pay double of pay rate/salary
     * @param expDate Date of when the job listing expires
     * @param numOpenings int of number of openings
     * @param skillsReq ArrayList<String> of the required skills
     * @param duties ArrayList<String> of the duties for the job
     * @param description String of the description
     * @param minExp String of the minimum experience required
     * @param remote boolean of whether or not the job opportunity is remote
     * @param open boolean of whether or not the job listing is open
     */
    public JobListing(UUID companyID, String title, String location, int minHours, int maxHours,
            double pay, Date expDate, int numOpenings, ArrayList<String> skillsReq, ArrayList<String> duties, String description,
            String minExp, boolean remote, boolean open) {
        this.id = UUID.randomUUID();
        this.companyId = companyID;
        this.title = title;
        this.location = location;
        this.minHours = minHours;
        this.maxHours = maxHours;
        this.pay = pay;
        this.expDate = expDate;
        this.numOpenings = numOpenings;
        this.skillsReq = skillsReq;
        this.duties = duties;
        this.description = description;
        this.minExp = minExp;
        this.remote = remote;
        this.open = open;
    }
    /**
     * Initializes a Job Listing with the following parameters:
     * @param id UUID of job posting
     * @param companyID UUID of company
     * @param title String of job title
     * @param location String of location
     * @param minHours int of minimum number of hours hiring for
     * @param maxHours int of maximum number of hours hiring for
     * @param pay double of pay rate/salary
     * @param expDate Date of when the job listing expires
     * @param numOpenings int of number of openings
     * @param skillsReq ArrayList<String> of the required skills
     * @param duties ArrayList<String> of the duties for the job
     * @param description String of the description
     * @param minExp String of the minimum experience required
     * @param remote boolean of whether or not the job opportunity is remote
     * @param open boolean of whether or not the job listing is open
     */
    public JobListing(UUID id, UUID companyID, String title, String location, int minHours, int maxHours,
            double pay, Date expDate, int numOpenings, ArrayList<String> skillsReq, ArrayList<String> duties, String description,
            String minExp, boolean remote, boolean open) {
        this.id = id;
        this.companyId = companyID;
        this.title = title;
        this.location = location;
        this.minHours = minHours;
        this.maxHours = maxHours;
        this.pay = pay;
        this.expDate = expDate;
        this.numOpenings = numOpenings;
        this.skillsReq = skillsReq;
        this.duties = duties;
        this.description = description;
        this.minExp = minExp;
        this.remote = remote;
        this.open = open;
    }
    /**
     * Returns the ID of the job listing
     * @return UUID of job listing
     */
    public UUID getID() {
        return this.id;
    }
    /**
     * Returns the ID of the company tied to the job listing
     * @return UUID of company's ID
     */
    public UUID getCompanyID() {
        return this.companyId;
    }
    /**
     * Get job title
     * @return String of job title
     */
    public String getTitle() {
        return title;
    }
    /**
     * Set the job title
     * @param title String of the job title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Get location of job
     * @return String of location
     */
    public String getLocation() {
        return location;
    }
    /**
     * Set the location for the job
     * @param location String of location
     */
    public void setLocation(String location) {
        this.location = location;
    }
    /**
     * Get the number of minimum hours for the job
     * @return int of minimum hours
     */
    public int getMinHours() {
        return minHours;
    }
    /**
     * Set the number of minimum hours for the job 
     * @param hours int of minimum number of hours
     */
    public void setMinHours(int hours) {
        this.minHours = hours;
    }
    /**
     * Get the number of maximum hours for the job 
     * @return int of maximum hours
     */
    public int getMaxHours() {
        return maxHours;
    }
    /**
     * Get the number of maximum hours for the job 
     * @param hours int of maximum number of hours
     */
    public void setMaxHours(int hours) {
        this.maxHours = hours;
    }
    /**
     * Get the pay rate for the job listing
     * @return double of the pay rate
     */
    public double getPay() {
        return pay;
    }
    /**
     * Set the pay rate for the job listing
     * @param pay double of the pay rate
     */
    public void setPay(double pay) {
        this.pay = pay;
    }
    /**
     * Get the expiration date for the job listing 
     * @return Date of when the listing expires
     */
    public Date getExpDate() {
        return expDate;
    }
    /**
     * Set the expiration date for the job listing
     * @param expDate Date of when the job listing expires
     */
    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }
    /**
     * Get the number of openings for the job listing
     * @return int of number of openings
     */
    public int getNumOpenings() {
        return numOpenings;
    }
    /**
     * Set the number of openings for the job listing
     * @param numOpenings int of the number of openings
     */
    public void setNumOpenings(int numOpenings) {
        this.numOpenings = numOpenings;
    }
    /**
     * Get the description for the job posting
     * @return String of job description
     */
    public String getDescription() {
        return description;
    }
    /**
     * Set the job description
     * @param description String of job description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Get the minimum experience required for the job
     * @return String of minimum experience required
     */
    public String getMinExp() {
        return minExp;
    }
    /**
     * Set the minimum experience required for the job
     * @param minExp String of minimum experience required
     */
    public void setMinExp(String minExp) {
        this.minExp = minExp;
    }
    /**
     * Returns whether or not the job is remote
     * @return boolean of whether or not the job is remote
     */
    public boolean isRemote() {
        return remote;
    }
    /**
     * Returns whether or whether or not the job is open
     * @return boolean of whether or not the job is open
     */
    public boolean isOpen() {
        if(expDate.before(new Date()) && open == true && numOpenings > 0){
            return true;
        }
            return false;
    }
    
    /**
     * Choose candidate for job posting based on application ID number
     * @param applicationId UUID of application ID that is selected
     * @return boolean of whether or not the candidate was successfully chosen.
     */
   public boolean chooseCandidate(UUID applicationId) {
        Applications applicationsList = Applications.getInstance();
        ArrayList<Application> applicants = applicationsList.getOpenApplicationsByJob(id);
        Students studentInst = Students.getInstance();
        for (Application application : applicants) {
            if (numOpenings <= 0 || !studentInst.getStudent(applicationId).available)
                return false;
            application.setAccepted(true);
            numOpenings--;
            return true;
        }
        return false;
   }
//    public void apply(UUID studentID, UUID companyID, UUID jobPostingID, String coverLetter, Date applicationDate){
//     this.studentId = studentID;
//     this.companyId = companyID;
//     this.jobPostingID = jobPostingID;
//     this.coverLetter = coverLetter;
//     this.applicationDate = applicationDate;
// }
   /**
    * Returns the job listing as a string
    */
    public String toString(){
        return "Job Listing information: " + "\n" +
        "\nTitle: " + title + "\nLocation: " + location + 
        "\nDescription: \n" + this.description + "\nMinimum experience " + minExp + 
        "\nMinimum hours: " + minHours + " Maximum hours: " + maxHours +
        "\nPay: " + pay + "\nExpires by " + expDate + 
        "\nSkills required: \n" + skillsReq + "\nDuties: \n" + duties +
        "\nRemote? : " + remote + "\nOpen? : " + open + "\nVolunteer? : " + volunteer;  
    }

}

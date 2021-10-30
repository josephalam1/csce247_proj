package src;

import java.util.UUID;
import java.util.Date;

public class Application {
    private UUID id;
    private UUID studentId;
    private UUID jobPostingId;
    private Date applicationDate;
    private String coverLetter;
    private boolean accepted;

    /**
     * Initializes an application with a pre-existing ID
     * @param id Application's ID
     * @param studentID Student's ID
     * @param jobPostingID Job posting's ID
     * @param coverLetter String of optional cover letter for the application
     * @param accepted Boolean of whether or not employee is accepted yet
     * @param applicationDate Date of when applicant applied
     */
    public Application(UUID id, UUID studentID, UUID jobPostingID, String coverLetter, boolean accepted,
                         Date applicationDate) {
        this.id = id;
        this.studentId = studentID;
        this.accepted = accepted;
        this.jobPostingId = jobPostingID;
        this.applicationDate = applicationDate;
        this.coverLetter = coverLetter;
    }
    /**
     * Initializes an application without a pre-existing ID
     * @param studentID Student's ID
     * @param jobPostingID Job posting's ID
     * @param coverLetter String of optional cover letter for the application
     */
    public Application(UUID studentID, UUID jobPostingID, String coverLetter) {
        this.id = UUID.randomUUID();
        this.studentId = studentID;
        this.jobPostingId = jobPostingID;
        this.applicationDate = new Date();
        this.coverLetter = coverLetter;
        this.accepted = false;
    }
    /**
     * Gets the Date of the application
     * @return Date date of application
     */
    public Date getApplicationDate() {
        return applicationDate;
    }
    /**
     * Set cover letter for application
     * @param coverLetter String of cover letter
     */
    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }
    /**
     * Gets the ID of this application
     * @return UUID of application
     */
    public UUID getId() {
        return id;
    }
    /**
     * Gets the student id from application
     * @return UUID of Student's ID
     */
    public UUID getStudentId() {
        return studentId;
    }
    /**
    * Gets the Job Posting ID from application
    * @return UUID of job posting's ID
    */
   public UUID getJobId() {
       return jobPostingId;
   }
    /**
     * Get whether or not student was accepted yet
     * @return boolean of whether or not student was accepted yet
     */
    public boolean getAccepted() {
        return accepted;
    }
    /**
     * Get the cover letter for this application
     * @return String of cover letter
     */
    public String getCoverLetter() {
        return this.coverLetter;
    }
    /**
     * Sets whether or not the user was accepted
     * @param accepted boolean if user was accepted or not
     */
    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
    public String toString() {
        return "Application: ";
    }

}

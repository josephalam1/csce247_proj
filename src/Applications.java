package src;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Applications Class for creating a list of application objects to interact with
 * @author Joseph Alam
 */
public class Applications {
    
    private static Applications instance = null;
    private ArrayList<Application> applications;

    /**
     * Initializes Applications class by loading companies from DataLoader
     */
    private Applications() {
        applications = DataLoader.getApplications();
    }

    /**
     * Creates an instance of the Applications class if one does not already exist
     * @return instance of the Applications class
     */
    public static Applications getInstance() {
        if(instance == null) {
            instance = new Applications();
        }
        return instance;
    }

    /**
     * Returns the list of applications
     * @return ArrayList<Application>: Array of application objects
     */
    public ArrayList<Application> getApplicants() {
        return applications;
    }

    /**
     * Gets an array of all the open applications based on student ID
     * @param studentId UUID of Student's applications
     * @return ArrayList<Application> ArrayList containing all the open applications for the student
     */
    public ArrayList<Application> getOpenApplicationsByStudent(UUID studentId) {
        ArrayList<Application> openApplications  = new ArrayList<Application>();
        for(Application application: applications) {
            if(studentId.equals(application.getStudentId()) && application.getAccepted() == false) {
                openApplications.add(application);
            }
        }
        return openApplications;
    }
    /**
     * Gets an array of all the open applications based on job posting ID
     * @param studentId UUID of the job posting for the applications
     * @return ArrayList<Application> ArrayList containing all the open applications for the job posting
     */
    public ArrayList<Application> getOpenApplicationsByJob(UUID jobId) {
        ArrayList<Application> openApplications  = new ArrayList<Application>();
        for(Application application: applications) {
            if(jobId.equals(application.getJobId()) && application.getAccepted() == false) {
                openApplications.add(application);
            }
        }
        return openApplications;
    }

    /**
     * Adds an application to the list of applications
     * @param application Application to be added
     * @return boolean of whether or not the application was added
     */
    public boolean addApplication(Application application) {
        for (Application pastApplications : applications) {
            if(application.getJobId() == pastApplications.getJobId() && application.getStudentId() == pastApplications.getStudentId()) {
                return false;
            }
        }
        applications.add(application);
        DataWriter.saveApplications();
        return true;
    }
}
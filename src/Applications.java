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

    public ArrayList<Application> getOpenApplicationsByStudent(UUID studentId) {
        ArrayList<Application> openApplications  = new ArrayList<Application>();
        for(Application application: applications) {
            if(studentId == application.getStudentId() && application.getAccepted() == false) {
                openApplications.add(application);
            }
        }
        return openApplications;
    }

    public ArrayList<Application> getOpenApplicationsByJob(UUID jobId) {
        ArrayList<Application> openApplications  = new ArrayList<Application>();
        for(Application application: applications) {
            if(jobId == application.getJobId() && application.getAccepted() == false) {
                openApplications.add(application);
            }
        }
        return openApplications;
    }
}
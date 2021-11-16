package src;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.lang.model.type.NullType;

public class ApplicationsTest {

    private static Applications app = Applications.getInstance();
    UUID tStudentID = UUID.randomUUID(); // for student
    UUID tJobtID = UUID.randomUUID(); // for job
    UUID tAppID = UUID.randomUUID(); // for apps
    private ArrayList<Application> appList = app.getApplicants();
    private ArrayList<Application> appJobList = app.getOpenApplicationsByJob(tJobtID);
    private ArrayList<Application> appStudentList = app.getOpenApplicationsByStudent(tStudentID);


    @BeforeEach
    public void setup() {
       appList.clear();
       appList.add(new Application(tAppID, tStudentID, tJobtID, "cover letter 1 ", true, new Date()));
       appList.add(new Application(tStudentID, tJobtID, "cover letter 2 "));
       
       DataWriter.saveApplications();
    }

    @AfterEach 
    public void tearDown() {
        appList.clear();
        DataWriter.saveApplications();
    }
   @Test 
    void testAppNotAdded() {
        for (Application pastApplications : appList) {
            if(appList.get(0).getJobId() != pastApplications.getJobId() && appList.get(0).getStudentId() != pastApplications.getStudentId()) {
                assertTrue(
                    app.addApplication(new Application(null, null, null, "", false, new Date())));
            }
        }
    }
    @Test 
    void testAppAdded() {
        assertFalse(
        app.addApplication(new Application(tAppID, tStudentID, tJobtID, "cover letter 3 ", true, new Date())));
    }
    @Test
    void testGetAppOpenJobExistsById() {
        ArrayList<Application> openApplications = app.getOpenApplicationsByJob(tJobtID);
        assertEquals(openApplications, app.getOpenApplicationsByJob(tJobtID));
    }
    @Test
    void testGetAppOpenStudentExistsById() {
        ArrayList<Application> openStudentApplications = app.getOpenApplicationsByStudent(tStudentID);
        assertEquals(openStudentApplications, app.getOpenApplicationsByStudent(tStudentID));
    }
    
    
}

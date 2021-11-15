package src;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ApplicationsTest {
    UUID studentId = UUID.randomUUID();
    UUID companyID = UUID.randomUUID();
    private Applications applications = Applications.getInstance();
    private ArrayList<Application> applicationList = applications.getApplicants();
    public Application app = new Application(studentId, companyID, "coverletter");
   
    // @BeforeEach
    // public void setup() {
    //     applicationList.clear();
    //     applicationList.add(app);
    //     DataWriter.saveApplications();
    // }

    // @AfterEach
    // public void tearDown() {
    //     applications.getInstance().getApplicants().clear();
    //     DataWriter.saveApplications();
    // }

    @Test
    void testGetOpenApplicationsByStudent(UUID studentId){
        boolean openByStudent;
        if(applications.getOpenApplicationsByStudent(studentId) != null){
            openByStudent = true;//.getOpenApplicationsByStudent(studentId);
            //assertTrue(applications.getOpenApplicationsByStudent(studentId), studentId.)
        }
        else{
            openByStudent = false;
        }
        assertTrue(openByStudent);
    }

    @Test
    void testGetOpenApplicationsByJob(UUID companyID){
        boolean openByJob;
        if(applications.getOpenApplicationsByStudent(studentId) != null){
            openByJob = true;//.getOpenApplicationsByStudent(studentId);
            //assertTrue(applications.getOpenApplicationsByStudent(studentId), studentId.)
        }
        else{
            openByJob = false;
        }
        assertTrue(openByJob);    }

    @Test
    void testAddApplication(Application app){
        applicationList.add(app);
        //boolean hasApp = applications.hasApp(app.getId());
        //assertTrue(hasApp);
    }
}

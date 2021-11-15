package src;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class CompanyTest {
    UUID appID = UUID.randomUUID();
    private Application app = new Application(appID,UUID.randomUUID(), UUID.randomUUID(), "coverLetter", false, new Date());

    // private Company company = 
   // private ArrayList<Company> companyList = companies.getCompanies();
   ArrayList<Application> appList;

    @Test
    void sortTest() {
        JobListing job = new JobListing(UUID.randomUUID(), "Boss", "New york", 0, 4, 100, new Date(), 1, null, null, "boss people around", "none", false, true);
        job.chooseCandidate(appID);
        appList.add(app);
    }

    @Test
    void editListingTest() {
    JobListing job = new JobListing(UUID.randomUUID(), "Boss", "New york", 0, 4, 100, new Date(), 1, null, null, "boss people around", "none", false, true);
    Admin admin = new Admin(UUID.randomUUID(), "Joe", "Joe", "joe@joe.com");
    admin.editListing(job, true);
    assertEquals("Admin edit", job.getTitle());
    }

    @Test
    void deleteListingTest(){
    JobListing job = new JobListing(UUID.randomUUID(), "Boss", "New york", 0, 4, 100, new Date(), 1, null, null, "boss people around", "none", false, true);
    Admin admin = new Admin(UUID.randomUUID(), "Joe", "Joe", "joe@joe.com");
    ///admin.jobs.add(job);
    admin.deleteListing(job, true);
    //assertFalse(admin.jobs.contains(job));
    }
}

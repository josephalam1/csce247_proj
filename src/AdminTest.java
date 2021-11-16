package src;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdminTest {

   
    @Test
    void editJobListingTest() {
    JobListing job = new JobListing(UUID.randomUUID(), "Boss", "New york", 0, 4, 100, new Date(), 1, null, null, "boss people around", "none", false, true);
    Admin admin = new Admin(UUID.randomUUID(), "Joe", "Joe", "joe@joe.com");
    admin.editListing(job, true);
    assertEquals("Admin edit", job.getTitle());
    }

    @Test
    void deleteJobListingTest(){
    JobListing job = new JobListing(UUID.randomUUID(), "Boss", "New york", 0, 4, 100, new Date(), 1, null, null, "boss people around", "none", false, true);
    Admin admin = new Admin(UUID.randomUUID(), "Joe", "Joe", "joe@joe.com");
    admin.jobs = new ArrayList<JobListing>();
    //admin.jobs.add(job);
    admin.jobs.add(job);
    admin.deleteListing(job, true);
    assertFalse(admin.jobs.contains(job));
    }
}

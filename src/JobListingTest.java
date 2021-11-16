package src;
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;
import java.util.Date;
import org.junit.jupiter.api.Test;

public class JobListingTest {
    Student student = new Student("Joseph Alam", "joeyalam@email.com", "123-456-7890", "password",
    new Date(), "M", "M", true, null, 4.0, "Columbia", "Sophmore", "Computer Science",
    2024, 0.0, "jalam" );
    JobListing job = new JobListing(UUID.randomUUID(), "Boss", "New york", 0, 4, 100, new Date(), 1, null, null, "boss people around", "none", false, true);
    Application application = new Application(student.getId(), job.getID(), "cover letter");    

    @Test
    void testChooseCandidate() {
        assertTrue(job.chooseCandidate(application.getId()));
    }
    @Test
    void testChooseCandidateNumOpenings() {
        job.chooseCandidate(application.getId());
        assertEquals(0, job.getNumOpenings());
    }

}
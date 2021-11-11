package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

class DataLoaderTest {
    UUID testId = UUID.randomUUID();
    private Students students = Students.getInstance();
    private ArrayList<Student> studentList = students.getStudents();
    private Companies companies = Companies.getInstance();
    private ArrayList<Company> companyList = companies.getCompanies();
    private ArrayList<JobListing> jobList = companies.getJobs();
    private Resumes resumes = Resumes.getInstance();
    private ArrayList<Resume> resumeList = resumes.getResumes();
    private Applications applications = Applications.getInstance();
    private ArrayList<Application> applicationList = applications.getApplicants();

    @BeforeEach
    public void setup() {
        studentList.clear();
        studentList.add(new Student("Joseph Alam", "joeyalam@email.com", "123-456-7890", "password",
            new Date(), "M", "M", true, null, 4.0, "Columbia", "Sophmore",
            "Computer Science", 2023, 0.0, "jalam" ));
        companyList.clear();
        companyList.add(new Company("Company A", "jalam2", "joeyalam@email.com", "password", 
        "123 st.", "Joey Alam", "123-456-7890", new Date(), "http://www.com/", 0.0)); 
        jobList.clear();
        jobList.add(new JobListing(UUID.randomUUID(), "New job", "remote", 0, 10, 14, new Date(), 3, 
            new ArrayList<String>(), new ArrayList<String>(), "easy job", "sophmore", true, true));
        resumeList.clear();
        resumeList.add(new Resume(testId, new ArrayList<String>(), 
                        new ArrayList<Experiences>(), new ArrayList<References>()));
        applicationList.clear();
        applicationList.add(new Application(UUID.randomUUID(), UUID.randomUUID(), "cover letter"));
        DataWriter.saveStudents();
        DataWriter.saveCompanies();
        DataWriter.saveJobs();
        DataWriter.saveResumes();
        DataWriter.saveApplications();
    }

    @AfterEach 
    public void tearDown() {
        students.getInstance().getStudents().clear();
        companies.getInstance().getCompanies().clear();
        companies.getInstance().getJobs().clear();
        resumes.getInstance().getResumes().clear();
        applications.getInstance().getApplicants().clear(); 
        DataWriter.saveStudents();
        DataWriter.saveCompanies();
        DataWriter.saveJobs();
        DataWriter.saveResumes();
        DataWriter.saveApplications();
    }
    //================================= TEST STUDENT FUNCTIONS ======================
    @Test
    void testGetStudentsSize() {
        studentList = DataLoader.getStudents();
        assertEquals(1, studentList.size());
    }

    @Test
    void testGetStudentsSizeZero() {
        students.getInstance().getStudents().clear();
        DataWriter.saveStudents();
        assertEquals(0, studentList.size());
    }
    @Test
    void testGetStudentUsername() {
        studentList = DataLoader.getStudents();
        assertEquals("jalam", studentList.get(0).username);
    } 
    //======================== TEST COMPANY FUNCTIONS =============================
    @Test
    void testGetCompanySize() {
        companyList = DataLoader.getCompanies();
        assertEquals(1, companyList.size());
    }

    @Test
    void testGetCompanySizeZero() {
        companies.getInstance().getCompanies().clear();
        DataWriter.saveCompanies();
        assertEquals(0, companyList.size());
    }
    @Test
    void testGetCompanyName() {
        companyList = DataLoader.getCompanies();
        assertEquals("Company A", companyList.get(0).name);
    } 
    //======================== TEST JOB LISTING FUNCTIONS =========================== 
    @Test
    void testGetJobsSize() {
        jobList = DataLoader.getJobListings();
        assertEquals(1, companyList.size());
    }

    @Test
    void testGetJobSizeZero() {
        companies.getInstance().getJobs().clear();
        DataWriter.saveJobs();
        assertEquals(0, jobList.size());
    }

    @Test
    void testGetJobOpenings() {
        jobList = DataLoader.getJobListings();
        assertEquals(3, jobList.get(0).getNumOpenings());
    }
    //============================TEST RESUME FUNCTIONS=============================
    @Test
    void testGetResumeSize() {
        resumeList = DataLoader.getResumes();
        assertEquals(1, resumeList.size());
    }

    @Test
    void testGetResumeSizeZero() {
        resumes.getInstance().getResumes().clear();
        DataWriter.saveResumes();
        assertEquals(0, resumeList.size());
    }

    @Test
    void testGetResumeStudentId() {
        resumeList = DataLoader.getResumes();
        assertEquals(testId, resumeList.get(0).getStudentId());
    }
    //==========================TEST APPLICATION FUNCTIONS==========================
    @Test
    void testGetApplicationSize() {
        applicationList = DataLoader.getApplications();
        assertEquals(1, applicationList.size());
    }

    @Test
    void testGetApplicationSizeZero() {
        applications.getInstance().getApplicants().clear();
        DataWriter.saveApplications();
        assertEquals(0, applicationList.size());
    }

    @Test
    void testGetApplicationCoverLetter() {
        applicationList = DataLoader.getApplications();
        assertEquals("cover letter", applicationList.get(0).getCoverLetter());
    }
}
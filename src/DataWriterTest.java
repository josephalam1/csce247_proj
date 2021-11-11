package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

class DataWriterTest {
    private UUID testId = UUID.randomUUID();
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
    void testWritingZeroStudents() {
        studentList = DataLoader.getStudents();
        assertEquals(0, studentList.size());
    }

    @Test
    void testWritingOneStudent() {
        studentList.add(new Student("Joseph Alam", "joeyalam@email.com", "123-456-7890", "password",
            new Date(), "M", "M", true, null, 4.0, "Columbia", "Sophmore",
            "Computer Science", 2023, 0.0, "jalam" ));
        DataWriter.saveStudents();
        assertEquals("jalam", studentList.get(0).username);
    }

    @Test
    void testWritingThreeStudents() {
        studentList.add(new Student("Joseph Alam", "joeyalam@email.com", "123-456-7890", "password",
            new Date(), "M", "M", true, null, 4.0, "Columbia", "Sophmore",
            "Computer Science", 2023, 0.0, "jalam" ));
        studentList.add(new Student("Joseph Alam", "joeyalam@email.com", "123-456-7890", "password",
            new Date(), "M", "M", true, null, 4.0, "Columbia", "Sophmore",
            "Computer Science", 2023, 0.0, "kalam" ));
        studentList.add(new Student("Joseph Alam", "joeyalam@email.com", "123-456-7890", "password",
            new Date(), "M", "M", true, null, 4.0, "Columbia", "Sophmore",
            "Computer Science", 2023, 0.0, "lalam" ));
        DataWriter.saveStudents();
        assertEquals("lalam", studentList.get(2).username);
    }
    
    @Test
    void testWritingEmptyStudent() {
        studentList.add(new Student("", "", "", "", new Date(), "", "", true, null, 
        4.0, "", "", "", 2023, 0.0, "" ));
        DataWriter.saveStudents();
        assertEquals("", studentList.get(0).username);
    }
    
    @Test
    void testWritingNullStudent() {
        studentList.add(new Student(null, null, null, null, new Date(), null, null, 
        true, null, 4.0, null, null, null, 2023, 0.0, null));
        DataWriter.saveStudents();
        assertEquals(null, studentList.get(0).username);
    }
    //======================== TEST COMPANY FUNCTIONS =============================
    @Test
    void testWritingZeroCompanies() {
        companyList = DataLoader.getCompanies();
        assertEquals(0, companyList.size());
    }

    @Test
    void testWritingOneCompany() {
        companyList.add(new Company("Company A", "bossman", "joeyalam@email.com", "password", 
        "123 st.", "Joey Alam", "123-456-7890", new Date(), "http://www.com/", 0.0)); 
        DataWriter.saveCompanies();
        assertEquals("bossman", companyList.get(0).username);
    }

    @Test
    void testWritingThreeCompanies() {
        companyList.add(new Company("Company A", "bossman", "joeyalam@email.com", "password", 
        "123 st.", "Joey Alam", "123-456-7890", new Date(), "http://www.com/", 0.0)); 
        companyList.add(new Company("Company A", "bossman2", "joeyalam@email.com", "password", 
        "123 st.", "Joey Alam", "123-456-7890", new Date(), "http://www.com/", 0.0)); 
        companyList.add(new Company("Company A", "bossman3", "joeyalam@email.com", "password", 
        "123 st.", "Joey Alam", "123-456-7890", new Date(), "http://www.com/", 0.0)); 
        DataWriter.saveCompanies();
        assertEquals("bossman3", companyList.get(2).username);
    }
    
    @Test
    void testWritingEmptyCompany() {
        companyList.add(new Company("", "", "", "", "", "", "", new Date(), "", 0.0)); 
        DataWriter.saveCompanies();
        assertEquals("", companyList.get(0).username);
    }
    
    @Test
    void testWritingNullCompany() {
        companyList.add(new Company(null, null, null, null, null, null, null,
                        new Date(), null, 0.0)); 
        DataWriter.saveCompanies();
        assertEquals(null, companyList.get(0).username);
    }
    //======================== TEST JOB LISTING FUNCTIONS =========================== 
    @Test
    void testWritingZeroJobs() {
        jobList = DataLoader.getJobListings();
        assertEquals(0, jobList.size());
    }

    @Test
    void testWritingOneJobs() {
        jobList.add(new JobListing(UUID.randomUUID(), "New job", "remote", 0, 10, 14, new Date(), 3, 
            null, null, "easy job", "sophmore", true, true));
        DataWriter.saveJobs();
        assertEquals(3, jobList.get(0).getNumOpenings());
    }

    @Test
    void testWritingThreeJobs() {
        jobList.add(new JobListing(UUID.randomUUID(), "New job", "remote", 0, 10, 14, new Date(), 3, 
            null, null, "easy job", "sophmore", true, true));
        jobList.add(new JobListing(UUID.randomUUID(), "New job", "remote", 0, 10, 15, new Date(), 2, 
            null, null, "easy job", "junior", true, true));
        jobList.add(new JobListing(UUID.randomUUID(), "New job", "remote", 0, 10, 16, new Date(), 1, 
            null, null, "easy job", "senior", true, true));
        DataWriter.saveJobs();
        assertEquals(1, jobList.get(2).getNumOpenings());
    }
    
    @Test
    void testWritingEmptyJobs() {
        jobList.add(new JobListing(UUID.randomUUID(), "", "", 0, 10, 14, new Date(), 3, 
            null, null, "", "", true, true));
        DataWriter.saveJobs();
        assertEquals("", jobList.get(0).getTitle());
    }
    
    @Test
    void testWritingNullJobs() {
        jobList.add(new JobListing(UUID.randomUUID(), null, null, 0, 10, 14, new Date(), 3, 
            null, null, null, null, true, true));
        DataWriter.saveJobs();
        assertEquals(null, jobList.get(0).getTitle());
    }
    //============================TEST RESUME FUNCTIONS=============================
    @Test
    void testWritingZeroResumes() {
        resumeList = DataLoader.getResumes();
        assertEquals(0, resumeList.size());
    }

    @Test
    void testWritingOneResume() {
        resumeList.add(new Resume(testId, null, new ArrayList<Experiences>(), new ArrayList<References>()));
        DataWriter.saveResumes();
        assertEquals(testId, resumeList.get(0).getStudentId());
    }

    @Test
    void testWritingThreeResumes() {
        resumeList.add(new Resume(UUID.randomUUID(), null, new ArrayList<Experiences>(), new ArrayList<References>()));
        resumeList.add(new Resume(UUID.randomUUID(), null, new ArrayList<Experiences>(), new ArrayList<References>()));
        resumeList.add(new Resume(testId, null, new ArrayList<Experiences>(), new ArrayList<References>()));
        DataWriter.saveResumes();
        assertEquals(testId, resumeList.get(2).getStudentId());
    }
    
    @Test
    void testWritingEmptyResumes() {
        resumeList.add(new Resume(testId, new ArrayList<String>(), 
                        new ArrayList<Experiences>(), new ArrayList<References>()));
        DataWriter.saveResumes();
        assertEquals(new ArrayList<String>(), resumeList.get(0).getSkills());
    }
    
    @Test
    void testWritingNullResumes() {
        resumeList.add(new Resume(testId, null, new ArrayList<Experiences>(), new ArrayList<References>()));
        DataWriter.saveResumes();
        assertEquals(null, resumeList.get(0).getSkills());
    }
    //==========================TEST APPLICATION FUNCTIONS==========================
    @Test
    void testWritingZeroApplications() {
        applicationList = DataLoader.getApplications();
        assertEquals(0, applicationList.size());
    }
    
    @Test
    void testWritingOneApplication() {
        applicationList.add(new Application(UUID.randomUUID(), UUID.randomUUID(), "cover letter"));
        DataWriter.saveApplications();
        assertEquals("cover letter", applicationList.get(0).getCoverLetter());
    }

    @Test
    void testWritingThreeApplications() {
        applicationList.add(new Application(UUID.randomUUID(), UUID.randomUUID(), "cover letter"));
        applicationList.add(new Application(UUID.randomUUID(), UUID.randomUUID(), "cover letter - 2"));
        applicationList.add(new Application(UUID.randomUUID(), UUID.randomUUID(), "cover letter - 3"));
        DataWriter.saveApplications();
        assertEquals("cover letter - 3", applicationList.get(2).getCoverLetter());    }
    
    @Test
    void testWritingEmptyApplication() {
        applicationList.add(new Application(UUID.randomUUID(), UUID.randomUUID(), ""));
        DataWriter.saveApplications();
        assertEquals("", applicationList.get(0).getCoverLetter());
    }
    
    @Test
    void testWritingNullApplication() {
        applicationList.add(new Application(UUID.randomUUID(), UUID.randomUUID(), null));
        DataWriter.saveApplications();
        assertEquals(null, applicationList.get(0).getCoverLetter());
    }
}
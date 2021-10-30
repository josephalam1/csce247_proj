package src;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;

import javax.management.remote.JMXProviderException;

/**
 * DataWriter class for writing data to JSON files
 * @author Joseph Alam
 */
public class DataWriter {
    private static SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");

    /**
     * Saves the list of students to the JSON file
     */
    public static void saveStudents() {
        Students studentInst = Students.getInstance();
        ArrayList<Student> students = studentInst.getStudents();
        JSONArray studentsJ = new JSONArray();
        // Creating the JSON Objects
        for (int i = 0; i < students.size(); i++) {
            studentsJ.add(getStudentsJSON(students.get(i)));
        }
        // Writing JSON Objects to File
        try (FileWriter file = new FileWriter("data/students.json")) {
            file.write(studentsJ.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Saves the list of companies to the JSON file
     */
    public static void saveCompanies() {
        Companies companiesInst = Companies.getInstance();
        ArrayList<Company> companies = companiesInst.getCompanies();
        JSONArray companiesJ = new JSONArray();
        // Creating the JSON Objects
        for (int i = 0; i < companies.size(); i++) {
            companiesJ.add(getCompanyJSON(companies.get(i)));
        }
        // Writing JSON Objects to File
        try (FileWriter file = new FileWriter("data/employers.json")) {
            file.write(companiesJ.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Saves the list of Resumes to the json file
     */
    public static void saveResumes() {
        Resumes resumesInst = Resumes.getInstance();
        ArrayList<Resume> resumes = resumesInst.getResumes();
        JSONArray resumesJ = new JSONArray();
        // Creating the JSON Objects
        for (int i = 0; i < resumes.size(); i++) {
            resumesJ.add(getResumeJSON(resumes.get(i)));
        }
        // Writing JSON Objects to File
        try (FileWriter file = new FileWriter("data/resumes.json")) {
             file.write(resumesJ.toJSONString());
             file.flush();
        } catch (IOException e) {
             e.printStackTrace();
        }
    }
    /**
     * Saves the list of applications to JSON file
     */
    public static void saveApplications() {
        Applications applicationsInst = Applications.getInstance();
        ArrayList<Application> applications = applicationsInst.getApplicants();
        JSONArray applicationsJ = new JSONArray();
        // Creating the JSON Objects
        for (int i = 0; i < applications.size(); i++) {
            applicationsJ.add(getApplicationJSON(applications.get(i)));
        }
        // Writing JSON Objects to File
        try (FileWriter file = new FileWriter("data/applications.json")) {
            file.write(applicationsJ.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves the list of job postings to JSON file
     */
    public static void saveJobs() {
        Companies companiesInst = Companies.getInstance();
        ArrayList<JobListing> jobs = companiesInst.getJobs();
        JSONArray jobsJ = new JSONArray();
        // Creating the JSON Objects
        for (int i = 0; i < jobs.size(); i++) {
            jobsJ.add(getJobJSON(jobs.get(i)));
        }
        // Writing JSON Objects to File
        try (FileWriter file = new FileWriter("data/job-postings.json")) {
            file.write(jobsJ.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getStudentsJSON(Student student) {
        JSONObject studentDetails = new JSONObject();
        studentDetails.put("id", student.getId().toString());
        studentDetails.put("resumeID", student.resumeId.toString());
        studentDetails.put("name", student.name);
        studentDetails.put("username", student.username);
        studentDetails.put("gender", student.getGender());
        studentDetails.put("sex", student.getSex());
        studentDetails.put("email", student.email);
        studentDetails.put("password", student.getPassword());
        studentDetails.put("dob", ft.format(student.getDateOfBirth()));
        studentDetails.put("GPA", student.getGPA());
        studentDetails.put("campusLocation", student.campusLocation);
        studentDetails.put("year", student.currYear);
        studentDetails.put("major", student.currMajor);
        studentDetails.put("available", student.available);
        studentDetails.put("rating", student.getRating());
        return studentDetails;
    }
    public static JSONObject getCompanyJSON(Company company) {
        JSONObject companyDetails = new JSONObject();
        companyDetails.put("id", company.getId().toString());
        companyDetails.put("recruiterName", company.hiringRecruiter);
        companyDetails.put("recruiterUsername", company.username);
        companyDetails.put("recruiterEmail", company.recruiterEmail);
        companyDetails.put("recruiterPhone", company.contactInfo);
        companyDetails.put("dateEstablished", ft.format(company.dateEstablished));
        companyDetails.put("password", company.getPassword());
        companyDetails.put("companyAddress", company.address);
        companyDetails.put("companyName", company.name);
        companyDetails.put("companyWebsite", company.webSite);
        companyDetails.put("rating", company.getRating());
        return companyDetails;
    }
    public static JSONObject getResumeJSON(Resume resume) {
        JSONObject resumeDetails = new JSONObject();
        resumeDetails.put("ID", resume.getId().toString());
        resumeDetails.put("studentID", resume.getStudentId().toString());
        resumeDetails.put("skills", resume.skills);
        resumeDetails.put("experience", resume.getJsonExperience());;
        resumeDetails.put("references", resume.getJsonReference());
        return resumeDetails;
    }

    public static JSONObject getApplicationJSON(Application application) {
        JSONObject applicationDetails = new JSONObject();
        applicationDetails.put("id", application.getId().toString());
        applicationDetails.put("studentID", application.getStudentId().toString());
        applicationDetails.put("jobPostingID", application.getJobId().toString());
        applicationDetails.put("coverLetter", application.getCoverLetter());
        applicationDetails.put("accepted", application.getAccepted());
        applicationDetails.put("application_date", ft.format(application.getApplicationDate()));
        return applicationDetails;
    }

    public static JSONObject getJobJSON(JobListing job) {
        JSONObject jobDetails = new JSONObject();
        jobDetails.put("id", job.getID().toString());
        jobDetails.put("companyID", job.getCompanyID().toString());
        jobDetails.put("title", job.getTitle());
        jobDetails.put("minHours", job.getMinHours());
        jobDetails.put("maxHours", job.getMaxHours());
        jobDetails.put("pay", job.getPay());
        jobDetails.put("numOpenings", job.getNumOpenings());
        jobDetails.put("skillsReq", job.getSkillsReq());
        jobDetails.put("duties", job.duties);
        jobDetails.put("minExp", job.getMinExp());
        jobDetails.put("numOpenings", job.getNumOpenings());
        jobDetails.put("maxHours", job.getMaxHours());
        jobDetails.put("open", job.open);
        jobDetails.put("remote", job.remote);
        jobDetails.put("volunteer", job.volunteer);
        jobDetails.put("expDate", ft.format(job.getExpDate()));
        jobDetails.put("description", job.getDescription());
        jobDetails.put("location", job.getLocation());
        return jobDetails;
    }

}
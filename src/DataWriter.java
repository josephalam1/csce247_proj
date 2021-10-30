package src;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;

/**
 * DataWriter class for writing data to JSON files
 * @author Joseph Alam
 */
public class DataWriter {
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
        System.out.println(resumes);
        JSONArray resumesJ = new JSONArray();
        // Creating the JSON Objects
        for (int i = 0; i < resumes.size(); i++) {
            resumesJ.add(getResumeJSON(resumes.get(i)));
        }
        // Writing JSON Objects to File
        System.out.print(resumesJ.toJSONString());
       // try (FileWriter file = new FileWriter("data/resumes.json")) {
            // file.write(companiesJ.toJSONString());
            // file.flush();
       // } catch (IOException e) {
            // e.printStackTrace();
      //  }
    }
    public static void saveApplications() {

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
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
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
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
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
        resumeDetails.put("studentID", resume.getStudentId());
        resumeDetails.put("skills", resume.skills);
        resumeDetails.put("experience", resume.getJsonExperience());
        resumeDetails.put("references", resume.getJsonReference());
        return resumeDetails;
    }
    public static void main(String[] args) {
        saveResumes();
    }
}
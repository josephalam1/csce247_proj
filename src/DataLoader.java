package src;

import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.ArrayList;

public class DataLoader {

    public static ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            FileReader reader = new FileReader("csce247_proj/data/students.json");
            JSONArray studentsJSON = (JSONArray) new JSONParser().parse(reader);
            for(int i = 0; i < studentsJSON.size(); i++) {
                JSONObject studentJSON = (JSONObject)studentsJSON.get(i);
                UUID id = UUID.fromString((String)studentJSON.get("id"));
                UUID resumeId = UUID.fromString((String)studentJSON.get("resumeID"));
                String name = (String)studentJSON.get("name");
                String username = (String)studentJSON.get("username");
                String email = (String)studentJSON.get("email");
                String password = (String)studentJSON.get("password");
                SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
                Date dob = ft.parse((String)studentJSON.get("dob"));
                String sex = (String)studentJSON.get("sex");
                String gender = (String)studentJSON.get("gender");
                boolean available = (boolean)studentJSON.get("available");
                double gpa = (double)studentJSON.get("GPA");
                int year = ((Long)studentJSON.get("year")).intValue();;
                String location = (String)studentJSON.get("campusLocation");
                String major = (String)studentJSON.get("major");
                double rating = (double)studentJSON.get("rating");

                students.add(new Student(id, resumeId, name, email, password, dob, sex, gender,
                     null, available, null, gpa, location, null, major, year, rating, username));
            }

            return students;

        } catch(Exception e) {
            e.printStackTrace();
        }
            return null;
    }

    public static ArrayList<Company> getCompanies() {
        ArrayList<Company> companies = new ArrayList<Company>();
        try {
            FileReader reader = new FileReader("csce247_proj/data/employers.json");
            JSONArray companysJSON = (JSONArray) new JSONParser().parse(reader);
            for(int i = 0; i < companysJSON.size(); i++) {
                JSONObject companyJSON = (JSONObject)companysJSON.get(i);
                UUID id = UUID.fromString((String)companyJSON.get("id"));
                String name = (String)companyJSON.get("recruiterName");
                String username = (String)companyJSON.get("recruiterUsername");
                String password = (String)companyJSON.get("password");
                SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
                Date dob = ft.parse((String)companyJSON.get("dateEstablished"));
                String companyName = (String)companyJSON.get("companyName");
                String email = (String)companyJSON.get("recruiterEmail");
                String address = (String)companyJSON.get("companyAddress");
                String phone = (String)companyJSON.get("recruiterPhone");
                String website = (String)companyJSON.get("recruiterWebsite");
                double rating = (double)companyJSON.get("rating");

                companies.add(new Company(id, companyName, username, email, password, address, 
                    name, phone, dob, website, rating));
            }

            return companies;

        } catch(Exception e) {
            e.printStackTrace();
        }
            return null;
    }

    public static ArrayList<JobListing> getJobListings() {
        ArrayList<JobListing> jobs = new ArrayList<JobListing>();
        try {
            FileReader reader = new FileReader("data/job-postings.json");
            JSONArray jobsJSON = (JSONArray) new JSONParser().parse(reader);
            for(int i = 0; i < jobsJSON.size(); i++) {
                JSONObject jobJSON = (JSONObject)jobsJSON.get(i);
                UUID id = UUID.fromString((String)jobJSON.get("id"));
                UUID companyid = UUID.fromString((String)jobJSON.get("companyID"));
                String title = (String)jobJSON.get("title");
                int minHours = ((Long)jobJSON.get("minHours")).intValue();
                int maxHours = ((Long)jobJSON.get("maxHours")).intValue();
                double pay = ((Long)jobJSON.get("pay")).doubleValue();
                int numOpenings = ((Long)jobJSON.get("numOpenings")).intValue();
                JSONArray skills = (JSONArray)jobJSON.get("skillsReq");
                ArrayList<String> skillsReq = new ArrayList<String>();
                for(int j = 0; j < skills.size(); j++) {
                    skillsReq.add((String)skills.get(j));
                }
                String minExp = (String)jobJSON.get("minExp");
                JSONArray dutiesJSON = (JSONArray)jobJSON.get("duties");
                ArrayList<String> duties = new ArrayList<String>();
                for(int j = 0; j < dutiesJSON.size(); j++) {
                    duties.add((String)dutiesJSON.get(j));
                }
                boolean remote = (boolean)jobJSON.get("remote");
                boolean open = (boolean)jobJSON.get("open");
                String description = (String)jobJSON.get("description");
                String location = (String)jobJSON.get("location");
                SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
                Date expirationDate = ft.parse((String)jobJSON.get("expDate"));
                jobs.add(new JobListing(id, companyid, title, location, minHours, maxHours, pay, expirationDate,
                             numOpenings, skillsReq, description, minExp, remote, open));
            }

            return jobs;

        } catch(Exception e) {
            e.printStackTrace();
        }
            return null;
    }

    public static ArrayList<Application> getApplications() {
        ArrayList<Application> applications = new ArrayList<Application>();
        try {
            FileReader reader = new FileReader("data/applications.json");
            JSONArray applicationsJSON = (JSONArray) new JSONParser().parse(reader);
            for(int i = 0; i < applicationsJSON.size(); i++) {
                JSONObject applicationJSON = (JSONObject)applicationsJSON.get(i);
                UUID id = UUID.fromString((String)applicationJSON.get("id"));
                UUID studentID = UUID.fromString((String)applicationJSON.get("studentID"));
                UUID companyID = UUID.fromString((String)applicationJSON.get("jobPostingID"));
                String coverLetter = (String)applicationJSON.get("coverLetter");
                boolean accepted = (boolean)applicationJSON.get("accepted");
                SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
                Date dob = ft.parse((String)applicationJSON.get("application_date"));

                applications.add(new Application(id, studentID, companyID, coverLetter, accepted, dob));
            }

            return applications;

        } catch(Exception e) {
            e.printStackTrace();
        }
            return null;
    }

    public static ArrayList<Resume> getResumes() {
        ArrayList<Resume> resumes = new ArrayList<Resume>();
        try {
            FileReader reader = new FileReader("data/resumes.json");
            JSONArray resumesJSON = (JSONArray) new JSONParser().parse(reader);
            for(int i = 0; i < resumesJSON.size(); i++) {
                JSONObject resumeJSON = (JSONObject)resumesJSON.get(i);
                UUID id = UUID.fromString((String)resumeJSON.get("ID"));
                UUID studentID = UUID.fromString((String)resumeJSON.get("studentID"));
                JSONArray experiences = (JSONArray)resumeJSON.get("experience");
                ArrayList<Experiences> experienceList = new ArrayList<Experiences>();
                if(experiences != null) {
                    for(int j = 0; j < experiences.size(); j++) {
                        JSONArray experience = (JSONArray)experiences.get(j);
                        String companyName = (String)experience.get(0);
                        String jobTitle = (String)experience.get(1);
                        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
                        Date pastEduBeginDate = ft.parse((String)experience.get(2));
                        Date pastEduEndDate = ft.parse((String)experience.get(3));
                        ArrayList<String> duties = new ArrayList<String>();
                        JSONArray dutiesJSON = (JSONArray)experience.get(4);
                        for(int k = 0; k < dutiesJSON.size(); k++) {
                            duties.add((String)dutiesJSON.get(k));
                        }
                        experienceList.add(new Experiences(companyName, jobTitle, pastEduBeginDate, pastEduEndDate, duties));
                    }
                }
                JSONArray skillsJSON = (JSONArray)resumeJSON.get("skills");
                ArrayList<String> skills = new ArrayList<String>();
                for(int j = 0; j < skillsJSON.size(); j++) {
                    skills.add((String)skillsJSON.get(j));
                }
                JSONArray referencesJSON = (JSONArray)resumeJSON.get("references");
                ArrayList<References> references = new ArrayList<References>();
                for(int j = 0; j < referencesJSON.size(); j++) {
                    JSONArray referenceJSON = (JSONArray)referencesJSON.get(j);
                    String referenceName = (String)referenceJSON.get(0);
                    String relationship = (String)referenceJSON.get(1);
                    String phoneNum = (String)referenceJSON.get(2);
                    String email = (String)referenceJSON.get(3);
                    references.add(new References(referenceName, relationship, phoneNum, email));
                }
                resumes.add(new Resume(id, studentID, skills, experienceList, references));
            }

            return resumes;

        } catch(Exception e) {
            e.printStackTrace();
        }
            return null;
    }

    public static void main(String[] args) {
        System.out.println(getStudents());
    }
}
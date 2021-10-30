package src;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Resume {
    private UUID id;
    private UUID studentId;
    public ArrayList<String> skills;
    public ArrayList<Experiences> experiences;
    public ArrayList<References> references;

    public Resume(UUID id, UUID studentID, ArrayList<String> skills, ArrayList<Experiences> experiences,
                     ArrayList<References> references) {
                         this.id = id;
                         this.studentId = studentID;
                         this.skills = skills;
                         this.experiences = experiences;
                         this.references = references;
    }
    /**
     * Returns the UUID of the resume
     * @return UUID of resume
     */
    public UUID getId() {
        return id;
    }
    /**
     * Gets the Student ID the resume belongs to
     * @return UUID of student ID tied to resume
     */
    public UUID getStudentId() {
        return studentId;
    }
    public ArrayList<String> getSkills(){
        return skills;
    }
    public void addSkills(){

    }
    public ArrayList<Experiences> getExperiences(){
        return experiences;
    }
    public void addExperience(String companyName, String jobTitle, Date jobStartDate, 
                                    Date jobEndDate, ArrayList<String> jobDuties ){
        experiences.add(new Experiences(companyName, jobTitle, jobStartDate, jobEndDate, jobDuties));
    }
    public ArrayList<References> getRefrences(){
        return references;
    }
    public void addReference(){
        
    }
    public void deleteReference(){
        
    }
    public String getJsonExperience() {
        return "";
    }
    public String getJsonReference() {
        return "";
    }
}

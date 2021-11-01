package src;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
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
    /**
     * gets the skills from a students resume
     * @return the array list of skills from the resume
     */
    public ArrayList<String> getSkills(){
        return skills;
    }
    /**
     * adds a skill to the resume
     * @param skill the skill to be added to the resume
     */
    public void addSkills(String skill){
        skills.add(skill);
    }
    /**
     * returns the expereiences from the resume
     * @return array list of experiences from the resume
     */
    public ArrayList<Experiences> getExperiences(){
        return experiences;
    }
    /**
     * Adds an experience to the resume
     * @param companyName the name of the compant previously worked at
     * @param jobTitle the title of the previous job
     * @param jobStartDate when the job started
     * @param jobEndDate when the job ended
     * @param jobDuties the duties of the job
     */
    public void addExperience(String companyName, String jobTitle, Date jobStartDate, 
                                    Date jobEndDate, ArrayList<String> jobDuties ){
        experiences.add(new Experiences(companyName, jobTitle, jobStartDate, jobEndDate, jobDuties));
    }
    /**
     * returns the references
     * @return the references from the resume
     */
    public ArrayList<References> getRefrences(){
        return references;
    }
    /**
     * adds reference to the array
     * @param reference the reference to be added to the resume
     */
    public void addReference(References reference){
        references.add(reference);
    }
    /**
     * removes a reference from the resume
     * @param reference the reference to be removed
     */
    public void deleteReference(References reference){
        references.remove(reference);
    }
    public ArrayList<Object> getJsonExperience() {
        ArrayList<Object> jsonString = new ArrayList<Object>();
        for (Experiences experience : experiences) {
            ArrayList<Object> experienceArr = new ArrayList<Object>();
            experienceArr.add(experience.companyName);
            experienceArr.add(experience.pastJobTitle);
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
            experienceArr.add(ft.format(experience.jobStartDate));
            experienceArr.add(ft.format(experience.jobEndDate));
            experienceArr.add(experience.jobDuties);
            jsonString.add(experienceArr);
        }
        return jsonString;
    }
    public ArrayList<Object> getJsonReference() {
        ArrayList<Object> jsonString = new ArrayList<Object>();
        for (References reference : references) {
            ArrayList<String> referenceArr = new ArrayList<String>();
            referenceArr.add(reference.name);
            referenceArr.add(reference.relationship);
            referenceArr.add(reference.phoneNum);
            referenceArr.add(reference.email);
            jsonString.add(referenceArr);
        }
        return jsonString;
    }
    /**
     * returns a resume as a string
     */
    public String toString(){
        return "Resume: " +
        "\nID " + id + "\nSkills: " + skills +
        "\nExperiences " + experiences + "\nReferences: " + references;
    }
}

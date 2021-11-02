package src;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Resumes Class for creating a list of resume objects to interact with
 * @author Joseph Alam
 */
public class Resumes {
    
    private static Resumes instance = null;
    private ArrayList<Resume> resumes;

    /**
     * Initializes Resumes class by loading resumes from DataLoader
     */
    private Resumes() {
        resumes = DataLoader.getResumes();
    }

    /**
     * Creates an instance of the Resumes class if one does not already exist
     * @return instance of the Resumes class
     */
    public static Resumes getInstance() {
        if(instance == null) {
            instance = new Resumes();
        }
        return instance;
    }
    /**
     * Gets all resumes
     * @return ArrayList<Resume> ArrayList containing all the resume objects
     */
    public ArrayList<Resume> getResumes() {
        return this.resumes;
    }
    /**
     * Get a Resume by its ID
     * @param id UUID of the resume
     * @return Resume object corresponding to the UUID
     */
    public Resume getResumeById(UUID id) {
        for(Resume resume : resumes) {
            if(resume.getId().equals(id)) {
                return resume;
            }
        }
        return null;
    }

    /**
     * Adds a resume to the list of resumes
     * @param newResume Resume to be added
     * @return boolean of whether or not the resume was added
     */
    public boolean addResume(Resume newResume) {
        for(int i = 0; i < resumes.size(); i++) {
            if(resumes.get(i).getStudentId() == newResume.getStudentId()) {
                resumes.remove(i);
                break;
            }
        }
        Students students = Students.getInstance();
        Student student = students.getStudent(newResume.getStudentId());
        student.setResumeId(newResume.getId());
        resumes.add(newResume);
        DataWriter.saveResumes();
        DataWriter.saveStudents();
        return true;
    }
}
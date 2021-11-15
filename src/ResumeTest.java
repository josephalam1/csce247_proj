package src;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class ResumeTest {

    UUID resumeID = UUID.randomUUID();
    UUID studentID = UUID.randomUUID();
    private ArrayList<String> skills = new ArrayList<String>();
    private ArrayList<Experiences> experiences = new ArrayList<Experiences>();
    private ArrayList<References> references = new ArrayList<References>();
    Date tD = new Date();
    
    Resume r1 = new Resume(UUID.randomUUID(), UUID.randomUUID(), skills, experiences, references);

    /*
    @BeforeEach
    public void setup() {
        Resume r1 = new Resume(UUID.randomUUID(), UUID.randomUUID(), skills, experiences, references);
        }*/
    
    @Test
    void testAddSkills() {
        r1.addSkills("skills");
        boolean hasSkill = r1.skills.contains("skills");
        assertTrue(hasSkill);
    }
    @Test
    void testAddExpereience(){
        r1.addExperience("companyName", "jobTitle", tD, tD, skills);
        boolean hasExp = r1.experiences.get(0).companyName.equals("companyName");
        assertTrue(hasExp);
    }
    @Test
    void testAddReference(){
        References ref = new References("name", "relationship", "phoneNum", "email");
        r1.addReference(ref);
        boolean hasRef = r1.references.contains(ref);
        assertTrue(hasRef);
    }
    @Test
    void testDelReference() {
        References ref = new References("name", "relationship", "phoneNum", "email");
        r1.addReference(ref);
        r1.deleteReference(ref);
        boolean hasRef = r1.references.contains(ref);
        assertFalse(hasRef);
    }
}

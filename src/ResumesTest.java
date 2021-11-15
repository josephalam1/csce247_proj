package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class ResumesTest {
    UUID testId = UUID.randomUUID();
    private Resumes resumes = Resumes.getInstance();
    private ArrayList<Resume> resumeList = resumes.getResumes();

    @BeforeEach
    public void setup(){
        resumeList.clear();
        resumeList.add(new Resume(testId, testId, null, null, null));
    }

    @AfterEach
    public void tearDown(){
        resumes.getInstance().getResumes().clear();

    }
    @Test
    void testGetResumeById(){
        Resume res = resumes.getResumeById(testId);
        assertEquals(res, resumeList.get(0));
    }
}

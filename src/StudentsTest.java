package src;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

class StudentsTest {
    UUID testId = UUID.randomUUID();
    private Students students = Students.getInstance();
    private ArrayList<Student> studentList = students.getStudents();

    @BeforeEach
    public void setup() {
        studentList.clear();
        studentList.add(new Student(testId, "Joseph Alam", "joeyalam@email.com", "123-456-7890", "password",
            new Date(), "M", "M", true, 4.0, "Columbia", "Sophmore",
            "Computer Science", 2024, 0.0, "jalam" ));
            studentList.add(new Student("Bob Marley", "bobmarley@email.com", "0987-654-321", "password",
            new Date(), "M", "M", true, null, 4.0, "Upstate", "Senior",
            "Computer Science", 2022, 0.0, "bmarley" ));
        DataWriter.saveStudents();
    }

    @AfterEach 
    public void tearDown() {
        students.getInstance().getStudents().clear();
        DataWriter.saveStudents();
    }
    @Test 
    void testHaveStudentValidFirstItem() {
        boolean hasJoseph = students.haveUser("jalam");
        assertTrue(hasJoseph);
    }

    @Test 
    void testHaveStudentValidLastItem() {
        boolean hasBob = students.haveUser("bmarley");
        assertTrue(hasBob);
    }
    @Test 
    void testHaveStudentInvalid() {
        boolean hasJames = students.haveUser("jsmith");
        assertFalse(hasJames);
    }
    @Test 
    void testHaveStudentEmpty() {
        boolean hasEmpty = students.haveUser("");
        assertFalse(hasEmpty);
    }
    @Test 
    void testHaveStudentNull() {
        boolean hasNull = students.haveUser(null);
        assertFalse(hasNull);
    }
    @Test 
    void testAddUserNotExist() {
        assertTrue(
            students.addStudent("James Smith", "jamessmith@email.com", "319-381-8298", "password",
            new Date(), "M", "M", true, 4.0, "Columbia", "Grad-Student",
            "Computer Science", 2022, "jsmith")
        );
    }
    @Test 
    void testAddUserAlreadyExist() {
        assertFalse(
            students.addStudent("Joseph Alam", "joeyalam@email.com", "123-456-7890", "password",
            new Date(), "M", "M", true, 4.0, "Columbia", "Sophmore",
            "Computer Science", 2024, "jalam")
        );
    }
    @Test 
    void testAddUserEmpty() {
        assertFalse(
            students.addStudent("", "", "", "", new Date(), "", "", true, 4.0, 
            "", "", "", 2023, "")
        );
    }
    @Test 
    void testAddUserNull() {
        assertFalse(
            students.addStudent(null, null, null, null, new Date(), null, null, true, 4.0, 
            null, null, null, 2023, null)
        );
    }
    @Test
    void testGetStudentExists() {
        Student student = students.getStudent("jalam", "password");
        assertEquals(student, studentList.get(0));
    }
    @Test
    void testGetStudentNotExists() {
        Student student = students.getStudent("jalam", "wrongpassword");
        assertEquals(student, null);
    }
    @Test
    void testGetStudentExistsById() {
        Student student = students.getStudent(testId);
        assertEquals(student, studentList.get(0));
    }
    @Test
    void testGetStudentNotExistsById() {
        Student student = students.getStudent(UUID.randomUUID());
        assertEquals(student, null);
    }
}
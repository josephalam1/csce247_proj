package src;

import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.ArrayList;

public class DataWriter {
    public static void saveStudents() {
        Students studentInst = Students.getInstance();
        ArrayList<Student> students = studentInst.getStudents();
        JSONArray studentsJ = new JSONArray();
        for (int i = 0; i < students.size(); i++) {
            //studentsJ.add(students.get(i));
        }
    }
    public static void saveCompanies() {

    }
    public static void saveResumes() {

    }
    public static void saveJobs() {

    }

    public static JSONObject getStudentsJSON(Student student) {
        JSONObject studentDetails = new JSONObject();
        return studentDetails;
    }
}
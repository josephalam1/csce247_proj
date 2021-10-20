package src;

import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DataLoader {

    public static ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            FileReader reader = new FileReader("data/students.json");
            JSONArray studentsJSON = (JSONArray) new JSONParser().parse(reader);
            
            for(int i = 0; i < studentsJSON.size(); i++) {
                JSONObject studentJSON = (JSONObject)studentsJSON.get(i);
                String firstName = (String)studentJSON.get("firstName");
                String lastName = (String)studentJSON.get("lastName");
                SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
                Date dob = ft.parse((String)studentJSON.get("dob"));
                String sex = (String)studentJSON.get("sex");
                String gender = (String)studentJSON.get("gender");
                students.add(new Student(firstName+" "+lastName, dob, sex, gender));
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
            FileReader reader = new FileReader("data/employers.json");
            JSONArray studentsJSON = (JSONArray) new JSONParser().parse(reader);
            
            for(int i = 0; i < studentsJSON.size(); i++) {
                JSONObject studentJSON = (JSONObject)studentsJSON.get(i);
                int id = (int)studentJSON.get("id");
                String firstName = (String)studentJSON.get("recruiterFirstName");
                String lastName = (String)studentJSON.get("recruiterLastName");
                //SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
                //Date dob = ft.parse((String)studentJSON.get("recruiterDob"));
                String companyName = (String)studentJSON.get("companyName");
                String email = (String)studentJSON.get("recruiterEmail");
                String address = (String)studentJSON.get("companyAddress");
                String phone = (String)studentJSON.get("recruiterPhone");

                companies.add(new Company(id, companyName, email, address, firstName+" "+lastName, phone));
            }

            return companies;

        } catch(Exception e) {
            e.printStackTrace();
        }
            return null;
    }
}
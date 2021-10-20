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
                int id = (int)studentJSON.get("id");
                String firstName = (String)studentJSON.get("firstName");
                String lastName = (String)studentJSON.get("lastName");
                String email = (String)studentJSON.get("email");
                String password = (String)studentJSON.get("password");
                SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
                Date dob = ft.parse((String)studentJSON.get("dob"));
                String sex = (String)studentJSON.get("sex");
                String gender = (String)studentJSON.get("gender");
                boolean available = (boolean)studentJSON.get("available");
                double gpa = (double)studentJSON.get("GPA");
                int year = (int)studentJSON.get("year");
                String location = (String)studentJSON.get("campusLocation");
                String major = (String)studentJSON.get("major");
                double rating = (double)studentJSON.get("rating");
                students.add(new Student(id, firstName+" "+lastName, email, password, dob, sex, gender, 
                    null, available, null, gpa, location, null, major, year, rating));
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
            JSONArray companysJSON = (JSONArray) new JSONParser().parse(reader);
            
            for(int i = 0; i < companysJSON.size(); i++) {
                JSONObject companyJSON = (JSONObject)companysJSON.get(i);
                int id = (int)companyJSON.get("id");
                String firstName = (String)companyJSON.get("recruiterFirstName");
                String lastName = (String)companyJSON.get("recruiterLastName");
                String password = (String)companyJSON.get("password");
                SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
                Date dob = ft.parse((String)companyJSON.get("dateEstablished"));
                String companyName = (String)companyJSON.get("companyName");
                String email = (String)companyJSON.get("recruiterEmail");
                String address = (String)companyJSON.get("companyAddress");
                String phone = (String)companyJSON.get("recruiterPhone");
                String website = (String)companyJSON.get("recruiterWebsite");
                double rating = (double)companyJSON.get("rating");

                companies.add(new Company(id, companyName, email, password, address, firstName+" "+lastName, phone, dob, 
                    website, rating));
            }

            return companies;

        } catch(Exception e) {
            e.printStackTrace();
        }
            return null;
    }
}
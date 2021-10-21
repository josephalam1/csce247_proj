package src;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class Welcome {

    private ArrayList<Student> studentUsers;
    private ArrayList<Company> companyUsers;
    private Student s = new Student(0, null, null, null, null, null, null, null, null, null, 0, null, null, null, 0, 0);
    private Company c = new Company(0, null, null, null, null, null, null, null, null, 0);
    public Scanner input = new Scanner(System.in);  // Create a Scanner object
    private static Welcome screen;
	  
	public Welcome() {
        this.studentUsers = new ArrayList<>();
        this.companyUsers = new ArrayList<>();
    }

    public ArrayList<Student> studentAccess() {
        return studentUsers;
    }

    public Student getStudentFromID () {

    }

    public static Welcome getInstance() {
		if (screen == null) {
            System.out.println("**************************************");
			System.out.println("* Welcome to UofSC Intership System! *");
            System.out.println("**************************************");
            System.out.println("1. Login with Existing Account");
            System.out.println("2. Make an Account: Student");
            System.out.println("3. Make an Account: Company");
			screen = new Welcome();
		}
		return screen;
	}


    public void loginStudent() {
        System.out.println("**************************************");
        System.out.println("*          Welcome Student!          *");
        System.out.println("**************************************");
        System.out.println("\n");
        System.out.println("1. View account information");
        System.out.println("2. Search for Job Listing");
        System.out.println("3. View Notifications");
        System.out.println("3. ");
        
    }

    public void loginCompany() {
        
    }

    public void addStudent() {
        System.out.println("**************************************");
        System.out.println("*       Welcome new Student!         *");
        System.out.println("**************************************");
        System.out.println("\n");
        System.out.println("Enter 0 at any time for the help Menu: ");
        System.out.println("");
        System.out.println("Please enter your name: ");
        String sName = input.nextLine();  // Read user input
        s.name = sName;
        System.out.println("");
        System.out.println("Please enter your perferred name: ");
        String sNewName = input.nextLine();  // Read user input
        s.setPreferredName(sNewName);
        System.out.println("");
        System.out.println("Please enter your email: ");
        String sEmail = input.nextLine();  // Read user input
        s.email = sEmail;
        System.out.println("");
        System.out.println("Please enter your password: ");
        System.out.println("> will set later");
        System.out.println("");
        System.out.println("Please enter your DOB yyyy/MM/dd ");
        String sDOB = input.nextLine();  // Read user input
        DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date;
        try {
            date = formatter.parse(sDOB);
            s.setDateOfBirth(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //s.setDateOfBirth(date);
        System.out.println("");
        System.out.println("Please enter your sex: M/F ");
        String sSex = input.nextLine();  // Read user input
        s.setSex(sSex);
        System.out.println("");
        System.out.println("Please enter your prefered gender: M/F/O");
        String sGender = input.nextLine();  // Read user input
        s.setGender(sGender);
        System.out.println("");
        System.out.println("Please enter your GPA: ");
        double sGPA = input.nextDouble();  // Read user input
        s.setGPA(sGPA);
        input.nextLine(); // stops input skips
        System.out.println("");
        System.out.println("Please enter your current level Freshman/sophomore/junior/senior: ");
        String sLevel = input.nextLine();  // Read user input
        s.currLevel = sLevel;
        System.out.println("");
        System.out.println("Please enter your current year 1/2/3/4/5/6: ");
        int sYear = input.nextInt();  // Read user input
        s.currYear = sYear;
        input.nextLine(); // this stops the skips
        System.out.println("");
        System.out.println("Please enter your current major: ");
        String sMajor = input.nextLine();  // Read user input
        s.currMajor = sMajor;
        
         studentUsers.add(s);

        System.out.println(s.toString());
    }

    public void addCompany() {

        System.out.println("**************************************");
        System.out.println("*       Welcome new Company!         *");
        System.out.println("**************************************");
        System.out.println("\n");
        System.out.println("Enter 0 at any time for the help Menu: ");
        System.out.println("");
        System.out.println("Please enter your name: ");
        String cName = input.nextLine();  // Read user input
        c.name = cName;
        System.out.println("");
        System.out.println("Please enter your email: ");
        String cEmail = input.nextLine();  // Read user input
        c.recruiterEmail = cEmail;
        System.out.println("");
        System.out.println("Please enter your password: ");
        System.out.println("> will set later");
        System.out.println("");
        System.out.println("Please enter your hiring recruiters name: ");
        String cRecruit = input.nextLine();  // Read user input
        c.hiringRecruiter = cRecruit;
        System.out.println("");
        System.out.println("Please enter their phone number: ");
        String cContact = input.nextLine();  // Read user input
        c.contactInfo = cContact;
        System.out.println("");
        System.out.println("Please enter the company's address: ");
        String cAddress = input.nextLine();  // Read user input
        c.address = cAddress;
        System.out.println("");
        System.out.println("Please enter the company's date established: ");
        String cDateEst = input.nextLine();  // Read user input
        DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date;
        try {
            date = formatter.parse(cDateEst);
            s.setDateOfBirth(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("");
        System.out.println("Please enter the company's website: ");
        String cWebsite = input.nextLine();  // Read user input
        c.webSite = cWebsite;
        
         companyUsers.add(c);

        System.out.println(c.toString());
        
    }

    
}

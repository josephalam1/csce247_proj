package src;

// test

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.security.*;
import java.io.Console;
import java.io.UnsupportedEncodingException;
import java.util.Date;

public class Welcome {

    private ArrayList<Student> studentUsers;
    private ArrayList<Company> companyUsers;
    private Companies company = Companies.getInstance();
    private Students student = Students.getInstance();
    private Company c = new Company(null, null, null, null, null, null, null, null, null, 0.0);
                        // Student(name, email, password, dateOfBirth, sex, gender, openApplications, available, savedJobs, gPA, campusLocation, currLevel, currMajor, currYear, rating, username)
    private Student s = new Student(null, null, null, null, null, null, null, true, null, 0.0, null, null, null, 0, 0.0, null);
    public Scanner input = new Scanner(System.in);  // Create a Scanner object
    private static Welcome screen;
    public static Boolean logout;

    public Welcome() {
        studentUsers = student.getStudents();
        companyUsers = company.getCompanies();
        logout = false;
    }
	  
    public ArrayList<Student> studentAccess() {
        return studentUsers;
    }

    public ArrayList<Company> CompanyAccess() {
        return companyUsers;
    }

    public static Welcome getInstance() {
        logout = false;
		if (screen == null) {
            System.out.println("**************************************");
            System.out.println("* Welcome to UofSC Intership System! *");
            System.out.println("**************************************");
            System.out.println("1. Login with Existing Account");
            System.out.println("2. Make an Account: Student");
            System.out.println("3. Make an Account: Company");
            System.out.println("   Type X to exit program");
            screen = new Welcome();
        }
		return screen;
	}

    public void mainScreen() {
        System.out.println("**************************************");
        System.out.println("* Welcome to UofSC Intership System! *");
        System.out.println("**************************************");
        System.out.println("1. Login with Existing Account");
        System.out.println("2. Make an Account: Student");
        System.out.println("3. Make an Account: Company");
        System.out.println("   Type X to exit program");
    }

    public void whichUser() {
        System.out.println("1. Login Student");
        System.out.println("2. Login Company");
        String opt;
        opt = input.nextLine();
        if (opt.equals("1")) {
            System.out.println("Enter user name: ");
            String sUserName = input.nextLine();  
            s.username= sUserName;
            System.out.println("Enter user password: ");
            String sPassword = input.nextLine();
            s.password = sPassword;
            Student logon = student.getStudent(sUserName, sPassword);
            screen.loginStudent(logon);
            // screen.loginStudent();
        } else {
            System.out.println("Enter user name: ");
            String cUserName = input.nextLine();  
            c.username= cUserName;
            System.out.println("Enter user password: ");
            String cPassword = input.nextLine();
            c.password = cPassword;
            Company logon = company.getCompany(cUserName, cPassword);
            screen.loginCompany(logon);
            // screen.loginCompany();
        }
    }

    public void addStudent() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        
            System.out.println("\n");
            System.out.println("**************************************");
            System.out.println("*       Welcome new Student!         *");
            System.out.println("**************************************");
            System.out.println("\n");
            // System.out.println("Enter L at any time to logout ");
            // System.out.println("");
            String sName = null;
            while(sName == null){
                System.out.println("Please enter your name: ");
                sName = input.nextLine(); 
                s.name = sName;
            }
            System.out.println("");
            System.out.println("Please enter your perferred name: ");
            String sNewName = input.nextLine();  
            s.setPreferredName(sNewName);
            System.out.println("");
            System.out.println("Please enter your email: ");
            String sEmail = input.nextLine();  
            s.email = sEmail;
            System.out.println("");
            System.out.println("Please enter your user name: ");
            String sUserName = input.nextLine();  
            s.username= sUserName;
            System.out.println("");
            System.out.println("Please enter your password: ");
            String sPassword = input.nextLine();
            s.password = sPassword;
            
                /*try {
                    java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
                    byte[] array = md.digest(MD5.getBytes());
                    StringBuffer sb = new StringBuffer();
                    for (int i = 0; i < array.length; ++i) {
                    sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
                    }
                } catch (java.security.NoSuchAlgorithmException e) {
                }*/

            byte[] bytesOfMessage = s.password.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] theMD5digest = md.digest(bytesOfMessage);
            System.out.println("");
            String sDOB = null;
            while(true){
                System.out.println("Please enter your DOB \"yyyy/MM/dd\" ");
                sDOB = input.nextLine();  
                Pattern pattern = Pattern.compile("\\d{4}/\\d{2}/\\d{2}");
                Matcher matcher = pattern.matcher(sDOB);
                if(matcher.matches()){
                    break;
                }
            
                DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
                Date date;
                try {
                    date = formatter.parse(sDOB);
                    s.setDateOfBirth(date);
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
            
            System.out.println("");
            System.out.println("Please enter your sex: M/F ");
            String sSex = input.nextLine();  
            s.setSex(sSex);
            System.out.println("");
            System.out.println("Please enter your prefered gender: M/F/O");
            String sGender = input.nextLine(); 
            s.setGender(sGender);
            System.out.println("");
            double sGPA = 0.0;
            while(true){
                System.out.println("Please enter your GPA: ");
                sGPA = input.nextDouble();  
                s.setGPA(sGPA);
                input.nextLine();
                if(sGPA != 0.0){
                    break;
                } 
                System.out.println("");
            }
            
            System.out.println("Please enter your current level Freshman/sophomore/junior/senior: ");
            String sLevel = input.nextLine();  
            s.currLevel = sLevel;
            System.out.println("");
            System.out.println("Please enter your current year 1/2/3/4/5/6: ");
            int sYear = input.nextInt();  
            s.currYear = sYear;
            input.nextLine(); 
            System.out.println("");
            System.out.println("Please enter your current major: ");
            String sMajor = input.nextLine();  
            s.currMajor = sMajor;
            System.out.println("");
            studentUsers.add(s);
            System.out.println(s.toString());
            System.out.println("");
        
    }

    public void loginStudent(Student s) {
    // public void loginStudent() {
        System.out.println("\n");
        System.out.println("**************************************");
        System.out.println("*          Welcome Student!          *");
        System.out.println("**************************************");
        System.out.println("\n");
        // System.out.println("Enter L at any time to logout");
        // System.out.println("");
        System.out.println("1. View account information");
        System.out.println("2. Search for Job Listing");
        System.out.println("3. View saved Job Listings");
        System.out.println("4. View Companies Worked for");
        System.out.println("5. View Notifications");

        String optStudent = input.nextLine();
        switch (optStudent) {
            case "1":
                s = student.getStudent(s.username, s.password);
                s.toString();
                break;
            case "2":
                jobListingScreen();
                break;
            case "3":
                ArrayList<JobListing> savedJ = s.savedJobs;
                System.out.println(savedJ.toString());
                break;
            case "4":
                System.out.println("");
                break;
            case "5":
                System.out.println("No notifications yet");
                break;
            default:
                break;
        }
    }

    public void jobListingScreen() {
        System.out.println("\n");
        System.out.println("**************************************");
        System.out.println("*          Search for Jobs!          *");
        System.out.println("**************************************");
        System.out.println("\n");
        // System.out.println("Enter L at any time to logout");
        // System.out.println("");
        System.out.println("1. View all Jobs listed");
        System.out.println("2. Sort by Title A-Z");
        System.out.println("3. Filter options: ");
        System.out.println("\t1. location \n\t2. Min Hours \n\t3. Max Hours \n\t4. Pay rate \n\t5. Remote \n\t6. Skills required \n\t7. Company rating");
    }


    public void addCompany() {
        System.out.println("\n");
        System.out.println("**************************************");
        System.out.println("*       Welcome new Company!         *");
        System.out.println("**************************************");
        System.out.println("\n");
        // System.out.println("Enter L at any time to logout ");
        // System.out.println("");
        System.out.println("Please enter your name: ");
        String cName = input.nextLine();  
        c.name = cName;
        System.out.println("");
        System.out.println("Please enter your email: ");
        String cEmail = input.nextLine();  
        c.recruiterEmail = cEmail;
        System.out.println("");
        System.out.println("Please enter your password: ");
        System.out.println("> will set later");
        System.out.println("");
        System.out.println("Please enter your hiring recruiters name: ");
        String cRecruit = input.nextLine();  
        c.hiringRecruiter = cRecruit;
        System.out.println("");
        System.out.println("Please enter their phone number: ");
        String cContact = input.nextLine();  
        c.contactInfo = cContact;
        System.out.println("");
        System.out.println("Please enter the company's address: ");
        String cAddress = input.nextLine();  
        c.address = cAddress;
        System.out.println("");
        // System.out.println("Please enter the company's date established: ");
        // String cDateEst = input.nextLine();  
        // DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        // Date date;
        // try {
        //     date = formatter.parse(cDateEst);
        //     s.setDateOfBirth(date);
        //    //c.dateEstablished
        // } catch (ParseException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
       // }
       String cDateEst = null;
            while(true){
                System.out.println("Please enter the date your company was established: ");
                cDateEst = input.nextLine();  
                Pattern pattern = Pattern.compile("\\d{4}/\\d{2}/\\d{2}");
                Matcher matcher = pattern.matcher(cDateEst);
                if(matcher.matches()){
                    break;
                }
            
                DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
                Date date;
                try {
                    date = formatter.parse(cDateEst);
                    s.setDateOfBirth(date);
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        System.out.println("");
        System.out.println("Please enter the company's website: ");
        String cWebsite = input.nextLine();  // Read user input
        c.webSite = cWebsite;
        
        // companyUsers.add(c);

        System.out.println(c.toString());
        
    }

    public void loginCompany(Company c) {
    // public void loginCompany() {

        JobListing job = new JobListing(null, null, null, null, 0, 0, 0.0, null, 0, null, null, null, false, true);
        
        System.out.println("\n");
        System.out.println("**************************************");
        System.out.println("*          Welcome Company!          *");
        System.out.println("**************************************");
        System.out.println("\n");
        // System.out.println("Enter L at any time to logout");
        // System.out.println("");
        System.out.println("1. View account information");
        System.out.println("2. Create a Job Listing");
        System.out.println("3. View Job Listings");
        System.out.println("4. View applicants");
        System.out.println("5. View Notifications");

        String optCo = input.nextLine();
        switch (optCo) {
            case "1":
                company.getCompany(c.username, c.password);
                break;
            case "2":
                // JobListing job = new JobListing(id, companyID, title, location, minHours, maxHours, pay, expDate, numOpenings, skillsReq, description, applicants, minExp, remote, open);
                jobListingScreen(job);
                break;
            case "3":
                // ArrayList<JobListing> cJobs = Companies.;
                System.out.println("Under construction");
                System.out.println(job.toString());
                break;
            case "4":
                System.out.println("View applicants for which Job Listing? ");
                String cJob = input.nextLine();  
                job.title = cJob;
                c.viewApplications(job);
                break;
            case "5":
                System.out.println("2. Search for Job Listing");
                break;
            default:
                break;
        }
    }

    public void jobListingScreen(JobListing j) {
        System.out.println("\n");
        System.out.println("**************************************");
        System.out.println("*         Create Job Listing         *");
        System.out.println("**************************************");
        System.out.println("\n");
        // System.out.println("Enter L at any time to logout");
        // System.out.println("");
        System.out.println("Please enter the title: ");
        String jTitle = input.nextLine();  
        j.title = jTitle;
        System.out.println("");
        System.out.println("Please enter the location: ");
        String jLoc = input.nextLine();  
        j.location = jLoc;
        System.out.println("");
        int jMinHrs = 0;
        while(true){
            System.out.println("Please enter the minimum number of hours: ");
            jMinHrs = input.nextInt();  
            if(jMinHrs != 0){
                j.setMinHours(jMinHrs);
                input.nextLine();
                System.out.println("");
                break;
            }
        }
        System.out.println();
        int jMaxHrs = 0;
        while(true){
            System.out.println("Please enter the maximum number of hours: ");
            jMaxHrs = input.nextInt();
            if(jMaxHrs != 0){
                j.setMaxHours(jMaxHrs);
                input.nextLine();
                System.out.println("");
                break;
            }
        }
          
        System.out.println("");
        System.out.println("Please enter the pay rate in USD: ");
        double jPay = input.nextDouble();  
        j.setPay(jPay);
        input.nextLine();
        System.out.println("");
        System.out.println("Please enter the number of openings: ");
        int jOpen = input.nextInt();  
        j.setNumOpenings(jOpen);
        input.nextLine();
        System.out.println("");
        System.out.println("Please enter the job closing date: ");
        String cDateCl = input.nextLine();  
        DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date;
        try {
            date = formatter.parse(cDateCl);
            j.setExpDate(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("");
        // System.out.println("Please enter the skills required: ");
        // String cWebsite = input.nextLine();  // Read user input
        // c.webSite = cWebsite;
        System.out.println("Please enter the description: ");
        String jDesc = input.nextLine();  
        j.setDescription(jDesc);
        System.out.println("");
        System.out.println("Is this job Remote true/false: ");
        Boolean jRemote = input.nextBoolean();  
        j.setRemote(jRemote);
        System.out.println("");
    }

    
}


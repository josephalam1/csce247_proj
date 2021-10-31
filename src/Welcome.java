package src;

// test

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.Console;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Base64;

public class Welcome {
    private Companies company = Companies.getInstance();
    private Students student = Students.getInstance();
    public Scanner input = new Scanner(System.in);  // Create a Scanner object
    private static Welcome screen;
    public static Boolean logout;

    private Welcome() {
        logout = false;
    }
    public static Welcome getInstance() {
		if (screen == null) {
            screen = new Welcome();
            logout = false;
            System.out.println("**************************************");
            System.out.println("* Welcome to UofSC Intership System! *");
            System.out.println("**************************************");
            System.out.println("1. Login with Existing Account");
            System.out.println("2. Make an Account: Student");
            System.out.println("3. Make an Account: Company");
            System.out.println("   Type X to exit program");
        }
		return screen;
	}
    /**
     * Secures the password by hashing it
     * @param password String of password to encrypt
     * @return String of encrypted password
     */
    public String getPassword(String password) {
        try { 
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Sorry, there was an error encrypting this password.");
            return null;
        }
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
        while(true){
            System.out.println("1. Login Student");
            System.out.println("2. Login Company");
            String opt;
            opt = input.nextLine();
            if (opt.equals("1")) {
                Student currStudent = loginHandlerStudent();
                if(currStudent == null) {
                    mainScreen();
                } else {
                    screen.loginStudent(currStudent);
                }
                break;
            } else if (opt.equals("2")) {
                Company currCompany = loginHandlerCompany();
                if(currCompany == null) {
                    mainScreen();
                } else {
                    screen.loginCompany(currCompany);
                }
                break;
            } else{
                System.out.println("Please enter the number 1 or 2");
            }
        }
    }
    public Student loginHandlerStudent() {
        while(true) {
            System.out.println("Please enter your username: (Enter X to go back to main screen)");
            String username = input.nextLine();  
            if(username.equalsIgnoreCase("X"))
                break;
            System.out.println("Please enter your password: ");
            String password = getPassword(input.nextLine());
            Student studentUser = student.getStudent(username, password);
            if(studentUser != null) {
                return studentUser;
            }
            System.out.println("Error!\nStudent not found with username and password combination.\n");
        }
        return null;
    }
    public Company loginHandlerCompany() {
        while(true) {
            System.out.println("Please enter your username: (Enter X to go back to main screen)");
            String username = input.nextLine();  
            if(username.equalsIgnoreCase("X"))
                break;
            System.out.println("Please enter your password: ");
            String password = getPassword(input.nextLine());  
            Company companyUser = company.getCompany(username, password);
            if(companyUser != null) {
                return companyUser;
            }
            System.out.println("Error!\nCompany not found with username and password combination.\n");
        }
        return null;
    }
    public void addStudent() {
            System.out.println("\n");
            System.out.println("**************************************");
            System.out.println("*       Welcome new Student!         *");
            System.out.println("**************************************");
            System.out.println("\nPlease enter your name: ");
            String name = input.nextLine();  
            System.out.println("\nPlease enter your email: ");
            String email = input.nextLine();  
            String username = new String();
            while(true) {
                System.out.println("\nPlease enter your username: ");
                username = input.nextLine();
                if(!student.haveUser(username)) {
                    break;
                }
                System.out.println("Sorry! That username is already taken.\n");
            }
            System.out.println("\nPlease enter your password: ");
            String password = getPassword(input.nextLine());
            String sDOB = null;
            while(true){
                System.out.println("\nPlease enter your date of birth in the format \"yyyy/MM/dd\": ");
                sDOB = input.nextLine();  
                Pattern pattern = Pattern.compile("\\d{4}/\\d{2}/\\d{2}");
                Matcher matcher = pattern.matcher(sDOB);
                if(matcher.matches()){
                    break;
                }
            }
            DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            try {
                Date date = formatter.parse(sDOB);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            while(true) {
            System.out.println("\nPlease enter your sex: (M/F) ");
            String sex = input.nextLine();  
            if (sex.equalsIgnoreCase("M") || sex.equalsIgnoreCase("F"))
                break;
            }
            while(true) {
            System.out.println("\nPlease enter your prefered gender: M/F/O");
            String gender = input.nextLine(); 
            if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F") || gender.equals("0"))
                break;
            }
            double sGPA = 0.0;
            while(true){
                System.out.println("\nPlease enter your GPA: ");
                sGPA = input.nextDouble();  
                input.nextLine();
                if(sGPA != 0.0){
                    break;
                } 
            }
            System.out.println("\nPlease enter your current level Freshman/sophomore/junior/senior: ");
            String level = input.nextLine();  
            while(true) {
            System.out.println("\nPlease enter your current year 1/2/3/4/5/6: ");
            int year = input.nextInt();  
            input.nextLine(); 
            if (year > 0 && year < 7)
                break;
            }
            System.out.println("");
            System.out.println("Please enter your current major: ");
            String sMajor = input.nextLine();  
            System.out.println("");
            //studentUsers.add(s);
            // System.out.println(s.toString());
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
        System.out.println("");
        System.out.println("Please enter your email: ");
        String cEmail = input.nextLine();  
        System.out.println("");
        System.out.println("Please enter your password: ");
        System.out.println("> will set later");
        System.out.println("");
        System.out.println("Please enter your hiring recruiters name: ");
        String cRecruit = input.nextLine();  
        System.out.println("");
        System.out.println("Please enter their phone number: ");
        String cContact = input.nextLine();  
        System.out.println("");
        System.out.println("Please enter the company's address: ");
        String cAddress = input.nextLine();  
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
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        System.out.println("");
        System.out.println("Please enter the company's website: ");
        String cWebsite = input.nextLine();  // Read user input
        // companyUsers.add(c);

        // System.out.println(c.toString());
        
    }

    public void loginCompany(Company c) {
    // public void loginCompany() {

        JobListing job = new JobListing(null, null, null, null, 0, 0, 0.0, null, 0, null, null, null, null, false, true);
        
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
                //job.title = cJob;
                // c.viewApplications(job);
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
        j.setTitle(jTitle);;
        System.out.println("");
        System.out.println("Please enter the location: ");
        String jLoc = input.nextLine();  
        j.setLocation(jLoc);
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
        j.remote = jRemote;
        System.out.println("");
    }

    
}


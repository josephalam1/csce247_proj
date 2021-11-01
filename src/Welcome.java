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
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.LocalDate;
import java.util.Base64;

/**
 * Handles interacting with the user
 */
public class Welcome {
    private Companies company = Companies.getInstance();
    private Students student = Students.getInstance();
    private Resumes resumes = Resumes.getInstance();
    private Applications applications = Applications.getInstance();
    public Scanner input = new Scanner(System.in);  // Create a Scanner object
    public Boolean logout;

    public Welcome() {
        logout = false;
        mainScreen();
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
    /**
     * First screen the user interacts with
     */
    public void mainScreen() {
        System.out.println("**************************************");
        System.out.println("* Welcome to UofSC Intership System! *");
        System.out.println("**************************************");
        System.out.println("1. Login with Existing Account");
        System.out.println("2. Make an Account: Student");
        System.out.println("3. Make an Account: Company");
        System.out.println("   Type X to exit program");
        while (logout == false) {
            String option = input.nextLine();
            if(option.equals("1")) {
                whichUser();
            } else if(option.equals("2")) {
                addStudent();
            } else if (option.equals("3")) {
                addCompany();
            } else if (option.equalsIgnoreCase("x")) {
                logout = true;
            } else {
                System.out.println("Invaild input.");
            }  
        }
        input.close();
        System.out.println("Goodbye");
        System.exit(0);
    }

    /**
     * Determines which types of log in the user is making and logs them in
     */
    public void whichUser() {
        while(true) {
            System.out.println("1. Login Student");
            System.out.println("2. Login Company");
            System.out.println("   Type X to return to the main screen");
            String opt = input.nextLine();
            if (opt.equals("1")) {
                Student currStudent = loginHandlerStudent();
                // Logs in if a student is returned by the login
                if(currStudent != null)
                    loginStudent(currStudent);
                break;
            } else if (opt.equals("2")) {
                Company currCompany = loginHandlerCompany();
                // Logs in if a company is returned by the login
                if(currCompany != null) 
                    loginCompany(currCompany);
                break;
            } else if (opt.equalsIgnoreCase("x")) {
                break;
            }
            System.out.println("Please enter the number 1 or 2 or X\n");
        }
        mainScreen();
    }
//=============================     Student Functions   ============================
    /**
     * Handles Logging in for the Student
     * @return Student object of Student returned from login
     */
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
    /**
     * Handles creating a new student user
     */
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
            // Checks to see if the username is taken already
            while(true) {
                System.out.println("\nPlease enter your username: ");
                username = input.nextLine();
                if(!student.haveUser(username))
                    break;
                System.out.println("Sorry! That username is already taken.");
            }
            System.out.println("\nPlease enter your password: ");
            String password = getPassword(input.nextLine());
            String sDOB = new String();
            Date date = new Date();
            // Checks to make sure the user enters the birth date in the correct format
            while(true){
                System.out.println("\nPlease enter your date of birth in the format \"yyyy/MM/dd\": ");
                sDOB = input.nextLine();  
                Pattern pattern = Pattern.compile("\\d{4}/\\d{2}/\\d{2}");
                Matcher matcher = pattern.matcher(sDOB);
                if(matcher.matches())
                    break;
            }
            // Parses the date if it is in the correct format
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            try { date = formatter.parse(sDOB); } 
            catch (ParseException e) { e.printStackTrace(); }
            String sex = new String();
            // Checks to make sure user enters sex correctly
            while(true) {
                System.out.println("\nPlease enter your sex: (M/F) ");
                sex = input.nextLine();  
                if (sex.equalsIgnoreCase("M") || sex.equalsIgnoreCase("F"))
                    break;
            }
            String gender = new String();
            // Checks to make sure user enters gender correctly
            while(true) {
                System.out.println("\nPlease enter your prefered gender: M/F/O");
                gender = input.nextLine(); 
                if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F") || gender.equals("0"))
                    break;
            }
            double gpa = 0.0;
            // Checks to make sure user enters double correctly
            while(true){
                System.out.println("\nPlease enter your GPA: ");
                gpa = input.nextDouble();  
                input.nextLine();
                if(gpa != 0.0)
                    break;
            }
            System.out.println("\nPlease enter your U of SC campus location: ");
            String location = input.nextLine();  
            System.out.println("\nPlease enter your current level Freshman/sophomore/junior/senior: ");
            String level = input.nextLine();  
            int year = 0;
            // Checks to make sure user enters year correctly
            while(true) {
            System.out.println("\nPlease enter your current year 1/2/3/4/5/6: ");
            year = input.nextInt();  
            input.nextLine(); 
            if (year > 0 && year < 7)
                break;
            }
            System.out.println("\nPlease enter your current major: ");
            String major = input.nextLine();  
            if(student.addStudent(name, email, password, date, sex, gender, 
                true, gpa, location, level, major, year, username)) {
                loginStudent(student.getStudent(username, password));
            } else {
                System.out.println("\nThere was an error in creating your account!\n");
            }
    }
    /**
     * Shows the screen after a student has logged in
     * @param s Student object for logged in student
     */
    public void loginStudent(Student s) {
        System.out.println("\n");
        System.out.println("**************************************");
        System.out.println("*          Welcome Student!          *");
        System.out.println("**************************************\n");
        while(true) { // Loops the log-in menu until the student exits
            System.out.println("1. View account information");
            System.out.println("2. View resume");
            System.out.println("3. View job listings");
            System.out.println("   Enter X to logout");
            String option = input.nextLine();
            if(option.equals("1")) {
                studentInfo(s);
            } else if(option.equals("2")) { 
                System.out.println("To be implemented");
            } else if(option.equals("3")) {
                jobListingScreen();
            } else if(option.equalsIgnoreCase("x")) {
                mainScreen();
            } else {
                System.out.println("Error! Invalid input.");
            }
        }
    }
    /**
     * Displays the user's info and allows them to edit it
     * @param s Student object
     */
    public void studentInfo(Student s) {
        System.out.println(s.toString()+"\n\n");
    }
    /**
     * Shows the lists of open job  listings for students
     */
    public void jobListingScreen() {
        System.out.println("\n");
        System.out.println("**************************************");
        System.out.println("*         Currently open jobs        *");
        System.out.println("**************************************\n\n");
        ArrayList<JobListing> jobs = company.getOpenJobs();
    }
//==============================   Company Functions  =================================
    /**
     * Handles logging in for companies
     * @return Company object returned from logging in
     */
    public Company loginHandlerCompany() {
        while(true) {
            System.out.println("Please enter your username: (Enter X to go back to main screen)");
            String username = input.nextLine();  
            // Checks if the user wants to exit
            if(username.equalsIgnoreCase("X"))
                break;
            System.out.println("Please enter your password: ");
            String password = getPassword(input.nextLine());  
            Company companyUser = company.getCompany(username, password);
            // Returns the company if the log in is successful
            if(companyUser != null) {
                return companyUser;
            }
            System.out.println("Error!\nCompany not found with username and password combination.\n");
        }
        return null; // Returns null if no company is found and the user exits
    }
    /**
     * Handles creating a new company
     */
    public void addCompany() {
        System.out.println("\n");
        System.out.println("**************************************");
        System.out.println("*       Welcome new Company!         *");
        System.out.println("**************************************\n\n");
        String name = new String();
        while(true) { // Checks to see if the user enters a full name
            System.out.println("Please enter your full name: ");
            name = input.nextLine();  
            if(name.contains(" "))
                break;
            System.out.println("Error! Make sure to enter your full name.\n");
        }
        String username = new String();
        while(true) { // Checks to make sure username is not already taken
            System.out.println("\nPlease enter your username: ");
            username = input.nextLine();
            if(!company.haveCompany(username))
                break;
            System.out.println("Sorry! That username is already taken.");
        }
        System.out.println("\nPlease enter your email: ");
        String email = input.nextLine();  
        System.out.println("\nPlease enter your password: ");
        String password = getPassword(input.nextLine());  
        System.out.println("\nPlease enter company\'s name: ");
        String companyName = input.nextLine();  
        System.out.println("\nPlease enter their phone number: ");
        String contact = input.nextLine();  
        System.out.println("\nPlease enter the company's address: ");
        String address = input.nextLine();  
        String cDateEst = new String();
        Date date = new Date();
        while(true) { // Checks to make sure date is formatted correctly
            System.out.println("\nPlease enter the date your company was established in the format dd/MM/yyyy: ");
            System.out.println("  (ex: 31/12/2000)");
            cDateEst = input.nextLine();  
            Pattern pattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
            Matcher matcher = pattern.matcher(cDateEst);
            if(matcher.matches())
                break;
        }
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try { date = formatter.parse(cDateEst); }
        catch (ParseException e) {e.printStackTrace(); }
        System.out.println("\nPlease enter the company's website: ");
        String website = input.nextLine();
        if(company.addCompany(companyName, username, email, password, address, name, 
            contact, date, website)) {
            loginCompany(company.getCompany(username, password));
        } else {
            System.out.println("\nThere was an error creating your account!\n");
        }
    }
    /** 
     * Displays the options after a company logs in
     * @param c Company object of current user
     */
    public void loginCompany(Company c) {
        System.out.println("\n");
        System.out.println("**************************************");
        System.out.println("*          Welcome Company!          *");
        System.out.println("**************************************\n\n");
        while(true) { // Loops company log in menu until user exits
            System.out.println("1. View account information");
            System.out.println("2. Create a Job Listing");
            System.out.println("3. View Job Listings");
            System.out.println("4. View applicants");
            System.out.println("   Enter X to logout");
            String option = input.nextLine();
            if(option.equals("1")) {
                companyInfo(c);
            } else if (option.equals("2")) {
                addJobListing(c.getId());
            } else if (option.equals("3")) {
                chooseJobFromCompany(c.getId());
            } else if (option.equals("4")) {
                JobListing job = chooseJobFromCompany(c.getId());
                if(job != null) { // If the user selected a job
                    viewApplications(job.getID());
                }
            } else if (option.equalsIgnoreCase("x")) {
                break;
            }
        }
    }
    /**
     * View list of applicants from job id
     * @param id UUID of job posting's ID
     */
    public void viewApplications(UUID id) {
        ArrayList<Application> applicants = applications.getOpenApplicationsByJob(id);
        if(applicants.size() > 0) {
            System.out.println("ID\tStudent\'s name\tDate Applied");
            for (int i = 0; i < applicants.size(); i++) {
                System.out.print(" "+i+"\t");
                System.out.print(student.getStudent(applicants.get(i).getStudentId()).name+"\t");
                SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
                System.out.print(ft.format(applicants.get(i).getApplicationDate())+"\t");
            }
        } else 
            System.out.println("You do not have any applications for this job listing\n\n");
    }
    /**
     * Displays the company info and gives the option to edit it
     * @param c Company object
     */
    public void companyInfo(Company c) {
        System.out.println(c.toString());
    }
    /**
     * Views the current job listens for a company
     * @param id UUID of the company's ID
     * @return JobListing object the user selects
     */
    public JobListing chooseJobFromCompany(UUID id){
        ArrayList<JobListing> jobs = company.getJobsByCompanyId(id);
        if(jobs.size() == 0) { // Company doesn't have any jobs yet
            System.out.println("You do not have any job listings.\n\n");
            return null;
        }
        for (int i = 0; i < jobs.size(); i++) {
            System.out.println("ID: "+i+" "+jobs.get(i)+" "+jobs.get(i).toString());
        }
        int index = 0;
        while(true) { // Checks if ID user enters is a valid index
            System.out.println("Please enter the ID of the job listing you would like to view: ");
            if(input.hasNextInt()) {
                index = input.nextInt();
                if(index >= 0 && index < jobs.size())
                    break;
            }
            System.out.println("Error! Invalid ID\n");
        }
        return jobs.get(index);
    }
    /**
     * Handles creating a new job listing
     * @param companyID ID of the company
     */
    public void addJobListing(UUID companyID) {
        System.out.println("**************************************");
        System.out.println("*         Create Job Listing         *");
        System.out.println("**************************************\n\n");
        System.out.println("\nPlease enter the job title for the position: ");
        String title = input.nextLine();  
        System.out.println("\nPlease enter the location of the job site: ");
        String loc = input.nextLine();  
        int minHrs = 0;
        while(true){ // Checks to see if the user enters an interger
            System.out.println("\nPlease enter the minimum number of hours for the position: ");
            if(input.hasNextInt())  {
                minHrs = input.nextInt();
                input.nextLine();
                break;
            } else
                input.next(); // Resets the input
        }
        System.out.println();
        int maxHrs = 0;
        while(true){  // Checks to see if the user enters an interger
            System.out.println("\nPlease enter the maximum number of hours for the position: ");
            if(input.hasNextInt())  {
                maxHrs = input.nextInt();
                input.nextLine();
                break;
            } else
            input.next(); // Resets the input
        }
        double pay = 0.0;
        while(true) { // Checks to see if the user enters a double
            System.out.println("\nPlease enter the pay rate in USD: ");
            if(input.hasNextDouble()) {
                pay = input.nextDouble();  
                input.nextLine();
                break;
            } else
            input.next(); // Resets the input
        }
        int numOpenings = 0;  
        while(true){ // Checks to see if the user enters an interger
            System.out.println("\nPlease enter the number of openings: ");
            if(input.hasNextInt())  {
                numOpenings = input.nextInt();
                input.nextLine();
                break;
            } else
            input.next(); // Resets the input
        }
        Date date = new Date();
        String dateString;
        while(true) { // Checks to see if the entered date is in the correct format
            System.out.println(
                "Please enter the job closing date in format MM/dd/yyyy:");
            System.out.println(
                "   *Will be automatically set to a year from today if left blank");
            dateString = input.nextLine();  
            if(dateString.length() == 0) { // If user chose not to make one
                // Creates a localdate object one year from today and creates a string
                LocalDate dateL = LocalDate.now().plusDays(365);
                dateString = dateL.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                break;
            }
            Pattern pattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
            Matcher matcher = pattern.matcher(dateString);
            if(matcher.matches()) 
                break;
        }
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        try { date = formatter.parse(dateString); }
        catch (ParseException e) { e.printStackTrace(); }
        System.out.println(
            "Would you like to enter a list of required skills for the position" +
        "\n   Enter 0/y/yes to create skills - enter any other key to leave empty");
        String option = input.nextLine();
        ArrayList<String> skills = new ArrayList<String>();
        if(option.equals("0") || option.equalsIgnoreCase("y") || option.equalsIgnoreCase("yes"))
            skills = skillsEditor(null, false); // See JavaDoc
        ArrayList<String> duties = dutiesEditor(null); // See JavaDoc
        System.out.println("\nPlease enter the job description for this position: ");
        String description = input.nextLine();
        boolean remote = false;
        while(true) { // Checks to see if the user enters a boolean
            System.out.println("\nIs this job Remote? Please enter true or false");
            if(input.hasNextBoolean()) {
                remote = input.nextBoolean();
                break;
            } else
            input.next();
        }
        System.out.println(
            "Please enter the minimum experience required for this position: ");
        String minExp = input.nextLine();
        company.addJob(companyID, title, loc, minHrs, maxHrs, pay, 
            date, numOpenings, skills, duties, description, minExp, remote, true);
    }
    /**
     * Handles creating an interactive arraylist for the user to interact with
     * @param id UUID of of job posting, to optionally load pre-existing data
     * @return ArrayList<String> of duties user created
     */
    public ArrayList<String> dutiesEditor(UUID id) {
        ArrayList<String> duties = new ArrayList<String>();
        while(true) {
            if(id != null) // If there is something to load
                duties = company.getJobById(id).duties;
            System.out.println("1. View your current list of duties");
            System.out.println("2. Add a duty to your list of duties");
            System.out.println("3. Delete a duty from your current list of duties");
            System.out.println("4. Exit (Or enter X)");
            String option = input.nextLine();
            if(option.equals("1")) {
                if(duties.size() > 0) {
                    for(String duty : duties) {
                        System.out.println(duty);
                    }
                } else // Shows this if the user does not currently have any duties
                    System.out.println("You do not currently have any duties.\n");
            } else if(option.equals("2")) {
                System.out.println("Enter a duty to add for this position: ");
                String newDuty = input.nextLine();
                duties.add(newDuty);
                System.out.println("Duty successfully added!\n");
            } else if(option.equals("3")) {
                if(duties.size() > 0) {
                    while(true) { // Checks to make sure user enters valid index
                        for(int i = 0; i < duties.size(); i++) {
                            System.out.println("ID:"+i+" - "+duties.get(i));
                        }
                        System.out.println("Enter the ID of the duty to delete:");
                        System.out.println(
                        "    Enter X to go back to the previous screen");
                        if(input.hasNextInt()) {
                            int index = input.nextInt();
                            if(index >= 0 && index < duties.size()) {
                                duties.remove(index);
                                System.out.println("Duty successfully deleted!");
                                break;
                            }
                        } else if(input.nextLine().equalsIgnoreCase("x"))
                            break;
                    }
                } else // Shows this if the user does not have any duties
                    System.out.println("You do not currently have any duties.\n");
            } else if(option.equals("4")) { // User chose to exit
                if(duties.size() > 0) // Checks to make sure there is at least 1 duty
                    break;
                else 
                    System.out.println("Error! You must have at least one duty.");
            }
        }
        return duties;
    }
    /**
     * Editor for Skills ArrayList for both JobListing and Resume
     * @param id optional UUID of pre-existing skills to load 
     * @param resumeSkills boolean of whether or not this is for a resume
     * @return ArrayList<String> of skills user created
     */
    public ArrayList<String> skillsEditor(UUID id, boolean resumeSkills) {
        ArrayList<String> skills = new ArrayList<String>();
        while(true) { // Loops through menu until user exits
            if(id != null) { // Checks to see if there is something to load
                if(resumeSkills)
                    skills = resumes.getResumeById(id).getSkills();
                else
                    skills = company.getJobById(id).skillsReq;
            }
            if(resumeSkills) {
                System.out.println("1. View your current list of skills");
                System.out.println("2. Add a skill to your list of skills");
                System.out.println("3. Delete a skill from your current list of skills");
            } else {
                System.out.println("1. View your current list of required skills for this position");
                System.out.println("2. Add a skill to your list of required skills");
                System.out.println("3. Delete a skill from your list of required skills");
            }
            System.out.println("4. Exit (Or type X to exit)");
            String option = input.nextLine();
            if(option.equals("1")) { // View skills
                if(skills.size() > 0) {
                    for(int i = 0; i < skills.size(); i++) {
                        System.out.println(skills.get(i));
                    }
                } else {
                    System.out.println(
                        "You do not have any skills yet! Please add a skill.");
                }
            } if(option.equals("2")) { // Add skill
                if(resumeSkills) // If this is for a resume
                    System.out.println("Enter a skill to add: ");
                else  // If this is for a job listing
                    System.out.println("Enter a skill you are requiring: ");
                String newSkill = input.nextLine();
                skills.add(newSkill);
            } if(option.equals("3")) { // Delete skill
                if(skills.size() > 0) { // Checks if there are any skills to delete
                    while(true) { // Checks to see if user enters valid skill
                        for(int i = 0; i < skills.size(); i++) {
                            System.out.println("ID:"+i+" - "+skills.get(i));
                        }
                        System.out.println("Enter the ID of the skill you wish to delete: ");
                        if(input.hasNextInt()) {
                            int index = input.nextInt();
                            if(index >= 0 && index < skills.size()) {
                                skills.remove(index);
                                System.out.println("Skill successfully removed.");
                                break;
                            }
                        }
                    }
                } else 
                    System.out.println("You do not have any skills currently.");
            } else if (option.equals("4") || option.equalsIgnoreCase("x"))
                break;
        }
        return skills;
    }
}
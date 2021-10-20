package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Welcome {

    private ArrayList<Student> studentUsers;
    private ArrayList<Company> companyUsers;
    private Student s = new Student(null, 0, null, null);
    private Company c = new Company(0, 0, false, null, null, null, null, null);
    public Scanner input = new Scanner(System.in);  // Create a Scanner object
    private static Welcome screen;
	  
	private Welcome() {
        this.studentUsers = new ArrayList<>();
        this.companyUsers = new ArrayList<>();
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
        
    }

    public void loginCompany() {
        
    }

    public void addStudent() {
        
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
        c.email = cEmail;
        System.out.println("> " + cEmail);
        System.out.println("");
        System.out.println("Please enter your password: ");
        System.out.println("> will set later");
        System.out.println("");
        System.out.println("Please enter your hiring recruiters name: ");
        String cRecruit = input.nextLine();  // Read user input
        c.hiringRecruiter = cRecruit;
        System.out.println("");
        System.out.println("Please enter their contact info: ");
        String cContact = input.nextLine();  // Read user input
        c.contactInfo = cContact;
        System.out.println("");
        
         companyUsers.add(c);

        System.out.println(c.toString());
        
    }

    
}

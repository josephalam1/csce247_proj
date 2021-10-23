package src;

import java.text.ParseException;
import java.util.Scanner;

public class SystemDriver {

    public void run() {
        Welcome screen = Welcome.getInstance();

        while (Welcome.logout == false) {
            //Welcome screen = Welcome.getInstance();
            Scanner input = new Scanner(System.in);
            String Option = input.nextLine();

            switch (Option) {
                case "3":
                    screen.addCompany();
                    break;
                case "2":
                    screen.addStudent();
                    screen.loginStudent();
                    break;
                case "1":
                    // if state to find login account
                    screen.loginStudent();
                case "l":
                case "L": // user can type l or L and get the L case
                    Welcome.logout = true;
                    break;
                default:
                    break;
            }

            /*if (Option.equals("3")) {
                screen.addCompany();
            } else if (Option.equals("2")) {
                screen.addStudent();
            }
            if (Option.equalsIgnoreCase("l")) {
                Welcome.logout = true;
            }*/    
        }
        System.out.println("Goodbye");
        System.exit(0);
    }

    public static void main(String[] args) {
        SystemDriver driver = new SystemDriver();
        driver.run();
    }
}

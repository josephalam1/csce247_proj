package src;

import java.io.UnsupportedEncodingException;
import java.lang.StackWalker.Option;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Scanner;

public class SystemDriver {

    public void run() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Welcome screen = Welcome.getInstance();
        while (Welcome.logout == false) {
            //Welcome screen = Welcome.getInstance();
            Scanner input = new Scanner(System.in);
            String Option = input.nextLine();

            switch (Option) {
                case "3":
                    screen.addCompany();
                    // screen.loginCompany(c);
                    screen.loginCompany();
                    break;
                case "2":
                    screen.addStudent();
                    //screen.loginStudent(s);
                    screen.loginStudent();
                    break;
                case "1":
                    screen.whichUser();
                    break;
                case "l":
                case "L": // user can type l or L and get the L case
                    Welcome.logout = true;
                    break;
                default:
                    break;
            }  
        }
        System.out.println("Goodbye");
        System.exit(0);
    }

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        SystemDriver driver = new SystemDriver();
        driver.run();
    }
}

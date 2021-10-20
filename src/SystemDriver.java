package src;

import java.text.ParseException;
import java.util.Scanner;

public class SystemDriver {

    public void run() {
        Welcome screen = Welcome.getInstance();
        Scanner input = new Scanner(System.in);
        String welcomeOption = input.nextLine();
        if (welcomeOption.equals("3")) {
            screen.addCompany();
        } else if (welcomeOption.equals("2")) {
            screen.addStudent();
        }
        
    }

    public static void main(String[] args) {
        SystemDriver driver = new SystemDriver();
        driver.run();
    }
}

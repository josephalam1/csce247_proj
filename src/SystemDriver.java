package src;

import java.util.Scanner;

public class SystemDriver {

    public void run() {
        Welcome screen = Welcome.getInstance();
        Scanner input = new Scanner(System.in);
        String welcomeOption = input.nextLine();
        if (welcomeOption.equals("3")) {
            screen.addCompany();
        }
        System.out.println("Compiled");
    }

    public static void main(String[] args) {
        SystemDriver driver = new SystemDriver();
        driver.run();
    }
}

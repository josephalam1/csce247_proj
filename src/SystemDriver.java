package src;

public class SystemDriver {

    public void run() {
        System.out.println("Compiled");
    }

    public static void main(String[] args) {
        SystemDriver driver = new SystemDriver();
        driver.run();
    }
}

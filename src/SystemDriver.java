package src;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class SystemDriver {

    public void run() throws UnsupportedEncodingException, NoSuchAlgorithmException {
       new Welcome();
    }

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        SystemDriver driver = new SystemDriver();
        driver.run();
    }
}

package src;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class SystemDriver {

    public void run() throws UnsupportedEncodingException, NoSuchAlgorithmException, IOException {
       new Welcome();
    }

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, IOException {
        SystemDriver driver = new SystemDriver();
        driver.run();
    }
}

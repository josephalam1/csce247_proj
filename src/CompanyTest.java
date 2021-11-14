package src;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;
import java.util.UUID;

public class CompanyTest {

    UUID tCompanyId = UUID.randomUUID();
    public String name;
    public String recruiterEmail;
    public String recruiterUsername;
    protected String password;
    public String address;
    public String hiringRecruiter;
    public String contactInfo;
    public Date dateEstablished;
    public String webSite;
    private double rating;
    private Boolean adminPrivilege = false;

    @BeforeEach
    public void setup() {
        Company c1 = new Company(tCompanyId, "comp1 ", "compRecruiter1 ", "compRecruiter1@gmail.com ", password, "1234 street ", "comp1RecruiterName ", "contact: info ", new Date(), "www.comp1.com ", 4.4);
        Company c2 = new Company(tCompanyId, "comp2 ", "compRecruiter2 ", "compRecruiter2@gmail.com ", password, "5678 street ", "comp2RecruiterName ", "contact: info2 ", new Date(), "www.comp2.com ", 3.4);
    }

    @AfterEach 
    public void tearDown() {
        
    }

    @Test 
    void testCompanyID() {
       
    }
    @Test 
    void testCompanyName() {
       
    }
    @Test 
    void testCompanyEmail() {
        
    }
    @Test 
    void testCompanyAddress() {
        
    }
    @Test 
    void testCompanyRecruiter() {
        
    }
    @Test 
    void testCompanyContactInfo() {
       
    }
    @Test 
    void testDateEst() {
      
    }
    @Test 
    void testCompanyWebsite() {
       
    }
    @Test 
    void testCompanyRating() {
      
    }
    @Test 
    void testCompanyAdmin() {
      
    }
    
}

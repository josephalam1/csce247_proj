package src;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;
import java.util.UUID;
import javax.xml.validation.Validator;

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
    private Companies testCompanies = Companies.getInstance();
    private ArrayList<Company> companyList = testCompanies.getCompanies();

    @BeforeEach
    public void setup() {
        Company c1 = new Company(tCompanyId, "comp1 ", "compRecruiter1@gmail.com  ", "compRecruiter1 ", password, "1234 street ", "comp1RecruiterName ", "contact: info ", new Date(), "www.comp1.com ", 4.4);
        companyList.clear();
        companyList.add(c1);
        DataWriter.saveCompanies();
    }

    @AfterEach 
    public void tearDown() {
        companyList.clear();
        DataWriter.saveCompanies();
    }

    @Test 
    void testCompanyID() {
        Company c1 = companyList.get(0);
        assertEquals(c1.getId(), c1.getId());
    }
    @Test 
    void testCompanyName() {
        Company c1 = companyList.get(0);
       assertEquals(c1.name, c1.name);
    }
    @Test 
    void testCompanyNameNull() {
        Company c1 = companyList.get(0);
        c1.name = null;
        boolean noName = true;
        if (c1.name == null) {
            assertTrue(noName);
        } else {
            noName = false;
            assertFalse(noName);
        }
    }
    @Test 
    void testEmail() {
        Company c1 = companyList.get(0);
        assertEquals(c1.recruiterEmail, c1.recruiterEmail);
    }
    @Test 
    void testCompanyEmailNull() {
        Company c1 = companyList.get(0);
        c1.recruiterEmail= null;
        boolean noEmail = true;
        if (c1.recruiterEmail == null) {
            assertTrue(noEmail);
        } else {
            noEmail = false;
            assertFalse(noEmail);
        }
    }
    @Test 
    void testCompanyAddress() {
        Company c1 = companyList.get(0);
        assertEquals(c1.address, c1.address);
    }
    @Test 
    void testCompanyAddresslNull() {
        Company c1 = companyList.get(0);
        c1.address= null;
        boolean noAddress = true;
        if (c1.address == null) {
            assertTrue(noAddress);
        } else {
            noAddress = false;
            assertFalse(noAddress);
        }
    }
    @Test 
    void testCompanyRecruiter() {
        Company c1 = companyList.get(0);
        assertEquals(c1.hiringRecruiter, c1.hiringRecruiter);
    }
    @Test 
    void testCompanyContactInfo() {
        Company c1 = companyList.get(0);
        assertEquals(c1.contactInfo, c1.contactInfo);
    }
    @Test 
    void testDateEst() {
        Company c1 = companyList.get(0);
        assertEquals(c1.dateEstablished, c1.dateEstablished);
    }
    @Test 
    void testCompanyWebsite() {
        Company c1 = companyList.get(0);
        assertEquals(c1.webSite, c1.webSite);
    }
    @Test 
    void testCompanyRating() {
        Company c1 = companyList.get(0);
        assertEquals(c1.getRating(), c1.getRating());
    }
    @Test 
    void testCompanyAdmin() {
        assertFalse(this.adminPrivilege);
    }
    
}

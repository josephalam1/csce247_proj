package src;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

class CompaniesTest {
    UUID testId = UUID.randomUUID();
    private Companies companies = Companies.getInstance();
    private ArrayList<Company> companyList = companies.getCompanies();

    @BeforeEach
    public void setup() {
        companyList.clear();
        companyList.add(new Company(testId, "Company A", "compa", "companya@business.com", "password", 
        "123 st.", "Joey Alam", "123-456-7890", new Date(), "http://www.com/", 0.0)); 
        companyList.add(new Company("Company B", "compb", "companyb@business.com", "password", 
        "123 st.", "Joey Alam", "123-456-7890", new Date(), "http://www.com/", 0.0)); 
        DataWriter.saveCompanies();
    }

    @AfterEach 
    public void tearDown() {
        companies.getInstance().getCompanies().clear();
        DataWriter.saveCompanies();
    }
    @Test 
    void testHaveCompanyValidFirstItem() {
        boolean hasCompA = companies.haveCompany("compa");
        assertTrue(hasCompA);
    }

    @Test 
    void testHaveCompanyValidLastItem() {
        boolean hasCompB = companies.haveCompany("compb");
        assertTrue(hasCompB);
    }
    @Test 
    void testHaveCompanyInvalid() {
        boolean hasCompC = companies.haveCompany("compc");
        assertFalse(hasCompC);
    }
    @Test 
    void testHaveCompanyEmpty() {
        boolean hasEmpty = companies.haveCompany("");
        assertFalse(hasEmpty);
    }
    @Test 
    void testHaveCompanyNull() {
        boolean hasNull = companies.haveCompany("");
        assertFalse(hasNull);
    }
    @Test 
    void testAddCompanyNotExist() {
        assertTrue(
        companies.addCompany("Company C", "compc", "companya@business.com", "password", 
        "123 st.", "Joey Alam", "123-456-7890", new Date(), "http://www.com/"));
    }
    @Test 
    void testAddCompanyAlreadyExist() {
        assertFalse(
            companies.addCompany("Company A", "compa", "companya@business.com", "password", 
            "123 st.", "Joey Alam", "123-456-7890", new Date(), "http://www.com/")
                );
    }
    @Test 
    void testAddCompanyEmpty() {
        assertFalse(
            companies.addCompany("", "", "", "", "", "", "", new Date(), "")
        );
    }
    @Test 
    void testAddUserNull() {
        assertFalse(
            companies.addCompany(null, null, null, null, null, null, null, 
                new Date(), null)
        );
    }
    @Test
    void testGetCompanyExists() {
        Company company = companies.getCompany("compa", "password");
        assertEquals(company, companyList.get(0));
    }
    @Test
    void testGetCompanyNotExists() {
        Company company = companies.getCompany("compa", "wrongpassword");
        assertEquals(company, null);
    }
    @Test
    void testGetCompanyExistsById() {
        Company company = companies.getCompany(testId);
        assertEquals(company, companyList.get(0));
    }
    @Test
    void testGetCompanyNotExistsById() {
        Company company = companies.getCompany(UUID.randomUUID());
        assertEquals(company, null);
    }
}
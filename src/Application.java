package src;

import java.util.ArrayList;

public class Application {

    private int zipCode;
    private String pastEdu;
    private String pastEduCity;
    private int pastEduStrtDate;
    private int pastEduEndDate;
    private String pastWorkName;
    private String pastJobTitle;
    private ArrayList<String> pastJobDuties;
    private int pastWorkStrtDate;
    private int pastWorkEndDate;

    public Application(int zipCode, String pastEdu, String pastEduCity, int pastEduStrtDate, int pastEduEndDate,
    String pastWorkName, String pastJobTitle, ArrayList<String> pastJobDuties, int pastWorkStrtDate,
    int pastWorkEndDate) {

        this.zipCode = zipCode;
        this.pastEdu = pastEdu;
        this.pastEduCity = pastEduCity;
        this.pastEduStrtDate = pastEduStrtDate;
        this.pastEduEndDate = pastEduEndDate;
        this.pastWorkName = pastWorkName;
        this.pastJobTitle = pastJobTitle;
        this.pastJobDuties = pastJobDuties;
        this.pastWorkStrtDate = pastWorkStrtDate;
        this.pastWorkEndDate = pastWorkEndDate;

}

    
    public int getZipCode() {
        return zipCode;
    }
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
    public String getPastEdu() {
        return pastEdu;
    }
    public void setPastEdu(String pastEdu) {
        this.pastEdu = pastEdu;
    }
    public String getPastEduCity() {
        return pastEduCity;
    }
    public void setPastEduCity(String pastEduCity) {
        this.pastEduCity = pastEduCity;
    }
    public int getPastEduStrtDate() {
        return pastEduStrtDate;
    }
    public void setPastEduStrtDate(int pastEduStrtDate) {
        this.pastEduStrtDate = pastEduStrtDate;
    }
    public int getPastEduEndDate() {
        return pastEduEndDate;
    }
    public void setPastEduEndDate(int pastEduEndDate) {
        this.pastEduEndDate = pastEduEndDate;
    }
    public String getPastWorkName() {
        return pastWorkName;
    }
    public void setPastWorkName(String pastWorkName) {
        this.pastWorkName = pastWorkName;
    }
    public String getPastJobTitle() {
        return pastJobTitle;
    }
    public void setPastJobTitle(String pastJobTitle) {
        this.pastJobTitle = pastJobTitle;
    }
    public ArrayList<String> getPastJobDuties() {
        return pastJobDuties;
    }
    public void setPastJobDuties(ArrayList<String> pastJobDuties) {
        this.pastJobDuties = pastJobDuties;
    }
    public int getPastWorkStrtDate() {
        return pastWorkStrtDate;
    }
    public void setPastWorkStrtDate(int pastWorkStrtDate) {
        this.pastWorkStrtDate = pastWorkStrtDate;
    }
    public int getPastWorkEndDate() {
        return pastWorkEndDate;
    }
    public void setPastWorkEndDate(int pastWorkEndDate) {
        this.pastWorkEndDate = pastWorkEndDate;
    }
    
    public String getAllEdu() {
        return "School 1\n"+pastEdu+" In "+pastEduCity+" From: "+pastEduStrtDate+" To: "+pastEduEndDate;

    }
    public String getAllWork() {
        return "Job 1\n"+pastWorkName+" Title: "+pastJobTitle+" From: "+pastWorkStrtDate+" To: "+pastWorkEndDate+" Duties: "+pastJobDuties;
        
    }
    public void addWork() {
        
    }
    public void addEdu() {
        
    }
    public void buildResume() {
        
    }
    public String toString() {
        return "Application: ";
    }

}

package src;

import java.util.ArrayList;

public class Application {

    private int zipCode;
    private String pastWorkName;
    private String pastJobTitle;
    private ArrayList<String> pastJobDuties;
    private int pastWorkStrtDate;
    private int pastWorkEndDate;

    public Application(int zipCode, String pastEdu, String pastEduCity, int pastEduStrtDate, int pastEduEndDate,
    String pastWorkName, String pastJobTitle, ArrayList<String> pastJobDuties, int pastWorkStrtDate,
    int pastWorkEndDate) {

        this.zipCode = zipCode;
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
    
    public String getAllWork() {
        return "Job 1\n"+pastWorkName+"\nTitle: "+pastJobTitle+"\nFrom: "+pastWorkStrtDate+" To: "+pastWorkEndDate+"\nDuties: "+pastJobDuties;
        
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

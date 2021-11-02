package src;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Experiences {
    public String companyName;
    public Date jobStartDate;
    public Date jobEndDate;
    public ArrayList<String> jobDuties;
    public String pastJobTitle;
    
    public Experiences(String companyName, String pastJobTitle, Date jobStartDate, Date jobEndDate, ArrayList<String> jobDuties ) {
        this.companyName = companyName;
        this.jobDuties = jobDuties;
        this.jobStartDate = jobStartDate;
        this.jobEndDate = jobEndDate;
        this.pastJobTitle = pastJobTitle;
    }
    
    /**
     * Returns a string format of an Experience
     */
    public String toString(){
        SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
        String returnString =  "Job title: " + pastJobTitle + " for company: " 
        + companyName + "\nEmployed from: " + ft.format(jobStartDate) + " - " + 
        ft.format(jobEndDate) + "\nJob duties: \n";
        for(String duty : jobDuties) {
            returnString += " "+duty;
        }
        return returnString;
    }
}

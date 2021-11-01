package src;

import java.util.ArrayList;
import java.util.Date;

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
        return "Experiences: " + 
        "\nTitle: " + pastJobTitle + "\nCompany Name: " + companyName +
        "\nStart Date: " + jobStartDate + " End Date: " + jobEndDate +
        "\nJob duties: \n" + jobDuties;
    }
}

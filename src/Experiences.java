package src;

import java.util.ArrayList;
import java.util.Date;

public class Experiences {
    public String companyName;
    public Date jobStartDate;
    public Date jobEndDate;
    public ArrayList<String> jobDuties;
    public String jobTitle;
    
    public Experiences(String companyName, String jobTitle, Date jobStartDate, Date jobEndDate, ArrayList<String> jobDuties ) {
        this.companyName = companyName;
        this.jobDuties = jobDuties;
        this.jobStartDate = jobStartDate;
        this.jobEndDate = jobEndDate;
        this.jobTitle = jobTitle;
    }
    
    public String toString(){
        return "Experiences: ";
    }
}

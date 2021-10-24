package src;

import java.util.ArrayList;

public class Experiences {
    public int jobStartDate;
    public int jobEndDate;
    public String jobDuties;
    public String jobTitle;
    
    public Experiences(int jobStartDate, int jobEndDate, String jobDuties, String jobTitle) {
        this.jobDuties = jobDuties;
        this.jobStartDate = jobStartDate;
        this.jobEndDate = jobEndDate;
        this.jobTitle = jobTitle;
    }
    
    public String toString(){
        return "Experiences: ";
    }
}

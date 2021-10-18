package src;

import java.util.ArrayList;

public class JobListing {

    public String title;
    public String location;
    private int minHours;
    private int maxHours;
    private double pay;
    private int expDate;
    public int numOpenings;
    public ArrayList<String> skillsReq;
    public ArrayList<String> description;
    public ArrayList<String> applicants;
    public String minExp;
    public boolean Remote;
    public boolean open;

    public JobListing(String title, String location, int minHours, int maxHours,
            double pay, int expDate, int numOpenings, ArrayList<String> skillsReq, ArrayList<String> description,
            ArrayList<String> applicants, String minExp, boolean remote, boolean open) {
        this.title = title;
        this.location = location;
        this.minHours = minHours;
        this.maxHours = maxHours;
        this.pay = pay;
        this.expDate = expDate;
        this.numOpenings = numOpenings;
        this.skillsReq = skillsReq;
        this.description = description;
        this.applicants = applicants;
        this.minExp = minExp;
        Remote = remote;
        this.open = open;
    }

    public int getMinHours() {
        return minHours;
    }

    public void setMinHours(int minHours) {
        this.minHours = minHours;
    }

    public int getMaxHours() {
        return maxHours;
    }

    public void setMaxHours(int maxHours) {
        this.maxHours = maxHours;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public int getExpDate() {
        return expDate;
    }

    public void setExpDate(int expDate) {
        this.expDate = expDate;
    }

    public String toString(){
        return super.toString() + " Job Listing";
    }

}

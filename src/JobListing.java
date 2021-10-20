package src;


import java.util.Date;
import java.util.ArrayList;

public class JobListing {

    public String title;
    public String location;
    private int minHours;
    private int maxHours;
    private double pay;
    private Date expDate;
    public int numOpenings;
    public ArrayList<String> skillsReq;
    public ArrayList<String> description;
    public ArrayList<String> applicants;
    public String minExp;
    public boolean remote;
    public boolean open;

    public JobListing(String title, String location, int minHours, int maxHours,
            double pay, Date expDate, int numOpenings, ArrayList<String> skillsReq, ArrayList<String> description,
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
        this.remote = remote;
        this.open = open;
    }

    
    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getLocation() {
        return location;
    }


    public void setLocation(String location) {
        this.location = location;
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


    public Date getExpDate() {
        return expDate;
    }


    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }


    public int getNumOpenings() {
        return numOpenings;
    }


    public void setNumOpenings(int numOpenings) {
        this.numOpenings = numOpenings;
    }


    public ArrayList<String> getSkillsReq() {
        return skillsReq;
    }


    public void setSkillsReq(ArrayList<String> skillsReq) {
        this.skillsReq = skillsReq;
    }


    public ArrayList<String> getDescription() {
        return description;
    }


    public void setDescription(ArrayList<String> description) {
        this.description = description;
    }


    public ArrayList<String> getApplicants() {
        return applicants;
    }


    public void setApplicants(ArrayList<String> applicants) {
        this.applicants = applicants;
    }


    public String getMinExp() {
        return minExp;
    }


    public void setMinExp(String minExp) {
        this.minExp = minExp;
    }


    public boolean isRemote() {
        return remote;
    }


    public void setRemote(boolean remote) {
        if(remote == true){
            remote = false;
        }
        else{
            remote = true;
        }
    }


    public boolean isOpen() {
        if(expDate.before(new Date())){
            return true;
        }
        else{
            return false;
        }
    }


    public void setOpen() {
        if(this.open == true){
          this.open = false;  
        }
        else{
            this.open = true;
        }
    }

   
    public String toString(){
        return super.toString() + " Job Listing";
    }

}

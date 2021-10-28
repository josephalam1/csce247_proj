package src;

import java.util.Date;
import java.util.ArrayList;
import java.util.UUID;

public class JobListing {
    public UUID id, companyId;
    public String title, location, description, minExp;
    private int minHours, maxHours, numOpenings;
    private double pay;
    private Date expDate;
    public ArrayList<String> skillsReq;
    public boolean remote, open;
    public ArrayList<Application> applications;

    public JobListing(UUID id, UUID companyID, String title, String location, int minHours, int maxHours,
            double pay, Date expDate, int numOpenings, ArrayList<String> skillsReq, String description,
            String minExp, boolean remote, boolean open) {
        this.id = id;
        this.companyId = companyID;
        this.title = title;
        this.location = location;
        this.minHours = minHours;
        this.maxHours = maxHours;
        this.pay = pay;
        this.expDate = expDate;
        this.numOpenings = numOpenings;
        this.skillsReq = skillsReq;
        this.description = description;
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


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
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

    /**
     * Choose candidate for job posting based on application ID number
     * @param applicationId UUID of application ID that is selected
     * @return boolean of whether or not the candidate was successfully chosen.
     */
   public boolean chooseCandidate(UUID applicationId) {
        Applications applicationsList = Applications.getInstance();
        ArrayList<Application> applicants = applicationsList.getOpenApplicationsByJob(id);
        for(Application application : applicants) {
            
        }
    
        return false;
   }
   
   public void addApplication(Application application) {
       applications.add(application);
   }

   public void viewApplications() {
       for (Application app : applications) {
           System.out.println(app.toString());
       }
   }
    public String toString(){
        return super.toString() + " Job Listing";
    }

}

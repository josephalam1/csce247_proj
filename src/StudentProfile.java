package src;

public class StudentProfile implements ProfileSettings {

    private double GPA;
    public String campusLocation;
    public String currLevel;
    public String currMajor;
    public int currYear;
    private double rating;

    public Student Student(){
        return null;
    }

    public StudentProfile(){

    }

    public String Experiences(){
        return "";
    }

    public String toString(){
        return "";
    }
    
    public void hideFromProfile(String studentProfile){

    }

    @Override
    public void deleteProfile(String aProfile, Boolean adminPrivilege) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void overrideRating(Boolean adminPrivilege) {
        // TODO Auto-generated method stub
        
    }
}

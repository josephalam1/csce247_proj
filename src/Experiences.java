package src;

import java.util.ArrayList;

public class Experiences {

    public ArrayList<String> exp;
    public ArrayList<String> relHobbies;
    public ArrayList<String> relAchievements;
    public ArrayList<String> relSkills;
    
    public Experiences(ArrayList<String> exp, ArrayList<String> relHobbies, ArrayList<String> relAchievements,
            ArrayList<String> relSkills) {
        this.exp = exp;
        this.relHobbies = relHobbies;
        this.relAchievements = relAchievements;
        this.relSkills = relSkills;
    }
    public ArrayList<String> getExp() {
        return exp;
    }

    public void setExp(ArrayList<String> exp) {
        this.exp = exp;
    }

    public ArrayList<String> getRelHobbies() {
        return relHobbies;
    }

    public void setRelHobbies(ArrayList<String> relHobbies) {
        this.relHobbies = relHobbies;
    }

    public ArrayList<String> getRelAchievements() {
        return relAchievements;
    }

    public void setRelAchievements(ArrayList<String> relAchievements) {
        this.relAchievements = relAchievements;
    }

    public ArrayList<String> getRelSkills() {
        return relSkills;
    }

    public void setRelSkills(ArrayList<String> relSkills) {
        this.relSkills = relSkills;
    }


    public String toString(){
        return "Experiences: " + "\nAchievements" + "\nHobbies" + "\nSkills";
    }
}

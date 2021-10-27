package src;

public class References {
    public String name;
    public String relationship;
    public String phoneNum;
    public String email;
    
    public References(String name, String relationship, String phoneNum, String email) {
        this.name = name;
        this.relationship = relationship;
        this.phoneNum = phoneNum;
        this.email = email;
    }
    
    public String toString(){
        return "References: ";
    }
}

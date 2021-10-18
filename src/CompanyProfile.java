package src;

public class CompanyProfile extends Company implements ProfileSettings{

    public String dateEstablished;
    public String webSite;
    private double rating;

    public CompanyProfile(int accType, int id, boolean adminPrivilege, String name, String email, String address,
            String hiringRecruiter, String contactInfo, String dateEstablished, String webSite, double rating) {
        super(accType, id, adminPrivilege, name, email, address, hiringRecruiter, contactInfo);
        this.dateEstablished = getDateEstablished();
        this.webSite = getWebSite();
        this.rating = getRating();
    }

    public String getDateEstablished() {
        return dateEstablished;
    }

    public void setDateEstablished(String dateEstablished) {
        this.dateEstablished = dateEstablished;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String toString(){
        return super.toString() + "Profile\n";
    }

    public void hideFromProfile(String companyProfile) {

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

package src;

public interface ProfileSettings {
    public void hideFromProfile(String aProfile);
    public void deleteProfile(String aProfile, Boolean adminPrivilege);
    public void overrideRating (Boolean adminPrivilege);

}

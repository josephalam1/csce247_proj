package src;
public interface User{
    public void deleteListing(JobListing job, Boolean admin);
    public void editListing(JobListing job, Boolean admin);
}
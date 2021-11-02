package src;

public interface User{
    /**
     * allows Classes that implement user to delete a listing
     * @param job
     * @param admiin
    *
    */
    public void deleteListing(JobListing job, Boolean admin);
    /**
     * allows Classes that implement user to edit a listing
     * @param job
     * @param admin
     */
    public void editListing(JobListing job, Boolean admin);
}
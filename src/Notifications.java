package src;


public interface Notifications {
    public String internshipOffer(Student student);
    public String newJobListing(JobListing a, Student[] s);
    public String newApplicant(JobListing a, Application[] app);
    public String jobListingClosingSoon(JobListing a);
    public void optOutALL();
    public void optOutList(Notifications a, Notifications b, Notifications c);
}

package src;

import java.util.ArrayList;

// COS changed all to public for now because of errors

public interface Features {
    public ArrayList<String> search();
    public ArrayList<String> sort(ArrayList[] search); 
    public ArrayList<String> filter(ArrayList[] search);
    public double giveRating(CompanyProfile aProfile);
}

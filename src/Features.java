package src;

import java.util.ArrayList;

public interface Features {
    public ArrayList<String> search();
    public ArrayList<String> sort(ArrayList[] search);
    public ArrayList<String> filter(ArrayList[] search);
    public double giveRating(CopanyProfile aProfile);
}

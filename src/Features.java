package src;

import java.util.ArrayList;

// COS changed all to public for now because of errors
// reviewed teachers interfaces all are public need to change UML

public interface Features {
    public ArrayList<String> search();
    public ArrayList<String> sort(ArrayList<String> search); 
    public ArrayList<String> filter(ArrayList<String> search);
}

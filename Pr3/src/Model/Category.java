
package Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Category {
    
    public static ArrayList <Category> Categories = new ArrayList<>();
    
    private String  Name;
    private String Directory;
    private ArrayList <String> FormatList;
    
    public Category(String Directory, String Name) {
        this.Directory = Directory;
        this.Name = Name;
        FormatList = new ArrayList<>();
    }
    
    public Category(String Directory, String Name, String Formats)
    {
        this.Name = Name;
        this.Directory = Directory;
        String[] TempFormat = Formats.split(" ");
        FormatList = new ArrayList<>();
        FormatList.addAll(Arrays.asList(TempFormat));
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDirectory() {
        return Directory;
    }

    public void setDirectory(String Directory) {
        this.Directory = Directory;
    }

    public ArrayList <String> getFormatList() {
        return FormatList;
    }

   
}

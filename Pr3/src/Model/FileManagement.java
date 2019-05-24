
package Model;

import static Model.Category.Categories;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class FileManagement {

    public static ArrayList<FileManagement> FileList = new ArrayList<>();
    
    public static enum DownloadEnum
    {
        Downloading,
        Downloaded,
        Paused,
        Failed
    }
    
    private String Name;
    private long Size;
    private Date date;
    private Time time;
    private String Address;
    private DownloadEnum DownloadStatus;
    private Category category;
    
    public FileManagement(String Address) throws URISyntaxException
    {
        this.Name = Paths.get(new URI(Address).getPath()).getFileName().toString();
        boolean Found = false;
        for(Category TempCat: Categories)
        {
            for(String TempFormat: TempCat.getFormatList())
            {
                if(getFormat().equals(TempFormat)){
                    this.category = TempCat;
                    Found = true;
                    break;
                }
            }
        }
        if(!Found)
            this.category = Categories.get(0);
        this.Address = Address;
        this.DownloadStatus = DownloadEnum.Downloading;
        this.date = new Date();
    }
   
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public long getSize() {
        return Size;
    }

    public void setSize(long Size) {
        this.Size = Size;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    
    public DownloadEnum getDownloadStatus() {
        return DownloadStatus;
    }

    public void setDownloadStatus(DownloadEnum DownloadStatus) {
        this.DownloadStatus = DownloadStatus;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    public String getFormat() {
        return this.Name.substring(this.Name.lastIndexOf(".") + 1);
    }
}

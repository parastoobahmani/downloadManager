
package Model;

import Model.FileManagement;
import static Model.FileManagement.FileList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Download implements Runnable{

    public int MaxSyncedDownloads = 4;
    private FileManagement file;
    
    public Download(FileManagement file)
    {
        this.file = file;
    }
    
    @Override
    public void run() {
        
        while(true)
        {
            int i = 0;
            for(FileManagement TempFile: FileList)
            {
                if(TempFile.getDownloadStatus() == FileManagement.DownloadEnum.Downloading)
                    i++;
            }
            if(i > MaxSyncedDownloads)
            {
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException ex) {
                    Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
                break;
        }
        
        try{
            URL Url = new URL(file.getAddress());
            URLConnection UrlConnection = Url.openConnection();
            file.setSize(UrlConnection.getContentLengthLong());
            if(file.getSize() == -1){
                file.setDownloadStatus(FileManagement.DownloadEnum.Failed);
                return;
            }
            FileOutputStream FileOutSt = new FileOutputStream(file.getCategory().getDirectory() + "/" + file.getName(), new File(file.getName()).exists());
            try (ReadableByteChannel RBC = Channels.newChannel(UrlConnection.getInputStream()))
            {
                long SavedBytes = 0, DownloadedBytes;
                while((DownloadedBytes = FileOutSt.getChannel().transferFrom(RBC, SavedBytes, 1024)) > 0 
                          && file.getDownloadStatus() == FileManagement.DownloadEnum.Downloading)
                {
                    SavedBytes += DownloadedBytes;
                }
                file.setDownloadStatus(FileManagement.DownloadEnum.Downloaded);
                RBC.close();
            }
            FileOutSt.close();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, ex);
            file.setDownloadStatus(FileManagement.DownloadEnum.Failed);
        } catch (IOException ex) {
            Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, ex);
            file.setDownloadStatus(FileManagement.DownloadEnum.Failed);
        }
        
    }
    
}

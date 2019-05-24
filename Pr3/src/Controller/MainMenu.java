
package Controller;

import Model.Download;
import Model.FileManagement;
import static Model.FileManagement.FileList;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class MainMenu implements Initializable {
    @FXML
    private TextField TxtFieldNewUrl;
    @FXML
    private ListView<String> ListViewDownloaded;
    @FXML
    private TextField TxtFieldSearch;
    @FXML
    private ListView<String> ListViewPausedDownloads;
    @FXML
    private ListView<String> ListViewFailedDownloads;
    @FXML
    private ListView<String> ListViewShowList;
    @FXML
    private ListView<String> ListViewSearch;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void downloadNewFile(MouseEvent event) {
    }

    @FXML
    private void ButtonDownloadOnAction(ActionEvent event) throws URISyntaxException {
        new Thread(new Download(new FileManagement(TxtFieldNewUrl.getText()))).start();
        TxtFieldNewUrl.clear();
    }

    @FXML
    private void SelectTabDownloading(Event event) {
        
    }

    @FXML
    private void SelectTabPausedDownloads(Event event) {
        ListViewPausedDownloads.getItems().clear();
        for(FileManagement TempList: FileList)
        {
            if(TempList.getDownloadStatus() == FileManagement.DownloadEnum.Paused)
                ListViewFailedDownloads.getItems().add(TempList.getName());
        }
    }

    @FXML
    private void SelectTabDownloaded(Event event) {
        ListViewDownloaded.getItems().clear();
        for(FileManagement TempList: FileList)
        {
            if(TempList.getDownloadStatus() == FileManagement.DownloadEnum.Downloaded)
                ListViewDownloaded.getItems().add(TempList.getName());
        }
    }

    @FXML
    private void SelectTabFailedDownloads(Event event) {
        ListViewFailedDownloads.getItems().clear();
        for(FileManagement TempList: FileList)
        {
            if(TempList.getDownloadStatus() == FileManagement.DownloadEnum.Failed)
                ListViewFailedDownloads.getItems().add(TempList.getName());
        }
    }

    @FXML
    private void SelectTabShowList(Event event) {
    }

    @FXML
    private void SelectTabSearch(Event event) {
        TxtFieldSearch.clear();
        ListViewSearch.getItems().clear();
        
    }

    @FXML
    private void TxtFieldSearchOnKeyReleased(KeyEvent event) {
        boolean Exists = false;
        ListViewSearch.getItems().clear();
        for(FileManagement TempList: FileList)
        {
            if(TempList.getName().contains(TxtFieldSearch.getText()))
                ListViewSearch.getItems().add(TempList.getName());
        }
    }
    
    
    
}

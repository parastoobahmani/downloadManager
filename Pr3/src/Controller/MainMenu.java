
package Controller;

import Model.FileManagement;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MainMenu implements Initializable {
    @FXML
    private AnchorPane AnchorPaneNewDownload;
    @FXML
    private TextField TxtFieldEnterUrl;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ButtonDocumentsOnAction(ActionEvent event) {
    }

    @FXML
    private void ButtonMediaOnAction(ActionEvent event) {
    }

    @FXML
    private void ButtonCompressedOnAction(ActionEvent event) {
    }

    @FXML
    private void ButtonOthersOnAction(ActionEvent event) {
    }

    @FXML
    private void ButtonNewDownloadOnAction(ActionEvent event) {
        AnchorPaneNewDownload.setVisible(true);
    }

    @FXML
    private void ButtonAddURLOnAction(ActionEvent event) throws URISyntaxException {
        FileManagement file = new FileManagement(TxtFieldEnterUrl.getText());
        TxtFieldEnterUrl.clear();
        AnchorPaneNewDownload.setVisible(false);
    }
    
}

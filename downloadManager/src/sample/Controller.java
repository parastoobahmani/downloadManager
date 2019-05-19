package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public ComboBox<String> downloadComboBox = new ComboBox<>();



    public void GoToDownloaded(MouseEvent mouseEvent) {


    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        downloadComboBox.getItems().addAll("Compressed", "Document", "Media", "Other");

    }
//    public void downloadComboBox(MouseEvent mouseEvent) {
//    }
}

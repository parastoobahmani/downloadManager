
package pr3;

import Model.Category;
import static Model.Category.Categories;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Pr3 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/MainMenu.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Categories.add(new Category("C:\\Users\\Arman\\Desktop\\Download Manager\\Others", "Others"));
        Categories.add(new Category("C:\\Users\\Arman\\Desktop\\Download Manager\\Documents", "Documents", "doc pdf docx"));
        Categories.add(new Category("C:\\Users\\Arman\\Desktop\\Download Manager\\Compressed", "Compressed", "zip rar"));
        Categories.add(new Category("C:\\Users\\Arman\\Desktop\\Download Manager\\Media", "Media", "mp4 mp3"));
        launch(args);
    }
    
}

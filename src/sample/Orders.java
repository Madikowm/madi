package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class Orders {

    @FXML
    private TextArea text;

    @FXML
    private Button backButton1;

    @FXML
    void initialize() {
        backButton1.setOnAction(event -> {
            backButton1.getScene().getWindow().hide();

            FXMLLoader loader3=new FXMLLoader();
            loader3.setLocation(getClass().getResource("/sample/Design/MainMenu.fxml"));

            try{
                loader3.load();
            }catch (IOException e){
                e.printStackTrace();
            }
            Parent root3 = loader3.getRoot();
            Stage stage=new Stage();
            stage.setScene(new Scene(root3));
            stage.showAndWait();
        });
    }
}

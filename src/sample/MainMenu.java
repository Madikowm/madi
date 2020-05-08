package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenu {

    @FXML
    private Button menuButton;

    @FXML
    private Button SaleButton;

    @FXML
    private Button cartButton;

    @FXML
    private Button exitButton;

    @FXML
    void initialize() {
        exitButton.setOnAction(event -> {
            exitButton.getScene().getWindow().hide();
            FXMLLoader loader2=new FXMLLoader();
            loader2.setLocation(getClass().getResource("/sample/Design/sample.fxml"));
            try{
                loader2.load();
            }catch (IOException e){
                e.printStackTrace();
            }
            Parent root2 = loader2.getRoot();
            Stage stage=new Stage();
            stage.setScene(new Scene(root2));
            stage.show();
        });
        menuButton.setOnAction(event -> {
            menuButton.getScene().getWindow().hide();
            FXMLLoader loader2=new FXMLLoader();
            loader2.setLocation(getClass().getResource("/sample/Design/Menu.fxml"));
            try{
                loader2.load();
            }catch (IOException e){
                e.printStackTrace();
            }
            Parent root2 = loader2.getRoot();
            Stage stage=new Stage();
            stage.setScene(new Scene(root2));
            stage.show();
        });
        cartButton.setOnAction(event -> {
            cartButton.getScene().getWindow().hide();
            FXMLLoader loader2=new FXMLLoader();
            loader2.setLocation(getClass().getResource("/sample/Design/Orders.fxml"));
            try{
                loader2.load();
            }catch (IOException e){
                e.printStackTrace();
            }
            Parent root2 = loader2.getRoot();
            Stage stage=new Stage();
            stage.setScene(new Scene(root2));
            stage.show();
        });
    }
}

package sample;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    @FXML
    private Button SignInButton;

    @FXML
    private Button SignUpButton;

    @FXML
    void initialize() {
        SignInButton.setOnAction(event -> {
            String loginText = login.getText().trim();
            String loginPassword = password.getText().trim();

            if(!loginText.equals("") && !loginPassword.equals("")){
                loginUser(loginText, loginPassword);
            }
            else
                System.out.println("Error");
        });

        SignUpButton.setOnAction(event -> {
            OpenNewWind1("/sample/Design/signup.fxml");
        });
    }

    private void loginUser(String loginText, String loginPassword) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUsername(loginText);
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);

        int count = 0;

        try {
            while (result.next()) {
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (count >= 1) {
            OpenNewWind("/sample/Design/MainMenu.fxml");
        }
    }
    public void OpenNewWind(String window){
        SignInButton.getScene().getWindow().hide();

        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try{
            loader.load();
        }catch (IOException e){
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage=new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
    public void OpenNewWind1(String window1){
        SignUpButton.getScene().getWindow().hide();

        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource(window1));

        try{
            loader.load();
        }catch (IOException e){
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage=new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}

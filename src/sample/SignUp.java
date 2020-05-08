package sample;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUp {


    @FXML
    private TextField login1;

    @FXML
    private PasswordField password1;

    @FXML
    private Button SaveButton;

    @FXML
    private TextField name;

    @FXML
    private CheckBox checkbox1;

    @FXML
    private CheckBox checkbox2;

    @FXML
    void initialize(){

        SaveButton.setOnAction(event -> {
            signUpNewUser();
            onw("/sample/Design/sample.fxml");
        });
    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String fullName = name.getText();
        String userName = login1.getText();
        String password = password1.getText();
        String gender = "";
        if(checkbox1.isSelected())
            gender="MAN";
        else
            gender="WOMAN";

        User user = new User(fullName, userName, password, gender);

        dbHandler.signUpUser(user);
    }
    public void onw(String w){
        SaveButton.getScene().getWindow().hide();

        FXMLLoader loader1=new FXMLLoader();
        loader1.setLocation(getClass().getResource(w));

        try{
            loader1.load();
        }catch (IOException e){
            e.printStackTrace();
        }
        Parent root1 = loader1.getRoot();
        Stage stage=new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }

}

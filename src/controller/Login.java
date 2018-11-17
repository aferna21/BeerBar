package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable
{

    public AnchorPane paneLogin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void buttonLoginClicked(ActionEvent actionEvent)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/User.fxml"));
            Parent userRoot = fxmlLoader.load();
            Stage userStage = new Stage();
            userStage.setTitle("Login");
            userStage.setScene(new Scene(userRoot));
            //userStage.setResizable(false);
            userStage.show();

            Stage loginStage = (Stage) paneLogin.getScene().getWindow();
            loginStage.close();
        }
        catch (Exception e)
        {
            System.out.println("Can not load the User Window");
        }
    }
}

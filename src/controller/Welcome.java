package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Welcome implements Initializable
{
    public AnchorPane paneWelcome;

    /*public Welcome() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Wlcome.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Welcome");
        stage.setScene(new Scene(root, 600, 400));
        stage.setResizable(false);
        stage.show();
    }*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void buttonLoginClicked(ActionEvent actionEvent)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/Login.fxml"));
            Parent loginRoot = fxmlLoader.load();
            Stage loginStage = new Stage();
            loginStage.setTitle("Login");
            loginStage.setScene(new Scene(loginRoot));
            loginStage.setResizable(false);
            loginStage.show();

            Stage welcomeStage = (Stage) paneWelcome.getScene().getWindow();
            welcomeStage.close();
        }
        catch (Exception e)
        {
            System.out.println("Can not load the Login Window");
        }
    }
}

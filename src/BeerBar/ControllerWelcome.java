package BeerBar;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerWelcome implements Initializable
{
    public AnchorPane paneWelcome;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void buttonLoginClicked(ActionEvent actionEvent)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("Login.fxml"));
            Parent loginRoot = fxmlLoader.load();
            Stage loginStage = new Stage();
            loginStage.setTitle("Login");
            loginStage.setScene(new Scene(loginRoot));
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

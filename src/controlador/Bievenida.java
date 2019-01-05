package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Bievenida implements Initializable
{
    public AnchorPane paneWelcome;

    /*public Bievenida() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Wlcome.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Bievenida");
        stage.setScene(new Scene(root, 600, 400));
        stage.setResizable(false);
        stage.show();
    }*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void buttonEnterClicked(ActionEvent actionEvent)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/vista/Acceso.fxml"));
            Parent loginRoot = fxmlLoader.load();
            Stage loginStage = new Stage();
            loginStage.setTitle("Acceso");
            loginStage.setScene(new Scene(loginRoot));
            loginStage.setResizable(false);
            loginStage.show();

            Stage welcomeStage = (Stage) paneWelcome.getScene().getWindow();
            welcomeStage.close();
        }
        catch (Exception e)
        {
            System.out.println("Fallo al cargar la ventana de Bienvenida");
        }
    }
}

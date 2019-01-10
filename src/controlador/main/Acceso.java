package controlador.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Acceso implements Initializable
{

    public AnchorPane paneLogin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void pulsadoBotonAcceso(ActionEvent actionEvent)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/vista/usuario/Usuario.fxml"));
            Parent raizUsuario = fxmlLoader.load();
            Stage escenarioUsuario = new Stage();
            escenarioUsuario.setTitle("Usuario");
            escenarioUsuario.setScene(new Scene(raizUsuario));
            escenarioUsuario.setMaximized(true);
            escenarioUsuario.show();

            Stage loginStage = (Stage) paneLogin.getScene().getWindow();
            loginStage.close();
        }
        catch (Exception e)
        {
            System.out.println("Fallo al cargar la ventana del usuario");
        }
    }
}

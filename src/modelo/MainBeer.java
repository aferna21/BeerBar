package modelo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainBeer extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/vista/main/Bienvenida.fxml"));
        primaryStage.setTitle("Bievenida");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setResizable(false);
        primaryStage.show();

        //new Bievenida();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

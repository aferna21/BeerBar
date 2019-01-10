package controlador.usuario;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Usuario {

    public ScrollPane scrollBotones;
    public AnchorPane cristalScrollBotones;
    public VBox vboxBotones;
    public Pane cristalUsuario;

    public void Usuario()
    {
        Button holaBoton = new Button("Hola");
        holaBoton.setVisible(true);
        //this.cristalScrollBotones.setTopAnchor(holaBoton, 10.0);
        this.cristalScrollBotones.getChildren().add(holaBoton);
    }
}

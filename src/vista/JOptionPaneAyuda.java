package vista;

import javax.swing.*;

public class JOptionPaneAyuda extends JOptionPane {

    JPanel panelActual;

    public JOptionPaneAyuda(JPanel panelActual){

        this.panelActual = panelActual;
    }

    public void muestraAyudaBienvenida(){

        String mensaje =
                "Esta es la pantalla de inicio del programa. Pulsa el boton 'Entrar'\n" +
                "para acceder a la pantalla de inicio de sesion. La primera vez\n" +
                "que se inicie el programa se creara un usuario administrador con nombre\n" +
                        "'admin' y contrasena 'admin'.";

        this.showMessageDialog(panelActual, mensaje, "Ayuda ventana bienvenida", JOptionPane.INFORMATION_MESSAGE);
    }

    public void muestraAyudaInicioSesion(){

        String mensaje =
                "Esta es la pantalla de inicio de sesion. Introduce un usario y contrasena\n" +
                        "y pulsa el boton 'Iniciar sesion' para poder acceder. Dependiendo de si se es administrador\n" +
                        "o no se abrira una pantalla u otra. Recuerda que para poder acceder, el administrador\n" +
                        "ha tenido que haber registrado tu usario con contrasena en la aplicacion.";

        this.showMessageDialog(panelActual, mensaje, "Ayuda ventana inicio sesion", JOptionPane.INFORMATION_MESSAGE);
    }

    public void muestraAyudaUsuario(){

        String mensaje =
                "Esta es la pantalla principal del usuario. Pulsa uno de los dos botones\n" +
                        "para acceder a las pantallas tanto de notas como de transacciones, respectivamente. En ellas\n" +
                        "se encuentra la funcionalidad especifica de cada una (como redactar una nueva nota o transaccion,\n" +
                        "ver las notas recibidas, etc).";

        this.showMessageDialog(panelActual, mensaje, "Ayuda ventana usuario", JOptionPane.INFORMATION_MESSAGE);
    }

    public void muestraAyudaNotasUsuario(){
        String mensaje =
                "Esta es la pantalla de las notas del usuario. Accede al menu para\n" +
                        "seleccionar entre las opciones:\n" +
                        "1. Escribir nota: redactar una nueva nota y enviarsela al usuario seleccionado.\n" +
                        "2. Ver notas recibidas: visualizar las notas recibidas por otros usuarios.\n" +
                        "3. Ver notas enviadas: igual que la anterior pero para las enviadas hacia otros usuarios.";

        this.showMessageDialog(panelActual, mensaje, "Ayuda ventana notas usuario", JOptionPane.INFORMATION_MESSAGE);
    }

    public void muestraAyudaTransaccionesUsuario(){
        String mensaje =
                "Esta es la pantalla de las transacciones del usuario. Accede al menu para\n" +
                        "seleccionar entre las opciones:\n" +
                        "1. Introducir una venta: anadir una nueva venta con un concepto opcional a la jornada.\n" +
                        "2. Introducir un gasto: igual que el anterior pero para un gasto.\n" +
                        "3. Ver transacciones: visualizar el historial de transacciones del dia.";

        this.showMessageDialog(panelActual, mensaje, "Ayuda ventana transacciones usuario", JOptionPane.INFORMATION_MESSAGE);
    }

    public void muestraAyudaAdministrador(){
        String mensaje =
                "Esta es la pantalla de la ventana de Administrador. Pulsa uno de los tres botones\n" +
                        "para acceder a las pantallas de notas, transacciones o gestion de usuarios.\n" +
                        "En ellas se encuentra la funcionalidad especifica de cada una.";

        this.showMessageDialog(panelActual, mensaje, "Ayuda ventana administrador", JOptionPane.INFORMATION_MESSAGE);
    }

    public void muestraAyudaNotasAdministrador(){
        String mensaje =
                "Esta es la pantalla de las notas del administrador. Accede al menu para:\n" +
                        "1. Escribir nota: redactar una nota hacia otro usuario.\n" +
                        "2. Ver notas recibidas: visualizar las notas recibidas de otros usuarios.\n" +
                        "3. Ver notas enviadas: igual que el anterior pero para las enviadas.\n" +
                        "4. Ver todas las notas almacenadas en el sistema.";

        this.showMessageDialog(panelActual, mensaje, "Ayuda ventana notas administrador", JOptionPane.INFORMATION_MESSAGE);
    }

    public void muestraAyudaTransaccionesAdministrador(){
        String mensaje =
                "Esta es la pantalla de las notas del administrador. Accede al menu para:\n" +
                        "1. Introducir una venta: anadir una nueva venta con un concepto opcional a la jornada.\n" +
                        "2. Introducir un gasto: igual que el anterior pero para un gasto.\n" +
                        "3. Ver transacciones: visualizar las transacciones del dia.\n" +
                        "4. Ver todas las transacciones: visualizar todas las transacciones almacenadas\n" +
                        "en el sistema.";

        this.showMessageDialog(panelActual, mensaje, "Ayuda ventana transacciones administrador", JOptionPane.INFORMATION_MESSAGE);
    }

    public void muestraAyudaGestorUsuarios(){
        String mensaje =
                "Esta es la pantalla del gestor de usuarios. Solo puede ser abierta por el administrador.\n" +
                        "Accede al menu para:\n" +
                        "1. Anadir a un usuario: crear un nuevo usuario y anadirlo al sistema.\n" +
                        "2. Eliminar a un usuario: eliminar un usuario ya creado del sistema.\n" +
                        "3. Ver todos los usuarios: visualizar los usuarios del sistema.\n";

        this.showMessageDialog(panelActual, mensaje, "Ayuda ventana gestor de usuarios", JOptionPane.INFORMATION_MESSAGE);
    }
}

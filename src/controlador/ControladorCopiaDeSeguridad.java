package controlador;

import java.io.*;

public class ControladorCopiaDeSeguridad {

    public void crearCopiaDeSeguridad(String ruta){
        try {
            Process proceso = Runtime.getRuntime().exec("mysqldump -u inso -pinso beerbar");
            InputStream is = proceso.getInputStream();
            FileOutputStream fos = new FileOutputStream(ruta);
            byte[] buffer = new byte[1000];

            int bit = is.read(buffer);
            while (bit > 0) {
                fos.write(buffer, 0, bit);
                bit = is.read(buffer);
            }
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void cargarCopiaDeSeguridad(String ruta){
        try {
            Process proceso = Runtime.getRuntime().exec("mysql -u inso -pinso beerbar");

            OutputStream os = proceso.getOutputStream();
            FileInputStream archivo = new FileInputStream(ruta);
            byte[] buffer = new byte[1000];

            int bit = archivo.read(buffer);
            while (bit > 0) {
                os.write(buffer, 0, bit);
                bit = archivo.read(buffer);
            }

            os.flush();
            os.close();
            archivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package controlador;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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
}

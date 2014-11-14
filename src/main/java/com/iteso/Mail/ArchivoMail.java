package com.iteso.Mail;

import java.io.*;

public class ArchivoMail {

    public java.lang.String escribirEnArchivoPass;

    public boolean escribirEnArchivoPass() throws IOException {
        FileWriter escribir_archivo = new FileWriter(
                "/home/smot/master_Jonas/src/main/java/com/iteso/Mail/Mail.txt");
        BufferedWriter escribir_buffer = new BufferedWriter(escribir_archivo);


        String mensaje = "MMMM";

        escribirEnArchivoPass=mensaje;
        try {

            escribir_buffer.write(escribirEnArchivoPass);
            escribir_buffer.newLine();

            escribir_buffer.flush();
            escribir_buffer.close();

        } catch (Exception e) {

            System.out.println(e);

            return false;

        }

        return true;

    }

    public void crearArchivoPass() {
        String NombreArchivo = "/home/smot/master_Jonas/src/main/java/com/iteso/Mail/Mail.txt";
        File Archivo = new File(NombreArchivo);

        try {

            if (Archivo.exists() == false) {
            } else {
                Archivo.createNewFile();
            }

        } catch (Exception e) {

            System.out.println("No se ha podido crear el archivo");

        }
    }

}

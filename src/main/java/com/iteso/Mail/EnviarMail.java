package com.iteso.Mail;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class EnviarMail {

    static final EnviarMail sant = new EnviarMail();
    static final ArchivoMail smot = new ArchivoMail();
    public static void main(String[] args) {
    sant.Mail();
    smot.crearArchivoPass();

        try {
            smot.escribirEnArchivoPass();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Mail() {
        try {
            //para quien es el correo
            String mailto = "hmpm3000@hotmail.com";
            //Subject
            String subjectTo ="Si mis calculos no me fallan";
            //nombre del usuario
            String userto = "Pastor";
            //cuerpo del correo
            String lastnews ="HOY PISTIAMOS Last news from Quinelero 2014";
            // Propiedades de la conexi�n
            Properties props = new Properties();
            props.put("mail.smtp.ssl.trust", "smtp.live.com");
            props.setProperty("mail.smtp.host", "smtp.live.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "quineleroiteso@hotmail.com");
            props.setProperty("mail.smtp.auth", "true");



            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);
            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("quineleroiteso@hotmail.com"));
            // System.out.println("------"+corr);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(
                    mailto));
            message.setSubject(subjectTo);
            //message.setText("MMMM");

            message.setText("Last News Quinelero\nSaludos"+userto+"\n"+"\n"+lastnews);
            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("quineleroiteso@hotmail.com", "Quineler0iteso");
            t.sendMessage(message, message.getAllRecipients());
            // Cierre.
            t.close();
        } catch (Exception e) {
            System.out.println("Mail -1");
            System.out.println(e);

        }
    }



}
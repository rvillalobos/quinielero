package com.iteso.Mail;

import com.iteso.sweng.Login.QueryHandler;
import com.iteso.sweng.Login.QueryHandlerDummy;
import com.iteso.sweng.Login.QueryHandlerMySQL;
import org.omg.CORBA.ORBPackage.InvalidName;
import sun.security.ssl.Debug;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * User: Jonas
 * Date: 30/11/2014
 * Time: 05:38 PM
 */
public class MailSender {

    public static void sendEmailToUser(String userName,
                                       String subject,
                                       String body){

        QueryHandler queryHandler = new QueryHandlerMySQL();

        // Verify User exists
        if(queryHandler.isUserRegistered(userName) == true) {
            String userEmail;
            // Check if user has the "PD_boReceiveEmail" enabled (TRUE)
            if(queryHandler.getEmailNotificationConfiguration(userName) == true){
                // If its true: Extract User's Email
                // then send email
                try {
                    userEmail = queryHandler.getUserEmail(userName);
                    System.out.print("Test User Name = " + userName +
                                     "User Email = " + userEmail);

                    sendEmail(userName,
                              userEmail,
                              subject,
                              body);

                } catch (InvalidName ex)
                {
                    // TODO: Inconsistency in the DB
                    return;
                }

            }
            else {
                // User doesn´t want to receive Emails...DO NOTHING
            }
        }
        else{
            // TODO: Notify that the user is not found in the DB
        }

    }


    public static void deactivateEmailNotificationsForUser(String userName){
        QueryHandler queryHandler = new QueryHandlerMySQL();

        queryHandler.removeEmailNotifications(userName);
    }

    public static void activateEmailNotificationsForUser(String userName){
        QueryHandler queryHandler = new QueryHandlerMySQL();

        queryHandler.activeEmailNotifications(userName);
    }


    private static void sendEmail(String userName,
                                  String userEmail,
                                  String subject,
                                  String body)
    {
        // TODO: Implement Email sending code
        try {
            // Setting receiver
            String mailto = userEmail;
            // Email's Subject
            String subjectTo = subject;
            // User's Name
            String userto = userName;
            //cuerpo del correo
            String lastnews = body;

            // Connecting to Quinieles's mail (Sender)
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
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(
                    mailto));
            message.setSubject(subjectTo);
            message.setText(body);

            // Sending Email
            Transport transport = session.getTransport("smtp");
            transport.connect("quineleroiteso@hotmail.com", "Quineler0iteso");
            transport.sendMessage(message, message.getAllRecipients());
            // Cierre.
            transport.close();
        } catch (Exception e) {
            System.out.println("UPS! something went wrong while trying to send the email");
            System.out.println(e);

        }
    }

}

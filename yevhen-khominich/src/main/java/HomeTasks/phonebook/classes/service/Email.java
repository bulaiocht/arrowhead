<<<<<<< HEAD
package HomeTasks.phonebook.classes.service;

import HomeTasks.phonebook.classes.configs.EmailConfig;
import HomeTasks.phonebook.classes.configs.PhoneBookConfig;
=======
package classes.service;

import classes.configs.EmailConfig;
import classes.configs.PhoneBookConfig;

>>>>>>> yevhen-khominich
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class Email {

    private static Properties properties = EmailConfig.EMAIL_PROPERTIES;

    public static void sendTo(String email)  {
        Session mailSession = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        EmailConfig.USER,
                        EmailConfig.PASS);
            }
        });


        try {
            MimeMessage message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(EmailConfig.USER));
            message.setSubject(EmailConfig.MESSAGE_SUBJECT);
            message.setText(EmailConfig.MESSAGE_TEXT);

            BodyPart messageBodyPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();

            multipart.addBodyPart(messageBodyPart);
            DataSource source = new FileDataSource(PhoneBookConfig.PATH_TO_FILE);

            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(EmailConfig.MESSAGE_FILE_NAME);
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);


            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            Transport tr = mailSession.getTransport();

            tr.connect(EmailConfig.USER, EmailConfig.PASS);
            tr.sendMessage(message, message.getAllRecipients());
            tr.close();
        }
        catch (MessagingException e){
            e.printStackTrace();
        }

    }

}

package ua.com.library.serviceImpl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ua.com.library.service.MailSenderService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by admin on 06.12.2016.
 */
@Service
public class MailSenderImpl implements MailSenderService{

    private final static String USERNAME = "sashanettm@gmail.com";
    private final static String PASSWORD = "21zopa10banan";

    @Async
    public void sendMail(String content, String mailBody, String email) {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        properties.setProperty("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        Session session = Session.getDefaultInstance(properties,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(USERNAME, PASSWORD);
                    }
                });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(
                    email));
            message.setSubject(content, "UTF-8");
            message.setText(mailBody);
            synchronized (this) {
                Transport.send(message);
            }
        } catch (MessagingException mex) {
            mex.printStackTrace();
            System.out.println("You have some problems with connection!");
        }
    }

}
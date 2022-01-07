
package StudentServices;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import StudentModels.ModelMessage;

public class Mail {
    
    public static void sendMail(String recipient, String code) throws MessagingException {
        
        
        Properties properties = new Properties();
        
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myEmail = "******@gmail.com";
        String password = "******";
        
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myEmail, password);
            }
        });
        
        Message message = prepareMessage(session, myEmail, recipient, code);
        
    }
    
    public static Message prepareMessage(Session session, String myemail, String recipient, String code) throws MessagingException {
        ModelMessage ms = new ModelMessage(false, "");
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myemail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Verify Code");
            message.setText(code);
            Transport.send(message);
            ms.setSuccess(true);
            return message;
        } catch (AddressException ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}

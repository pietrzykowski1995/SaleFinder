package pl.atos.finalworkshop.email;

public interface EmailSender {

    void sendEmail(String to, String subject, String content);
}

package service;

public interface NotificationService {

    void sendEmail(String to, String message);
    void sendSMS(String to, String message);

}

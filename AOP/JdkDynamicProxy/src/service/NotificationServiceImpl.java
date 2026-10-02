package service;

public class NotificationServiceImpl implements NotificationService {
    @Override
    public void sendEmail(String to, String message) {
        System.out.println("send : " + message +" to:" + to);
    }

    @Override
    public void sendSMS(String to, String message) {
        System.out.println("send : " + message +" to:" + to);
    }
}

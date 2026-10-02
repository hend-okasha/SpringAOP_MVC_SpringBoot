import service.NotificationService;
import service.NotificationServiceImpl;

import java.lang.reflect.Proxy;


public class Main {
    public static void main(String[] args) {

        NotificationService real = new NotificationServiceImpl();
        NotificationService proxy = (NotificationService) Proxy.newProxyInstance(
                NotificationService.class.getClassLoader(),
                new Class[]{NotificationService.class},
                new LoggingHandler(real)
        );
        proxy.sendEmail("hend@gmail.com" , "welcome");
        proxy.sendSMS("01012345678", "Your verification code is 1234"
        );
    }
}
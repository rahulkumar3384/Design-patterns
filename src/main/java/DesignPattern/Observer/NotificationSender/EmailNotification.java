package DesignPattern.Observer.NotificationSender;

import DesignPattern.Observer.Interfaces.NotificationService;

public class EmailNotification implements NotificationService {

    @Override
    public  void sendNotification(String email, String message) {
        System.out.println("Sending email to " + email + " with message: " + message);
    }
}

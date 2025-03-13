package DesignPattern.Observer.NotificationSender;

import DesignPattern.Observer.Interfaces.NotificationService;

public class SmsNotification implements NotificationService {
    @Override
    public void sendNotification(String mobilenumber, String message) {
        System.out.println("Sending SMS to " + mobilenumber + " with message: " + message);
    }

}
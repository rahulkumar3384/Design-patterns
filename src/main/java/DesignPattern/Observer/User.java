package DesignPattern.Observer;

import DesignPattern.Observer.Interfaces.Observable;
import DesignPattern.Observer.Interfaces.Observer;
import DesignPattern.Observer.NotificationSender.EmailNotification;
import DesignPattern.Observer.NotificationSender.SmsNotification;

import java.util.HashMap;
import java.util.Map;

public class User implements Observer {
   private String email;
   private String username;
   private Map<Observable, Integer> notificationCountMap = new HashMap<>();
   private int numberofNotifications = 0;
   private static final int MAX_NOTIFICATIONS = 1;
   private String usermobilenumber ;
   public User(String username ,String email, String usermobilenumber) {
         this.username = username;
         this.email = email;
         this.usermobilenumber = usermobilenumber;
    }

    public void notifyMe(Observable product) {
        product.addObserver(this);
        System.out.println("Hello " + this.email + ", " +this.usermobilenumber + " ,"+ ((AmazonProduct) product).getProductName() + " is not available on Amazon. We will notify you when it is available.");
    }

    @Override
    public void update(Observable product) {
        notificationCountMap.put(product, notificationCountMap.getOrDefault(product, 0) + 1);
        if (notificationCountMap.get(product) > MAX_NOTIFICATIONS)
            stopNotifyingMe(product);
        else {
            if(this.email !=null) {
                EmailNotification emailNotification = new EmailNotification();
                emailNotification.sendNotification(this.email, ((AmazonProduct) product).getProductName() + " is now available on Amazon.");
            }
            if(this.email !=null) {
                SmsNotification smsNotification = new SmsNotification();
                smsNotification.sendNotification(this.usermobilenumber, ((AmazonProduct) product).getProductName() + " is now available on Amazon.");
            }
        }
    }

    private void stopNotifyingMe(Observable product) {
        product.removeObserver(this);
        System.out.println("Hello " + this.username + ", you will no longer be notified when " + ((AmazonProduct)product).getProductName() + " is available on Amazon. Please subscribe again to get notified.");

    }
}

package DesignPattern.Observer;

public class SmsNotification implements Observer {
    private String phoneNumber;
    private int numberofNotifications = 0;
    private static final int MAX_NOTIFICATIONS = 1;

    public SmsNotification(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update(Observable product) {
        this.numberofNotifications++;
        if (this.numberofNotifications > MAX_NOTIFICATIONS)
            stopNotifyingMe(product);
        else
            System.out.println("Hello " + phoneNumber + ", " + ((AmazonProduct) product).getProductName() + " is now available on Amazon.");
    }

    public void notifyMe(Observable product) {
        product.addObserver(this);
        System.out.println("Hello " + phoneNumber + ", " + ((AmazonProduct) product).getProductName() + " is not available on Amazon. We will notify you when it is available.");
    }

    public void stopNotifyingMe(Observable product) {
        product.removeObserver(this);
        System.out.println("Hello " + phoneNumber + ", you will no longer be notified when " + ((AmazonProduct) product).getProductName() + " is available on Amazon.");
    }
}

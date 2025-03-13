package DesignPattern.Observer;

public class Customer implements Observer {
    private String customerName;
    private int numberofNotifications = 0;
    private static  final int MAX_NOTIFICATIONS = 1;
    public Customer(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void update(Observable product) {
        this.numberofNotifications++;
        if(this.numberofNotifications > MAX_NOTIFICATIONS)
            stopNotifyingMe(product);
        else
        System.out.println("Hello " + customerName + ", " + ((AmazonProduct)product).getProductName()  + " is now available on Amazon.");


    }

    public void notifyMe(Observable product) {
        product.addObserver(this);
        System.out.println("Hello " + customerName + ", " + ((AmazonProduct)product).getProductName() + " is not available on Amazon. We will notify you when it is available.");
    }
    public void stopNotifyingMe(Observable product) {
        product.removeObserver(this);
        System.out.println("Hello " + customerName + ", you will no longer be notified when " + ((AmazonProduct)product).getProductName() + " is available on Amazon.");
    }
}

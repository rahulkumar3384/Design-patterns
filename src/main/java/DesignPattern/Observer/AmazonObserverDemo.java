package DesignPattern.Observer;

public class AmazonObserverDemo {

    public static void main(String[] args) {


        AmazonProduct iphone = new AmazonProduct("Apple iPhone 12 Pro Max");
        AmazonProduct samsung = new AmazonProduct("Samsung Galaxy S21 Ultra");

        AmazonProduct holiProduct = new AmazonProduct("Holi Colors");
        AmazonProduct holiWaterGuns = new AmazonProduct("Holi Water Guns");

        AmazonProduct brownBread = new AmazonProduct("Brown Bread");


        Customer customer1 = new Customer("Rahul Sharma");
//        Customer customer2 = new Customer("Tanvi Sharma");

        customer1.notifyMe(iphone);
//        customer2.notifyMe(iphone);



        iphone.setInStock(true);
        iphone.setInStock(false);
        iphone.setInStock(true);






    }
}

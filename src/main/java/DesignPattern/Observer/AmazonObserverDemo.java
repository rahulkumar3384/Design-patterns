package DesignPattern.Observer;

public class AmazonObserverDemo {

    public static void main(String[] args) {


        AmazonProduct iphone = new AmazonProduct("Apple iPhone 12 Pro Max");
        AmazonProduct samsung = new AmazonProduct("Samsung Galaxy S21 Ultra");

        AmazonProduct holiProduct = new AmazonProduct("Holi Colors");
        AmazonProduct holiWaterGuns = new AmazonProduct("Holi Water Guns");

        AmazonProduct brownBread = new AmazonProduct("Brown Bread");

        User user1 = new User("Rahul Sharma" , "rahul.kumarkv1@gmail.com" , "1234567890");
        User user2 = new User("Virat Kohli" , "virat.kohli@outlook.in" , "9638521470");

        user1.notifyMe(iphone);
        user2.notifyMe(samsung);



        iphone.setInStock(true);
        samsung.setInStock(true);
        samsung.setInStock(false);
        iphone.setInStock(false);
        iphone.setInStock(true);
        samsung.setInStock(true);






    }
}

package DesignPattern.Observer;

import DesignPattern.Observer.Interfaces.Observable;
import DesignPattern.Observer.Interfaces.Observer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AmazonProduct implements Observable {
    private String productName;
    private List<Observer> observers = new CopyOnWriteArrayList<>();
    private boolean inStock = false;

    public AmazonProduct(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        if (inStock) {
            for (Observer observer : observers) {
                observer.update(this);
            }
        }
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
        if (inStock) {
            System.out.println("\n🔔 " + productName + " is now available! Notifying subscribed customers...");
            notifyObservers();
        } else {
            System.out.println("\n🔔 " + productName + " is out of stock!");
        }
    }
}

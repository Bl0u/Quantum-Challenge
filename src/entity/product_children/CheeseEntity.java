package entity.product_children;

import entity.ProductEntity;
import interfaces.Expirable;
import interfaces.Shippable;

import java.time.LocalDate;

public class CheeseEntity extends ProductEntity implements Expirable, Shippable, ShippingService {
    private final LocalDate expiryDate;
    private final double weight;
    private double shippingFees;

    public CheeseEntity(String name, double price, int quantity, LocalDate expiryDate, double weight, double shippingFees) {
        super(name, price, quantity);

        if (expiryDate == null) {
            throw new RuntimeException("Expiry date cannot be null");
        }
        this.expiryDate = expiryDate;
        this.weight = weight;
        setShippingFees(shippingFees) ;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public double getShippingFees() {
        return this.shippingFees;
    }

    @Override
    public void displayDetails() {
        System.out.println(getName() + " | Expires: " + expiryDate + " | Weight: " + weight + "kg");
    }

    public void setShippingFees(double shippingFees) {
        this.shippingFees = shippingFees;
    }
}
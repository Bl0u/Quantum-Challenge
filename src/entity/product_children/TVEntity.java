package entity.product_children;

import entity.ProductEntity;
import interfaces.Shippable;

public class TVEntity extends ProductEntity implements Shippable {
    private final double weight;
    private double shippingFees;


    public TVEntity(String name, double price, int quantity, double weight, double shippingFees) {
        super(name, price, quantity);
        this.weight = weight;
        this.shippingFees = shippingFees;
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
        System.out.println(getName() + " | Weight: " + weight + "kg");
    }
}

package entity.product_children;

import entity.ProductEntity;

public class MobileScratchCardEntity extends ProductEntity {

    public MobileScratchCardEntity(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public void displayDetails() {
        System.out.println(getName() + " | Digital Product");
    }
}

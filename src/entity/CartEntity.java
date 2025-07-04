package entity;


import interfaces.Expirable;
import interfaces.Shippable;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CartEntity {
    private  Map<ProductEntity, Integer> items = new HashMap<>();

    public Boolean add(ProductEntity product, int quantity) {
        String transactionId = generateTransactionId();
        if (product == null) {
            throw new RuntimeException("Product cannot be null");
        }

        if (quantity <= 0) {
            throw new RuntimeException("Quantity must be positive");
        }

        // check if sufficient amount is found
        product.decrementQuantity(quantity);


        if(product instanceof Expirable){
            //check if it's expired or not
            if(LocalDate.now().isAfter(((Expirable) product).getExpiryDate())){
                throw new RuntimeException("This item: " + product.getName() + " is expired!");
            }
        }




        int currentQuantity = items.getOrDefault(product, 0);
        items.put(product, currentQuantity + quantity);
        return true;
    }

    public void clear(){
        items.clear();
    }


    public  Map<ProductEntity, Integer> getItems() {
        return items;
    }

    private String generateTransactionId() {
        return "T_ID_" + java.util.UUID.randomUUID().toString();
    }

}

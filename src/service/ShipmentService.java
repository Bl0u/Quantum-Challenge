package service;

import interfaces.Shippable;
import interfaces.ShippingService;

import java.util.List;

public class ShipmentService {
    public void shipToCustomer(String address, List<ShippingService> items){
        //shipping to the customer's address
        System.out.println("The shippable items are sent to: " + address + "\n");
    }

}

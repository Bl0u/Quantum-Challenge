package service;

import interfaces.Shippable;

import java.util.List;

public class ShipmentService {
    public void shipToCustomer(String address, List<Shippable> items){
        //shipping to the customer's address
        System.out.println("The shippable items are sent to: " + address + "\n");
    }

}

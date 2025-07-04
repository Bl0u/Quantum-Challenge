package service;

import entity.CartEntity;
import entity.CustomerEntity;
import entity.ProductEntity;
import interfaces.Shippable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckoutService {
    public String checkOutReceipt(CustomerEntity customer, CartEntity cartEntity){
        if (cartEntity.getItems().isEmpty())
            throw new RuntimeException("The cart is empty, can't proceed to checkout!");


        List<Shippable> shippableItems = new ArrayList<>();
        Map<ProductEntity, Integer> items = cartEntity.getItems();

        String receiptShipmentNoticeSection = "** Shipment notice **\n";
        String receiptCheckoutReceiptSection = "** Checkout receipt **\n";
        String receipt = "";

        int currentQuantity;

        double totalWeight = 0;
        double currentWeightGrams = 0;

        double subtotal = 0;
        double shippingFees = 0;
        double currentPrice;
        double totalPayment;

        ShipmentService shipmentService = new ShipmentService();



        for(ProductEntity product: items.keySet()){
            currentQuantity = items.get(product);
            if (product instanceof Shippable){
                shippableItems.add((Shippable) product);
                receiptShipmentNoticeSection += currentQuantity + "x " + product.getName();
                currentWeightGrams = currentQuantity * ((Shippable) product).getWeight();
                receiptShipmentNoticeSection += "\t\t\t";
                if (currentWeightGrams < 1000)
                    receiptShipmentNoticeSection += String.format("%.1f", currentWeightGrams) + "gm";
                else
                    receiptShipmentNoticeSection += String.format("%.1f", (currentWeightGrams / 1000)) + "kg";
                receiptShipmentNoticeSection += "\n";
                shippingFees += ((Shippable) product).getShippingFees();
                totalWeight += ((Shippable) product).getWeight();
            }
            currentPrice = currentQuantity * product.getPrice();
            receiptCheckoutReceiptSection += currentQuantity + "x " + product.getName() + "\t\t\t" + currentPrice;
            receiptCheckoutReceiptSection += "\n";
            subtotal += currentPrice;
        }

        receipt += receiptShipmentNoticeSection + "Total package weight ";

        if (currentWeightGrams < 1000)
            receipt += String.format("%.1f", totalWeight) + "gm";
        else
            receipt += String.format("%.1f", (totalWeight / 1000)) + "kg";
        receipt += "\n\n" + receiptCheckoutReceiptSection ;


        totalPayment = subtotal + shippingFees;
        receipt += "--------------------------------\n";
        receipt += "Subtotal\t\t\t\t" + subtotal;
        receipt += "\n";
        receipt += "Shipping\t\t\t\t" + shippingFees;
        receipt += "\n";
        receipt += "Amount\t\t\t\t\t" + (totalPayment);
        customer.pay(totalPayment);
        receipt += "\n";
        receipt += "Current Balance\t\t\t" + customer.getBalance();



        shipmentService.shipToCustomer(customer.getAddress(), shippableItems);
        cartEntity.clear();
        return receipt;
    }
}

import entity.CartEntity;
import entity.CustomerEntity;
import entity.ProductEntity;
import entity.product_children.CheeseEntity;
import entity.product_children.MobileScratchCardEntity;
import entity.product_children.TVEntity;
import service.CheckoutService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        SystemTester.createProduct();

        // Critical Edge Cases
//        SystemTester.testUserWithEnoughBalance();
//        SystemTester.testCartAccomulation();

        // Main Test Cases
//        SystemTester.testCartEmpty();
//        SystemTester.testUserWithoutEnoughBalance();
//        SystemTester.testProductIsOutOfStock();
//        SystemTester.testAddExpiredProductToCart();
//        SystemTester.DefaultTestCase();
    }

    public static class SystemTester{
        public static void createProduct(){
            ProductEntity productExpirableShippable = new CheeseEntity("Cheddar Cheese", 10.0, 5, LocalDate.of(2025, 7, 15), 1200, 10);
        ProductEntity productExpirable = new TVEntity("Samsung TV", 500.0, 2, 15000.0, 30);
        ProductEntity card = new MobileScratchCardEntity("Scratch Card", 5.0, 100);
            System.out.println(productExpirableShippable);
            System.out.println(productExpirable);
            System.out.println(card);
        }
        public static void testUserWithEnoughBalance(){

            ProductEntity cheese = new CheeseEntity("Cheddar Cheese", 10.0, 5, LocalDate.of(2025, 7, 15), 1200, 10);
            ProductEntity tv = new TVEntity("Samsung TV", 500.0, 2, 15000.0, 30);
            ProductEntity card = new MobileScratchCardEntity("Scratch Card", 5.0, 100);

            CartEntity cart = new CartEntity() ;
            cart.add(cheese, 2) ;
            cart.add(tv, 1) ;
            cart.add(card, 3) ;

                CustomerEntity customer = new CustomerEntity(1L, "Peter", "peter@gmail.com", "Dummy st. cairo", 1000) ;
                CheckoutService checkoutService = new CheckoutService() ;
                System.out.println(checkoutService.checkOutReceipt(customer, cart)); ;



        }
        public static void testUserWithoutEnoughBalance(){
            ProductEntity cheese = new CheeseEntity("Cheddar Cheese", 10.0, 5, LocalDate.of(2025, 7, 15), 1200, 10);
            ProductEntity tv = new TVEntity("Samsung TV", 500.0, 2, 15000.0, 30);
            ProductEntity card = new MobileScratchCardEntity("Scratch Card", 5.0, 100);

            CartEntity cart = new CartEntity() ;
            cart.add(cheese, 2) ;
            cart.add(tv, 1) ;
            cart.add(card, 3) ;

                CustomerEntity customer = new CustomerEntity(1L, "Peter", "peter@gmail.com", "Dummy st. cairo", 50) ;
                CheckoutService checkoutService = new CheckoutService() ;
                System.out.println(checkoutService.checkOutReceipt(customer, cart)); ;



        }
        public static void testAddExpiredProductToCart(){
            ProductEntity cheese = new CheeseEntity("Cheddar Cheese", 10.0, 5, LocalDate.of(2023, 7, 15), 1200, 10);

            CartEntity cart = new CartEntity() ;
            cart.add(cheese, 2) ;
        }
        public static void testProductIsOutOfStock(){
            ProductEntity cheese = new CheeseEntity("Cheddar Cheese", 10.0, 2, LocalDate.of(2025, 7, 15), 1200, 10);
            ProductEntity tv = new TVEntity("Samsung TV", 500.0, 2, 15000.0, 30);
            ProductEntity card = new MobileScratchCardEntity("Scratch Card", 5.0, 100);

            CartEntity cart = new CartEntity() ;
            cart.add(cheese, 2) ;
            cart.add(tv, 1) ;
            cart.add(card, 5) ;

            CustomerEntity customer = new CustomerEntity(1L, "Peter", "peter@gmail.com", "Dummy st. cairo", 5000) ;

            CheckoutService checkoutService = new CheckoutService() ;
            String receipt = checkoutService.checkOutReceipt(customer, cart) ;
            System.out.println(receipt);

            cart.add(cheese, 2) ;
        }
        public static void testCartAccomulation(){
            ProductEntity cheese = new CheeseEntity("Cheddar Cheese", 10.0, 4, LocalDate.of(2025, 7, 15), 1200, 10);
            ProductEntity tv = new TVEntity("Samsung TV", 500.0, 2, 15000.0, 30);
            ProductEntity card = new MobileScratchCardEntity("Scratch Card", 5.0, 100);

            CartEntity cart = new CartEntity() ;
            cart.add(cheese, 2) ;
            cart.add(tv, 1) ;
            cart.add(card, 5) ;

            CustomerEntity customer = new CustomerEntity(1L, "Peter", "peter@gmail.com", "Dummy st. cairo", 1000) ;

            CheckoutService checkoutService = new CheckoutService() ;
            String receipt = checkoutService.checkOutReceipt(customer, cart) ;
            System.out.println(receipt);

            cart.add(cheese, 2) ;
            receipt = checkoutService.checkOutReceipt(customer, cart) ;
            System.out.println(receipt);
        }
        public static void testCartEmpty(){

            CartEntity cart = new CartEntity() ;
            CustomerEntity customer = new CustomerEntity(1L, "Peter", "peter@gmail.com", "Dummy st. cairo", 5000) ;

            CheckoutService checkoutService = new CheckoutService() ;
            String receipt = checkoutService.checkOutReceipt(customer, cart) ;
            System.out.println(receipt);
        }
        public static void DefaultTestCase(){
            ProductEntity cheese = new CheeseEntity("Cheddar Cheese", 10.0, 5, LocalDate.of(2025, 7, 15), 1200, 10);
            ProductEntity paramigiano = new CheeseEntity("Paramigiano", 19.99, 10, LocalDate.of(2026, 7, 15), 1200, 10);
            ProductEntity tv = new TVEntity("Samsung TV", 500.0, 2, 15000.0, 30);
            ProductEntity card = new MobileScratchCardEntity("Scratch Card", 5.0, 100);

            CartEntity cart = new CartEntity() ;
            cart.add(cheese, 2) ;
            cart.add(tv, 1) ;
            cart.add(card, 5) ;

            CustomerEntity customer = new CustomerEntity(1L, "Peter", "peter@gmail.com", "Dummy st. cairo", 5000) ;

            CheckoutService checkoutService = new CheckoutService() ;
            String receipt = checkoutService.checkOutReceipt(customer, cart) ;
            System.out.println(receipt);
        }
    }
}
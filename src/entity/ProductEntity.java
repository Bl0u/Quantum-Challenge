package entity;

public abstract class ProductEntity {
    private String name;
    private double price;
    private int quantity;

    public ProductEntity() {
    }

    public ProductEntity(String name, double price, int quantity) {
        this.name = name;
        setPrice(price);  // Use setter for validation
        setQuantity(quantity);  // Use setter for validation
    }

    public abstract void displayDetails();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        //check if price is a valid number
        if(price < 0)
            throw new RuntimeException("can't place price with negative value");
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        //check if quantity is a valid number
        if(quantity < 0)
            throw new RuntimeException("can't place quantity with negative value");
        this.quantity = quantity;
    }

    public int decrementQuantity(int soldQuantity){
        if(soldQuantity <= 0)
            throw new RuntimeException("can't sell zero or negative quantities");
        else if(soldQuantity > this.quantity)
            throw new RuntimeException("can't sell more than what is in the storage, which is: " + this.quantity);

        this.quantity -= soldQuantity;
        return this.quantity;
    }


    // this is done so that when we are using a hash map inside the cart, to compare against the name, not the object id as I faced bugs
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ProductEntity other = (ProductEntity) obj;
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode(); // Or use Objects.hash(name) if you want
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

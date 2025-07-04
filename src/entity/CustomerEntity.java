package entity;

public class CustomerEntity {
    private Long id;
    private String name;
    private String email;
    private String address;
    private double balance;

    public CustomerEntity(Long id, String name, String email, String address, double balance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.balance = balance;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getBalance() {
        return balance;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void pay(double amount) {
        if (amount <= this.balance) {
            balance -= amount;
        }
        else
            throw new RuntimeException("Customer's balance is not sufficient!");
    }

    @Override
    public String toString() {
        return name + " | Balance: $" + String.format("%.2f", balance);
    }
}


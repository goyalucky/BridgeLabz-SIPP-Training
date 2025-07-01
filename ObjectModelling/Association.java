package ObjectModelling;

class Bank {
    String name;

    public Bank(String name) {
        this.name = name;
    }

    public void openAccount(Customer customer) {
        System.out.println("Account opened for " + customer.name + " in " + name);
    }
}

class Customer {
    String name;
    double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void viewBalance() {
        System.out.println(name + "'s Balance: ₹" + balance);
    }
}

public class Association {
    public static void main(String[] args) {
        Bank bank = new Bank("State Bank of India");
        Customer customer1 = new Customer("Prashant", 5000);
        Customer customer2 = new Customer("Lucky", 10000);

        bank.openAccount(customer1);
        bank.openAccount(customer2);

        customer1.viewBalance();
        customer2.viewBalance();
    }
}

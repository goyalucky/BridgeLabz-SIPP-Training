package EncapPolyAbstInter;


interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited ₹" + amount + " to " + accountNumber);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount + " from " + accountNumber);
        } else {
            System.out.println("Insufficient balance in " + accountNumber);
        }
    }

    public abstract double calculateInterest();

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: ₹" + balance);
    }
}

class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate = 0.04;

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    public void applyForLoan(double amount) {
        System.out.println("Savings Account Loan Applied for ₹" + amount);
    }

    public double calculateLoanEligibility() {
        return getBalance() * 2;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate = 0.01;

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    public void applyForLoan(double amount) {
        System.out.println("Current Account Loan Applied for ₹" + amount);
    }

    public double calculateLoanEligibility() {
        return getBalance() * 1.5;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[4];
        accounts[0] = new SavingsAccount("SB001", "Alice", 50000);
        accounts[1] = new CurrentAccount("CA101", "Bob", 80000);
        accounts[2] = new SavingsAccount("SB002", "Charlie", 35000);
        accounts[3] = new CurrentAccount("CA202", "David", 120000);

        for (BankAccount acc : accounts) {
            acc.displayDetails();
            double interest = acc.calculateInterest();
            System.out.println("Calculated Interest: ₹" + interest);
            acc.deposit(5000);
            acc.withdraw(10000);

            if (acc instanceof Loanable) {
                Loanable loanable = (Loanable) acc;
                double eligibility = loanable.calculateLoanEligibility();
                System.out.println("Loan Eligibility: ₹" + eligibility);
                loanable.applyForLoan(eligibility / 2);
            }
        }
    }
}

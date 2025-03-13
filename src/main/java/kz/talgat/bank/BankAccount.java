package kz.talgat.bank;

public class BankAccount implements IBankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber + "\nAccount Holder Name: " + accountHolderName + "\nBalance: " + balance);
    }
}

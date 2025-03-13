package kz.talgat.bank;

/*
Create a BankAccount class with the following attributes:
accountNumber (String)
accountHolderName (String)
balance (double)

Implement the following methods in the BankAccount class:
deposit(double amount): Adds the specified amount to the balance.
withdraw(double amount): Deducts the specified amount from the balance. Ensure that the balance does not go below 0.
getBalance(): Returns the current balance.

displayAccountDetails(): Displays the account number, account holder name, and balance.
Create a Main class with a main method to test the BankAccount class:
Create an instance of BankAccount.
Perform a few deposit and withdrawal operations.
Display the account details after each operation.
*/


public interface IBankAccount {
    // Method to deposit money
    void deposit(double amount);
    // Method to withdraw money
    void withdraw(double amount);
    // Method to get the current balance
    double getBalance();
    // Method to display account details
    void displayAccountDetails();
}

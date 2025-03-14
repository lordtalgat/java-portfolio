package kz.talgat.atm;
/*
Create a class ATM with the following attributes:

balance (double): Represents the total balance in the ATM.

cashInventory (Map<Integer, Integer>): Represents the inventory of cash denominations (e.g., {100=10, 50=20, 20=50}
means 10 notes of 100,
20 notes of 100,
20 notes of 50,
and 50 notes of $20).
denominations = {100, 50, 20, 10, 5, 1}

Implement the following methods in the ATM class:
deposit(double amount): Adds the specified amount to the ATM's balance.
withdraw(double amount): Deducts the specified amount from the ATM's balance using the available cash denominations. Ensure that the ATM has enough cash and balance.
checkBalance(): Returns the current balance.
addCash(int denomination, int count): Adds cash of a specific denomination to the ATM's inventory.
displayMenu(): Displays a menu of options for the user (e.g., Deposit, Withdraw, Check Balance, Add Cash, Exit).
Create a Main class with a main method to simulate an ATM interaction:
Use a loop to repeatedly display the menu and process user input.
Handle invalid inputs gracefully (e.g., negative amounts, insufficient cash).

------------------------- Output ----------------------------------------
Welcome to the ATM!
1. Deposit
2. Withdraw
3. Check Balance
4. Add Cash
5. Exit
Enter your choice: 4
Enter denomination (e.g., 100, 50, 20): 100
Enter number of notes: 10
Cash added successfully.

1. Deposit
2. Withdraw
3. Check Balance
4. Add Cash
5. Exit
Enter your choice: 2
Enter amount to withdraw: 350
Dispensing:
- 3 x $100
- 1 x $50
Withdrawal successful. Current balance: $650.0

1. Deposit
2. Withdraw
3. Check Balance
4. Add Cash
5. Exit
Enter your choice: 5
Thank you for using the ATM. Goodbye!
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class ATM {
    private double balance;
    private TreeMap<Integer, Integer> cashInventory; // Key: Denomination, Value: Count

    // Constructor
    public ATM() {
        this.balance = 0;
        this.cashInventory = new TreeMap<>();
    }

    // Deposit money, ATM not set inserted money to over client it checked in bank
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Current balance: $" + balance);
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance. Current balance: $" + balance);
            return;
        }

        TreeMap<Integer, Integer> dispensedNotes = new TreeMap<>();
        double remainingAmount = amount;

        // Denominations in descending order
        int[] denominations = {100, 50, 20, 10, 5, 1};

        for (int denomination : denominations) {
            if (remainingAmount >= denomination && cashInventory.containsKey(denomination)) {
                int count = (int) (remainingAmount / denomination);
                int availableNotes = cashInventory.get(denomination);

                if (count > availableNotes) {
                    count = availableNotes;
                }

                dispensedNotes.put(denomination, count);
                remainingAmount -= count * denomination;
            }
        }

        if (remainingAmount > 0) {
            System.out.println("Insufficient cash in ATM to dispense the exact amount.");
            return;
        }

        // Update cash inventory and balance
        for (Map.Entry<Integer, Integer> entry : dispensedNotes.entrySet()) {
            int denomination = entry.getKey();
            int count = entry.getValue();
            cashInventory.put(denomination, cashInventory.get(denomination) - count);
        }

        balance -= amount;
        System.out.println("Dispensing:");
        for (Map.Entry<Integer, Integer> entry : dispensedNotes.entrySet()) {
            System.out.println("- " + entry.getValue() + " x $" + entry.getKey());
        }
        System.out.println("Withdrawal successful. Current balance: $" + balance);
    }

    // Check balance
    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }

    // Add cash to inventory
    public void addCash(int denomination, int count) {
        if (count > 0) {
            cashInventory.put(denomination, cashInventory.getOrDefault(denomination, 0) + count);
            balance += denomination * count;
            System.out.println("Cash added successfully.");
        } else {
            System.out.println("Invalid count. Please enter a positive value.");
        }
    }

    // Display menu
    public void displayMenu() {
        System.out.println("\nWelcome to the ATM!");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Add Cash");
        System.out.println("5. Exit");
    }
}
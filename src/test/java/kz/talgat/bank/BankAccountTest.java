package kz.talgat.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void testBankAccountShouldWorkCorrectly() {
        BankAccount account = new BankAccount("123456", "John Doe", 1000.0);

        account.displayAccountDetails();

        account.deposit(500.0);
        System.out.println("\nAfter depositing 500.0");
        account.displayAccountDetails();
        assertEquals(1500.0, account.getBalance());

        // Withdraw 200
        account.withdraw(200.0);
        System.out.println("\nAfter withdrawing 200.0");
        account.displayAccountDetails();
        assertEquals(1300.0, account.getBalance());
    }
}
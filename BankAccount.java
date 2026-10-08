import java.util.Scanner;

// Class to manage individual bank account data and operations
class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Parameterized constructor to initialize account details
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money if sufficient balance is available
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Transaction Failed: Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Successfully withdrew: ₹" + amount);
        }
    }

    // Method to return the current balance
    public double checkBalance() {
        return balance;
    }

    // Method to display account details and balance
    public void displayAccount() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: ₹" + balance);
        System.out.println("-----------------------");
    }
}

// Main class to drive the execution
public class BankManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read account information from the user
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Initial Balance: ");
        double initialBalance = scanner.nextDouble();

        // 2. Create the BankAccount object using the parameterized constructor
        BankAccount account = new BankAccount(accNum, name, initialBalance);

        // Display initial setup details
        account.displayAccount();

        // 3. Perform deposit transaction via helper method
        handleDeposit(account, scanner);

        // 4. Perform withdrawal transaction via helper method
        handleWithdrawal(account, scanner);

        // 5. Display final account information
        System.out.println("\nFinal State of Account:");
        account.displayAccount();

        scanner.close();
    }

    // Separate method to execute a deposit operation
    public static void handleDeposit(BankAccount account, Scanner scanner) {
        System.out.print("\nEnter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    // Separate method to execute a withdrawal operation
    public static void handleWithdrawal(BankAccount account, Scanner scanner) {
        System.out.print("\nEnter amount to withdraw: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }
}
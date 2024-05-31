import java.util.Random;

public class BankAccount {
    // MEMBER VARIABLES
    private String accountNumber;
    private double checkingBalance;
    private double savingsBalance;
    private static int accounts = 0;
    private static double totalMoney = 0;

    // CONSTRUCTOR
    public BankAccount(double initialCheckingBalance, double initialSavingsBalance) {
        this.checkingBalance = initialCheckingBalance;
        this.savingsBalance = initialSavingsBalance;
        this.accountNumber = generateAccountNumber();
        accounts++;
        totalMoney += (initialCheckingBalance + initialSavingsBalance);
    }

    // GETTERS
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public static int getAccounts() {
        return accounts;
    }

    public static double getTotalMoney() {
        return totalMoney;
    }

    // METHODS
    public void deposit(double amount, String accountType) {
        if (accountType.equalsIgnoreCase("checking")) {
            checkingBalance += amount;
        } else if (accountType.equalsIgnoreCase("savings")) {
            savingsBalance += amount;
        }
        totalMoney += amount;
    }

    public void withdraw(double amount, String accountType) {
        if (accountType.equalsIgnoreCase("checking")) {
            if (amount <= checkingBalance) {
                checkingBalance -= amount;
                totalMoney -= amount;
            } else {
                System.out.println("Insufficient funds in checking account.");
            }
        } else if (accountType.equalsIgnoreCase("savings")) {
            if (amount <= savingsBalance) {
                savingsBalance -= amount;
                totalMoney -= amount;
            } else {
                System.out.println("Insufficient funds in savings account.");
            }
        }
    }

    public void getBalance() {
        System.out.println("Checking Balance: $" + checkingBalance);
        System.out.println("Savings Balance: $" + savingsBalance);
    }

    // PRIVATE METHOD
    private String generateAccountNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}

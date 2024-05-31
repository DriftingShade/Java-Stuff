public class BankTest {
    public static void main(String[] args){
        // Create 3 bank accounts
        BankAccount account1 = new BankAccount(1000, 2000);
        BankAccount account2 = new BankAccount(500, 1500);
        BankAccount account3 = new BankAccount(2000, 3000);
        // Deposit Test
        System.out.println("\nBalances Before Deposits:");
        account1.getBalance();
        account2.getBalance();
        account3.getBalance();
        System.out.println("\nDepositing money into accounts!");
        account1.deposit(500, "checking");
        account2.deposit(1000, "savings");
        account3.deposit(1500, "checking");
        System.out.println("\nAvailable Balances After Deposits:");
        account1.getBalance();
        account2.getBalance();
        account3.getBalance();
        // Withdrawal Test
        System.out.println("\nWithdrawing money from accounts...");
        account1.withdraw(1500, "savings");
        account2.withdraw(100, "checking");
        account3.withdraw(1000, "checking");

        // Display balances after withdrawal
        System.out.println("\nBalances after withdrawal:");
        account1.getBalance();
        account2.getBalance();
        account3.getBalance();
        // Static Test (print the number of bank accounts and the totalMoney)
        System.out.println("\nNumber of bank accounts: " + BankAccount.getAccounts());
        System.out.println("Total money across all accounts: $" + BankAccount.getTotalMoney());
    }
}

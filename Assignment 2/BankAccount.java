import java.util.Scanner;
public class BankAccount {
    private int accnumber;
    private double accbalance;
    public BankAccount(int number, double balance) {
        this.accnumber = number;
        this.accbalance = balance;
    }
    public BankAccount(int number) {
        this(number, 0.0);
    }
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accnumber);
        System.out.println("Balance: Rs" + accbalance);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        BankAccount account1 = new BankAccount(accountNumber, initialBalance);
        System.out.print("Enter another account number: ");
        int accountNumber2 = scanner.nextInt();
        System.out.print("Enter initial balance: ");
        double initialBalance2 = scanner.nextDouble();
        BankAccount account2 = new BankAccount(accountNumber2, initialBalance2);
        account1.displayAccountInfo();
        account2.displayAccountInfo();
        scanner.close();
    }
}


import java.util.Scanner;

public class ATM {

  private Scanner scanner;

  private BankAccount account;

  public ATM(BankAccount account) {
    this.scanner = new Scanner(System.in);
    this.account = account;
  }

  public void displayMenu() {
    System.out.println("Welcome to the ATM machine!");
    System.out.println("Please choose an option:");
    System.out.println("1. Withdraw");
    System.out.println("2. Deposit");
    System.out.println("3. Check Balance");
    System.out.println("4. Exit");
  }

  public void executeOption(int option) {
    switch (option) {
      case 1:
        withdraw();
        break;
      case 2:
        deposit();
        break;
      case 3:
        checkBalance();
        break;
      case 4:
        System.out.println("Thank you for using the ATM machine. Goodbye!");
        System.exit(0);
        break;
      default:
        System.out.println("Invalid option. Please try again.");
    }
  }

  public void withdraw() {
    System.out.print("Enter the amount you want to withdraw: ");
    double amount = scanner.nextDouble();

    if (amount > 0 && amount <= account.getBalance()) {
      account.setBalance(account.getBalance() - amount);

      System.out.println("You have successfully withdrawn " + amount + " from your account.");
      System.out.println("Your new balance is: " + account.getBalance());
    } else {
      System.out.println("Invalid amount. Please make sure it is positive and within your balance.");
    }
  }

  public void deposit() {
    System.out.print("Enter the amount you want to deposit: ");
    double amount = scanner.nextDouble();

    if (amount > 0) {
      account.setBalance(account.getBalance() + amount);

      System.out.println("You have successfully deposited " + amount + " into your account.");
      System.out.println("Your new balance is: " + account.getBalance());
    } else {      System.out.println("Invalid amount. Please make sure it is positive.");
    }
  }

  public void checkBalance() {
    System.out.println("Your current balance is: " + account.getBalance());
  }
}

class BankAccount {

  private double balance;

  public BankAccount(double initialBalance) {
    this.balance = initialBalance;
  }

  public double getBalance() {
    return this.balance;
  }

  public void setBalance(double newBalance) {
    this.balance = newBalance;
  }
}

public class Test {

  public static void main(String[] args) {

    BankAccount account = new BankAccount(1000);

    ATM ATM = new ATM(account);

    while (true) {

      ATM.displayMenu();

      System.out.print("Enter your choice: ");
      int choice = ATM.scanner.nextInt();

      ATM.executeOption(choice);
    }
  }
}
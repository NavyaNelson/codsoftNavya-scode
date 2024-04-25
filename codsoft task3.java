import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class ATM {
    private BankAccount account;
    private double limitAmount = 0;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        Scanner read = new Scanner(System.in);
        while (true) {
            System.out.print("Welcome To Banking User Interface !! \n1- deposit\n2- withdraw\n3- check balance\n4- Exit\nEnter your Choice: ");
            int choice = read.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the Amount to deposit: ");
                    double depositAmount = read.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println(depositAmount + " was deposited successfully.");
                    break;
                case 2:
                    System.out.print("Enter the Amount to withdraw: ");
                    double withdrawAmount = read.nextDouble();
                    boolean withdrawn = account.withdraw(withdrawAmount);
                    if (withdrawn) {
                        limitAmount += withdrawAmount;
                        System.out.println(withdrawAmount + " was withdrawn successfully.");
                        System.out.println("Your current balance is: " + account.getBalance());
                        System.out.println("Your current limit is: " + limitAmount);
                    } else {
                        System.out.println("Insufficient funds. Withdrawal failed.");
                    }
                    break;
                case 3:
                    System.out.println("Your current balance is: " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Thank You for Visiting The User Interface for Banking :)");
                    return;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(0);
        ATM atm = new ATM(userAccount);
        atm.displayMenu();
    }
}

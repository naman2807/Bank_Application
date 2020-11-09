/*   Created By: IntelliJ Idea
 *    Author: Naman Agarwal (naman2807)
 *    Date: 09-11-2020
 *    Time: 08:32 AM
 *    Package: PACKAGE_NAME
 */


import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Bank bank = new Bank("Bank Of India");

    public static void main(String[] args) {

        System.out.println("Welcome to " + bank.getName());
        instructions();
        boolean flag = true;
        while (flag) {
            System.out.println("Enter Action Number: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    addBranch();
                    break;
                case 2:
                    addNewCustomer();
                    break;
                case 3:
                    addTransaction();
                    break;
                case 4:
                    displayRecord();
                    break;
                case 5:
                    instructions();
                    break;
            }
        }

    }

    public static void instructions() {
        System.out.println("Actions Available: ");
        System.out.println("0. Quit out of application");
        System.out.println("1. Add a new branch to the bank.");
        System.out.println("2. Add a new customer to an exhisting branch.");
        System.out.println("3. Add a transaction of a customer.");
        System.out.println("4. Display the record of a branch with transaction list as optional.");
        System.out.println("5. Show Instructions.");
    }

    public static void addBranch() {
        System.out.println("Please enter the new branch name: ");
        String branchName = scanner.nextLine();
        if (bank.addNewBranch(branchName)) {
            System.out.println(branchName + " successfully added.");
        } else {
            System.out.println("Branch: " + branchName + " already exhist.");
        }
    }

    public static void addNewCustomer() {
        System.out.println("Please enter the branch name: ");
        String branchName = scanner.nextLine();
        if (bank.findBranch(branchName) == null) {
            System.out.println(branchName + " does not exist. Couldn't add the customer.");
            return;
        } else {
            System.out.println("Please enter the new customer name: ");
            String customerName = scanner.nextLine();
            System.out.println("Please enter the initial amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            if (bank.addNewCustomer(branchName, customerName, amount)) {
                System.out.println("Account of Customer: " + customerName + " with initial transaction of "
                        + amount + " has been created in " + branchName + " branch of " + bank.getName());
            } else {
                System.out.println("Customer already exist. Cannot create account.");
            }
        }
    }

    public static void addTransaction() {
        System.out.println("Please enter the branch name: ");
        String branchName = scanner.nextLine();
        if (bank.findBranch(branchName) == null) {
            System.out.println(branchName + " does not exist. Couldn't add the transaction.");
            return;
        } else {
            System.out.println("Please enter the customer name: ");
            String customerName = scanner.nextLine();
            System.out.println("Please enter the amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            if (bank.addTransaction(branchName, customerName, amount)) {
                System.out.println("Transaction of "
                        + amount + " in account of Customer: " + customerName + " has been added in  " + branchName + " branch of " + bank.getName());
            } else {
                System.out.println("Customer does not exist. Cannot add transaction.");
            }
        }
    }

    public static void displayRecord() {
        System.out.println("Please enter the branch name: ");
        String branchName = scanner.nextLine();
        if (bank.findBranch(branchName) == null) {
            System.out.println(branchName + " does not exist. Couldn't show the record.");
            return;
        } else {
            System.out.println("Want to show transactions also? ");
            boolean result = scanner.nextBoolean();
            System.out.println("Showing the transaction of " + branchName + " :");
            bank.showBranchRecord(branchName, result);
        }
    }
}


/*   Created By: IntelliJ Idea
 *    Author: Naman Agarwal (naman2807)
 *    Date: 09-11-2020
 *    Time: 08:33 AM
 *    Package: PACKAGE_NAME
 */


import java.util.ArrayList;

public class Bank {
    private final String name;
    private final ArrayList<Branch> branches;


    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();

    }

    public String getName() {
        return name;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public Branch findBranch(String name) {
        for (int i = 0; i < this.branches.size(); i++) {
            if (this.branches.get(i).getName().equals(name)) {
                return this.branches.get(i);
            }
        }
        return null;
    }

    public boolean addNewBranch(String name) {
        if (findBranch(name) == null) {
            this.branches.add(new Branch(name));
            return true;
        }
        return false;
    }

    public boolean addNewCustomer(String branchName, String customerName, double initialAmount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.addNewCustomer(customerName, initialAmount);

        }
        return false;
    }

    public boolean addTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.addNewTransaction(customerName, amount);
        }
        return false;
    }

    public void showBranchRecord(String name, boolean toShowTransaction) {
        Branch branch = findBranch(name);

        System.out.println("Customers Record Of branch: " + branch.getName() + "====>");
        ArrayList<Customer> customer = branch.getCustomers();
        for (int i = 0; i < customer.size(); i++) {
            System.out.println("Customer Name: " + customer.get(i).getName());
            if (toShowTransaction) {
                System.out.println("Transaction: ");
                ArrayList<Double> transaction = customer.get(i).getTransactions();
                for (int j = 0; j < transaction.size(); j++) {
                    System.out.println("\t" + transaction.get(j));
                }
            }


        }


    }


}


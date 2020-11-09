/*   Created By: IntelliJ Idea
 *    Author: Naman Agarwal (naman2807)
 *    Date: 09-11-2020
 *    Time: 08:35 AM
 *    Package: PACKAGE_NAME
 */


import java.util.ArrayList;

public class Branch {
    private final String name;
    private final ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    private Customer findCustomer(String name) {
        for (int index = 0; index < this.customers.size(); index++) {
            if (this.customers.get(index).getName().equals(name)) {
                return this.customers.get(index);
            }
        }
        return null;
    }

    public boolean addNewCustomer(String name, double initialAmount) {
        if (findCustomer(name) == null) {
            this.customers.add(new Customer(name, initialAmount));
            return true;
        }
        return false;
    }

    public boolean addNewTransaction(String name, double amount) {
        Customer customer = findCustomer(name);
        if (customer != null) {
            customer.addNewTransaction(amount);
            return true;
        }
        return false;
    }
}





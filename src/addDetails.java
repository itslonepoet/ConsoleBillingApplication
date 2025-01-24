import java.util.Scanner;
import java.util.HashMap;
import DataTypes.*;

public class addDetails{

    static Scanner input = new Scanner(System.in);
    static HashMap<String, Customer> customers = new HashMap<>();
    static HashMap<String, Product> products = new HashMap<>();

    addDetails(boolean flag) {
        if(flag) {
            First:
            while (true) {
                System.out.println("\n\n================================ADD DETAILS MENU================================\n\n");
                System.out.print("Press 1 to \"ADD CUSTOMER DETAILS\"" +
                        "\nPress 2 to \"ADD PRODUCT DETAILS\"" +
                        "\nPress 3 to \"GO BACK TO MAIN MENU\"" +
                        "\nEnter Your Choice: ");
                int addOption = input.nextInt();

                switch (addOption) {
                    case 1:
                        addCustomerDetails();
                        break;
                    case 2:
                        addProductDetails();
                        break;
                    case 3:
                        break First;
                }
            }
        }
    }

    static void addCustomerDetails(){
        System.out.println("\n\nCustomer ID is " + generateCustomerKey());
        System.out.print("Enter Customer Name: ");
        String Name = input.next();
        System.out.print("Enter Customer Phone Number: ");
        long phoneNumber = input.nextLong();
        Customer custDet = new Customer(generateCustomerKey(), Name, phoneNumber);
        customers.put(generateCustomerKey(), custDet);
    }

    static void addProductDetails(){
        System.out.println("\n\nProduct ID is " + generateProductKey());
        System.out.print("Enter Product Name: ");
        String name = input.next();
        Product product = new Product(generateProductKey(), name);
        products.put(generateProductKey() ,product);
    }

    public HashMap<String, Customer> getCustomers(){
        return customers;
    }

    public HashMap<String, Product> getProducts(){
        return products;
    }

    private static String generateCustomerKey(){
        return ("CUS" + ((customers.isEmpty()) ? 1 : customers.size()+1));
    }

    private static String generateProductKey(){
        return ("PDT" + ((products.isEmpty()) ? 1 : products.size()+1));
    }
}

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import DataTypes.*;

public class views {

    static addDetails details = new addDetails(false);
    static transaction trans = new transaction(false);
    static Scanner input = new Scanner(System.in);

    views(){
        First:
        while (true) {
            System.out.println("\n\n================================ADD DETAILS MENU================================\n\n");
            System.out.print("Press 1 to \"VIEW PRODUCT DETAILS\"" +
                    "\nPress 2 to \"VIEW CUSTOMER DETAILS\"" +
                    "\nPress 3 to \"VIEW TRANSACTION HISTORY\"" +
                    "\nPress 4 to \"TO VIEW PROFIT STATS\"" +
                    "\nPress 5 to \"GO BACK TO MAIN MENU\"" +
                    "\nEnter Your Choice: ");

            int addOption = input.nextInt();

            switch (addOption) {
                case 1:
                    viewProductDetails();
                    break;
                case 2:
                    viewCustomerDetails();
                    break;
                case 3:
                    System.out.print("\nPress 1 to \"VIEW SALES HISTORY\"\n" +
                            "Press 2 to \"VIEW PURCHASE HISTORY\"\n" +
                            "Enter your Choice: ");
                    int options = input.nextInt();
                    switch(options){
                        case 1:
                            viewSalesHistory();
                            break;
                        case 2:
                            viewPurchaseHistory();
                            break;
                    }
                case 4:
                    viewProfitStats();
                    break;
                case 5:
                    break First;
            }
        }
    }

    static void viewCustomerDetails() {
        HashMap<String, Customer> cusDet = details.getCustomers();
        System.out.println("\nConsumer_Number - Consumer_Name - Consumer_Mobile_Number - Customer_Joining_Date - Customer_Score");
        for(String key: cusDet.keySet())
            System.out.println(key + " - " + cusDet.get(key).getName() + " - " + cusDet.get(key).getMobileNumber() +
                    " - (" + cusDet.get(key).getJoiningDate() + ") - " + cusDet.get(key).getScore() + "\n") ;
    }

    static void viewProductDetails(){
        HashMap<String, Product> pdtDet = details.getProducts();
        System.out.println("\nProduct_Key - Product_Name - Product_Selling_Price - Product_Buying_Price - Product_Quantity");
        for(String key: pdtDet.keySet())
            System.out.println("PDT" + key + " - " + pdtDet.get(key).getProductName() + " - " + pdtDet.get(key).getSellingPrice()+ " - " + pdtDet.get(key).getBuyingPrice() + " - " + pdtDet.get(key).getAvailableQuantity());
    }

    static void viewSalesHistory(){
        System.out.println("\n\n");
        HashMap<String, SalesMetaData> saleMetaData = trans.getSaleMetaData();
        HashMap<String, SalesData[]> saleBillData = trans.getSaleData();

        System.out.print("\nPress 1 to \"VIEW PARTICULAR BILL\"\n" +
                "Press 2 to \"VIEW CONSOLIDATED SUMMARY\"" +
                "\nEnter your option: ");
        int choice = input.nextInt();
        if(choice == 1){
            System.out.print("\nEnter Bill no: SAL");
            String billNo = "SAL" + (input.nextInt());
            if(saleMetaData.containsKey(billNo)){
                System.out.println("\n\n"+ billNo +
                        "                                    " + saleMetaData.get(billNo).getDate());
                SalesData[] data = saleBillData.get(billNo);
                System.out.println("S.No - Product_Code - Product Name - Product_MRP - Product_Qty - Price");
                for(int i = 0; i<saleMetaData.get(billNo).getNoOfItems(); i++) {
                    if(data[i].getProductCode() == null)
                        break;
                    System.out.print((i+1) + " - PDT" + data[i].getProductCode() + " - " + data[i].getProductName() + " - " + data[i].getSellingPrice() + " - " + data[i].getQuantity() + "QTY - " + data[i].getPrice() + "\n");
                }
                System.out.println("                                    Total No of Items: " + saleMetaData.get(billNo).getNoOfItems());
                System.out.println("                                       Total Quantity: " + saleMetaData.get(billNo).getTotalQuantity());
                System.out.println("                                          Total Price: " + saleMetaData.get(billNo).getTotalPrice());
            }
        }
        else if(choice == 2){
            System.out.println("Bill_No - Date - No_of_Products - No_of_Items - Total_Price");
            for (String key : saleMetaData.keySet()) {
                if (key == null)
                    break;
                System.out.println("SAL" + key + " - ("+ saleMetaData.get(key).getDate() + ") - " + saleMetaData.get(key).getNoOfItems() + " - " + saleMetaData.get(key).getTotalQuantity() + " - " + saleMetaData.get(key).getTotalPrice() + "\n");
            }
        }
        else
            System.out.println("Enter a Valid Choice");
    }

    static void viewPurchaseHistory(){
        System.out.println("\n\n");
        HashMap<String, PurchaseMetaData> metaData = trans.getPurchaseMetaData();
        HashMap<String, PurchaseData[]> billData = trans.getPurchaseData();

        System.out.print("\n\nPress 1 to \"VIEW PARTICULAR BILL\"\n" +
                "Press 2 to \"VIEW CONSOLIDATED SUMMARY\"" +
                "\nEnter your option: ");
        int choice = input.nextInt();
        if(choice == 1){
            System.out.print("\nEnter Bill no: PUC");
            String billNo = "PUC" + (input.nextInt());
            if(metaData.containsKey(billNo)){
                System.out.println(" " +
                        "                                                  " + metaData.get(billNo).getPurchaseDate());
                PurchaseData[] data = billData.get(billNo);
                System.out.println("S.No - Product_Code - Product Name - Product_Buying_Price - Product_Qty - Price");
                int i = 1;
                for(PurchaseData d : data) {
                    if(d.getProductCode().equals(null))
                        break;
                    System.out.print(i + " - " + d.getProductCode() + " - " + d.getProductName() + " - " + d.getBuyingPrice() + " - " + d.getQuantity() + "QTY - " + d.getPrice() + "\n");
                }
                System.out.println("                                    Total No of Items: " + metaData.get(billNo).getNoOfItems());
                System.out.println("                                       Total Quantity: " + metaData.get(billNo).getTotalQuantity());
                System.out.println("                                          Total Price: " + metaData.get(billNo).getTotalPrice());
            }
        }
        else if(choice == 2){
            System.out.println("Bill_No - Date - No_of_Products - No_of_Items - Total_Price");
            for(String key : metaData.keySet())
                System.out.println(key + " - (" + metaData.get(key).getPurchaseDate() + ") - " + metaData.get(key).getNoOfItems() + " - " + metaData.get(key).getTotalQuantity() + " - " + metaData.get(key).getTotalPrice() + "\n");
        }
        else
            System.out.println("Give a Valid Choice");
    }

    void viewProfitStats(){
        HashMap<String, Product> proData = details.getProducts();
        HashMap<String, SalesData[]> saleData = trans.getSaleData();
        HashMap<String, SalesMetaData> saleMetaData = trans.getSaleMetaData();

        for(String pdtKey : proData.keySet()){
            float profit = 0;
            String[] orders = new String[10];
            int count = 0;
            for(String billKey: saleMetaData.keySet()){
                First:
                for(int i = 0; i<saleMetaData.get(billKey).getNoOfItems(); i++){
                    if(saleData.get(billKey)[i].getProductCode() == null)
                        break First;
                    if(saleData.get(billKey)[i].getProductCode().equals(pdtKey)){
                        profit += (proData.get(pdtKey).getSellingPrice() - proData.get(pdtKey).getBuyingPrice()) * saleData.get(billKey)[i].getQuantity();
                        orders[count] = billKey;
                        count++;
                    }
                }
            }
            System.out.println("Profit Statement for " + proData.get(pdtKey).getProductName() + " is " + profit
            + "\nBought by " + Arrays.toString(orders));
        }
    }
}

import java.util.HashMap;
import java.util.Scanner;
import DataTypes.*;

public class transaction{

    static Scanner input = new Scanner(System.in);
    static addDetails productDetails = new addDetails(false);

    static HashMap<String, SalesData[]> saleBills = new HashMap<>();
    static HashMap<String, SalesMetaData> saleMetaData = new HashMap<>();
    static HashMap<String, PurchaseData[]> purchaseBills = new HashMap<>();
    static HashMap<String, PurchaseMetaData> purchaseMetaData = new HashMap<>();

    transaction(boolean flag) {
        if (flag) {
            System.out.print("\n\nPress 1 to \"CREATE PURCHASE BILL\"" +
                    "\nPress 2 to \"CREATE SALE BILL\"" +
                    "\nEnter your Choice: ");
            int option = input.nextInt();
            switch (option) {
                case 1: createPurchaseBill(); break;
                case 2: createSalesBill(); break;
            }
        }
    }

    static void createPurchaseBill() {
        System.out.println("\n\nBILL NO: " + generatePurchaseBill());

        PurchaseData[] details = new PurchaseData[10]; int count = 0,  totalQty = 0; float totalPrice = 0;
        for(PurchaseData p : details) {
            String productName; float buyingPrice, sellingPrice; int quantity;
            System.out.print("Enter Product Code: PDT");
            String pdtCode = "PDT" + (input.nextInt());
            if (productDetails.getProducts().containsKey(pdtCode)) {
                System.out.print("Do you mean this \"" + productDetails.getProducts().get(pdtCode).getProductName() + "\" product(YES=1/ NO=0): ");
                if (input.nextInt() == 1) {
                    productName = productDetails.getProducts().get(pdtCode).getProductName();
                    System.out.print("Enter the Buying Price for 1 QTY: ");
                    buyingPrice = input.nextFloat();
                    System.out.print("Enter the Selling Price for 1 QTY: ");
                    sellingPrice = input.nextFloat();
                } else { continue; }
            } else {
                System.out.println("Product doesn't exist");
                continue;
            }

            System.out.print("Enter the Quantity: ");
            quantity = input.nextInt();
            p = new PurchaseData(pdtCode, productName, buyingPrice, sellingPrice, quantity, quantity*buyingPrice);
            totalPrice += buyingPrice;
            totalQty += quantity;

            System.out.print("Do you want to add more Products(YES=1/ NO=0): ");
            if (input.nextInt() == 0)  break;
            count += 1;
        }

        PurchaseMetaData p = new PurchaseMetaData(generatePurchaseBill(), count+1, totalQty, totalPrice);
        purchaseBills.put(generatePurchaseBill(), details);
        purchaseMetaData.put(generatePurchaseBill(), p);
    }

    static void createSalesBill() {
        System.out.println("\n\nBILL NO: " + generateSalesBill());
        SalesData[] salesData = new SalesData[10];
        int count = 0, totalQty = 0; float totalPrice = 0;
        for(SalesData s : salesData) {
            System.out.print("Enter Product Code: PDT");
            String sleCode = "PDT" + (input.nextInt());
            String a, b; float c; int d;

            if (productDetails.getProducts().containsKey(sleCode)) {
                System.out.print("Do you mean this \"" + productDetails.getProducts().get(sleCode).getProductName() + "\" product(YES=1/ NO=0): ");
                if (input.nextInt() == 1) {
                    a = sleCode;
                    b = productDetails.getProducts().get(sleCode).getProductName();
                    c = productDetails.getProducts().get(sleCode).getSellingPrice();
                } else {
                    continue;
                }
            } else {
                System.out.println("Product doesn't exist");
                continue;
            }

            System.out.print("Enter the Quantity: ");
            d = input.nextInt();

            System.out.println("The Product costs " + d*c + ".");
            System.out.println("Do you want to continue(YES = 1, NO = 0): ");
            if(input.nextInt() == 0)
                continue;

            s = new SalesData(a, b, c, d, d*c);
            totalPrice += d*c;
            totalQty += d;

            System.out.print("Do you want to add more Products(YES=1/ NO=0): ");
            if (input.nextInt() == 0)
                break;
            count += 1;
        }
        SalesMetaData s = new SalesMetaData(generateSalesBill(), count+1, totalQty, totalPrice);
        saleBills.put(generateSalesBill(), salesData);
        saleMetaData.put(generateSalesBill(), s);
    }

    public HashMap<String, PurchaseData[]> getPurchaseData(){
        return purchaseBills;
    }

    public HashMap<String, PurchaseMetaData> getPurchaseMetaData(){
        return purchaseMetaData;
    }

    public HashMap<String, SalesData[]> getSaleData(){
        return saleBills;
    }

    public HashMap<String, SalesMetaData> getSaleMetaData(){
        return saleMetaData;
    }

    private static String generatePurchaseBill(){ return ("PUC" + ((purchaseBills.isEmpty()) ? 1 : purchaseBills.size() + 1));}

    private static String generateSalesBill(){return ("SAL" + ((saleBills.isEmpty()) ? 1 : saleBills.size() + 1));}
}

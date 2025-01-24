package DataTypes;

import java.util.ArrayList;

public class SalesData{
    private String productCode;
    private String productName;
    private float sellingPrice;
    private int quantity;
    private float price;

    public SalesData(String a, String b, float c, int d, float e){
        productCode = a;
        productName = b;
        sellingPrice = c;
        quantity = d;
        price = e;
    }

    public ArrayList<String> getDetails(){
        ArrayList<String> details = new ArrayList<>();
        details.add(productCode);
        details.add(productName);
        details.add(String.valueOf(sellingPrice));
        details.add(String.valueOf(quantity));
        details.add(String.valueOf(price));
        return details;
    }

    public String getProductCode(){ return productCode;}
    public String getProductName(){ return productName;}
    public float getSellingPrice(){return sellingPrice;}
    public int getQuantity() {return quantity;}
    public float getPrice() {return price;}
}


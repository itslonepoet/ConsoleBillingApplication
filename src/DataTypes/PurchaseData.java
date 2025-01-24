package DataTypes;

public class PurchaseData{
    private String productCode;
    private String productName;
    private float buyingPrice;
    private int quantity;
    private float price;

    public PurchaseData(String a, String b, float c, float d, int e, float f){
        productCode = a;
        productName = b;
        buyingPrice = c;
        float sellingPrice = d;
        quantity = e;
        price = f;

        Product p = new Product();
        p.updatePrice(buyingPrice, sellingPrice);
        p.updateQuantity(quantity);
    }

    public String getProductCode() {return productCode;}
    public String getProductName() {return productName;}
    public float getBuyingPrice() {return buyingPrice;}
    public int getQuantity() {return quantity;}
    public float getPrice() {return price;}
}

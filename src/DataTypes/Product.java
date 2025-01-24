package DataTypes;
import java.util.ArrayList;
import java.util.List;

public class Product {
    private String PID;
    private String productName;
    private float buyingPrice = 0;
    private float sellingPrice = 0;
    private int availableQuantity = 0;

    public Product(){}
    public Product(String key, String Name){
        PID = key;
        productName = Name;
    }

    public void updateQuantity(int quantity){ availableQuantity = availableQuantity + quantity; }

    public void updatePrice(float buying, float selling){
        buyingPrice = buying;
        sellingPrice = selling;
    }

    public String getPID(){ return PID;}
    public String getProductName(){ return productName;}
    public float getBuyingPrice(){ return buyingPrice; }
    public float getSellingPrice(){ return sellingPrice; }
    public int getAvailableQuantity(){return availableQuantity; }
}

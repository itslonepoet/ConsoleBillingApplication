package DataTypes;
import java.time.LocalDate;
import java.util.ArrayList;

public class PurchaseMetaData{
    private String PID;
    private LocalDate purchaseDate;
    private int noOfItems;
    private int totalQuantity;
    private float totalPrice;

    public PurchaseMetaData(String a, int b, int c, float d){
        PID = a;
        purchaseDate = LocalDate.now();
        noOfItems = b;
        totalQuantity = c;
        totalPrice = d;
    }

    public ArrayList<String> getDetails(){
        ArrayList<String> details = new ArrayList<>();
        details.add(PID);
        details.add(String.valueOf(purchaseDate));
        details.add(String.valueOf(noOfItems));
        details.add(String.valueOf(totalQuantity));
        details.add(String.valueOf(totalPrice));
        return details;
    }

    public String getPurchaseID(){ return PID;}
    public LocalDate getPurchaseDate(){ return purchaseDate;}
    public int getNoOfItems(){return noOfItems;}
    public int getTotalQuantity(){return totalQuantity;}
    public float getTotalPrice(){return totalPrice;}
}

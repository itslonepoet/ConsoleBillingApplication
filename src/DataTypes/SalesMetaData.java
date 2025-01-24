package DataTypes;
import java.time.LocalDate;
import java.util.ArrayList;

public class SalesMetaData{
    private String SID;
    private LocalDate date;
    private int noOfItems;
    private int totalQuantity;
    private float totalPrice;

    public SalesMetaData(String a, int b, int c, float d){
        date = LocalDate.now();
        SID = a;
        noOfItems = b;
        totalQuantity = c;
        totalPrice = d;
    }

    public ArrayList<String> getDetails(){
        ArrayList<String> details = new ArrayList<>();
        details.add(SID);
        details.add(String.valueOf(date));
        details.add(String.valueOf(noOfItems));
        details.add(String.valueOf(totalQuantity));
        details.add(String.valueOf(totalPrice));
        return details;
    }

    public String getSalesID(){return SID;}
    public LocalDate getDate(){return date;}
    public int getNoOfItems(){return noOfItems;}
    public int getTotalQuantity(){return totalQuantity;}
    public float getTotalPrice() {return totalPrice;}
}

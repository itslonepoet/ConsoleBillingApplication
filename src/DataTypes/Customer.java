package DataTypes;
import java.time.LocalDate;

public class Customer{
    private String CID;
    private String customerName;
    private long customerMobileNumber;
    private LocalDate joiningDate;
    private int score;

    public Customer(String key, String name, long mobileNumber){
        CID = key;
        customerName = name;
        customerMobileNumber = mobileNumber;
        joiningDate = LocalDate.now();
        score = 0;
    }
    public void put(String name, long mobileNumber){
        customerName = name;
        customerMobileNumber = mobileNumber;
        joiningDate = LocalDate.now();
        score = 0;
    }

    public String getCID(){
        return CID;
    }

    public String getName(){
        return customerName;
    }

    public Long getMobileNumber(){
        return customerMobileNumber;
    }

    public LocalDate getJoiningDate(){
        return joiningDate;
    }

    public int getScore(){
        return score;
    }
}

package CarRental.entities;

import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
    List<Receipt> receiptList;

    public User(String name){
        this.name = name;
        receiptList = new ArrayList<>();
    }

    public void addReceipt(Receipt receipt){
        receiptList.add(receipt);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

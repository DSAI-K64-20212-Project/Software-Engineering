package project.base.order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Invoice {
    private ObservableList<OneCall> inFo = FXCollections.observableArrayList();
    public int soorder;
    public int khachdua;
    public String id;

    public Invoice(){
        id = UUID.randomUUID().toString(); //Generates random UUID.
    };
    public void addCall(OneCall oneCall){
        //ToDO
    }

    public float getBill(){
        //ToDO
        return 0;
    }

    public void pay(float amount){
        //todo

    }

    public void confirm(){
        //todo

    }
    public boolean check_availability(){
        boolean avail = true;
        for (OneCall call: inFo){
            avail = avail && call.check_availability();
        }
        return avail;
    }
    public static void main(String[] args) {
        Invoice s = new Invoice();
    }
}


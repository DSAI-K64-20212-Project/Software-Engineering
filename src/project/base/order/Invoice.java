package project.base.order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.Map;

public class Invoice {
    private ObservableList<OneCall> inFo = FXCollections.observableArrayList();
    private String tenkhachhang;
    private int soorder;

    private Invoice(){};
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
    public static void main(String[] args) {
        Invoice s = new Invoice();
    }
}


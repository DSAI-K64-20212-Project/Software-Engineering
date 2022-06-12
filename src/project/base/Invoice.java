package project.base;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Dictionary;
import java.util.Hashtable;

public class Invoice {
    private ObservableList<Dictionary> inFo = FXCollections.observableArrayList();
    private Invoice(){};
    public void addBuy(String tendouong, char size, float duong, float da, String[] topping) {
        Dictionary h = new Hashtable();
        h.put("tendouong", tendouong);
        h.put("size", size);h.put("duong", duong);h.put("da", da);
        this.inFo.add(h);
    }

    public float getBill(){
        //
        return 0;
    }

    public void pay(float amount){

    }

    public void confirm(){

    }
    public static void main(String[] args) {
        Invoice s = new Invoice();
//        s.addBuy(String drink, )
    }
}


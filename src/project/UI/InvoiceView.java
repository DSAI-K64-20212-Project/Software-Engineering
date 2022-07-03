package project.UI;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableStringValue;
import javafx.collections.ListChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import project.base.order.Invoice;
import project.base.order.OneCall;

import java.util.Arrays;

public class InvoiceView extends VBox {
    Invoice invoice;
    boolean button = true;
    boolean thanhtien = true;
    public InvoiceView(Invoice invoice){
        this.setSpacing(10);
        this.invoice = invoice;
        this.invoice.getInFo().addListener((ListChangeListener<? super OneCall>) change -> {
            update();
        });
    }
    public InvoiceView(Invoice invoice, boolean haveButton, boolean haveCash) {
        this(invoice);
        this.button = haveButton;
        this.thanhtien = haveCash;
    }
    public void update(){
        this.getChildren().clear();
        for (OneCall oneCall: this.invoice.getInFo()){
            if (oneCall.get_ammount() == 0){
                continue;
            }
            Label numLabel = new Label();
            numLabel.setFont(new Font("Arial", 30));
            ObservableStringValue formattedNum = Bindings.createStringBinding(() ->
                            String.format("%d",oneCall.get_ammount()), oneCall.getAmountProperty());
            numLabel.textProperty().bind(formattedNum);

            Label title = new Label(oneCall.drink_name);
            title.getStyleClass().add("title-text");
            String toppingArray = Arrays.toString(oneCall.toppings);
            Label middleText = new Label(String.format("""
                            - Size %s
                            - %.0f %% đá
                            - %.0f %% đường
                            - Topping: %s""",
                    oneCall.size,
                    oneCall.ice*100,
                    oneCall.sugar*100,
                    toppingArray.substring(1,toppingArray.length()-1)));
            middleText.setWrapText(true);
            middleText.setMaxWidth(170);
            Button minus = new Button("--");
            minus.setOnAction(actionEvent -> oneCall.decrease_amount());
            Button plus = new Button("+");
            plus.setOnAction(actionEvent -> oneCall.increase_amount());

            HBox hBox;
            if (this.button) {
                hBox = new HBox(numLabel, new VBox(title, middleText), new VBox(plus, minus));
            } else {
                hBox = new HBox(numLabel, new VBox(title, middleText));
            }
            hBox.setSpacing(5);
            //them thanh tien
            Label thanhtien = new Label();
            ObservableStringValue formattedCash = Bindings.createStringBinding(() ->
                    "Giá: " + String.format("%d.000đ",oneCall.get_money()), oneCall.getAmountProperty());
            thanhtien.textProperty().bind(formattedCash);

            if (this.thanhtien){
                this.getChildren().addAll(new VBox(hBox, thanhtien));
            } else {
                this.getChildren().add(hBox);
            }
        }
    }

}

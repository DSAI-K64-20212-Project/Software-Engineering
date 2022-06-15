package project.base.functional;

import project.base.order.Invoice;

public interface CashierInterface {
    default void confirm_new_invoice(Invoice invoice){
        //todo
    }
}

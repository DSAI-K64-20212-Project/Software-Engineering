package project.base.user;

import project.base.functional.CashierInterface;
import project.base.order.Invoice;

public class Cashier extends User implements CashierInterface {
    public Cashier(String username) {
        super(username);
    }
    @Override
    public void confirm_new_invoice(Invoice invoice){
        //todo
    }
}

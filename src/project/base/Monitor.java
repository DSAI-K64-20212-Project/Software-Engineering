package project.base;

import project.base.user.Admin;
import project.base.user.Bartender;
import project.base.user.Cashier;
import project.base.user.User;

import java.sql.SQLException;

public class Monitor {
    private Cashier cashier;
    private Bartender bartender;
    private Admin admin;
    private User activeUser;
    public Monitor() throws SQLException, ClassNotFoundException {
        DBUtil.dbConnect();
    }

    public void newSession(Cashier cashier){
        this.cashier = cashier;
        this.bartender = null;
        this.admin = null;
    }

    public void newSession(Bartender bartender){
        this.cashier = null;
        this.bartender = bartender;
        this.admin = null;
    }
    public void newSession(Admin admin){
        this.cashier = null;
        this.bartender = null;
        this.admin = admin;
    }

    public User getActiveUser() {
        if (this.cashier != null)  return this.cashier;
        if (this.bartender != null) return this.bartender;
        if (this.admin != null) return this.admin;
        return null;
    }


}

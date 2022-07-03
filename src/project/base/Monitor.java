package project.base;

import project.base.user.User;

import java.sql.SQLException;

public class Monitor {
    private User activeUser;

    public User getActiveUser() {
        return activeUser;
    }

    public Monitor() throws SQLException, ClassNotFoundException {
        DBUtil.dbConnect();
    }
    public void newSession(User user){
        this.activeUser = user;
    }
}

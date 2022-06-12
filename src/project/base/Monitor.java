package project.base;

import project.base.user.User;

public class Monitor {
    private User activeUser;
    public Monitor(){}
    public void newSession(User user){
        this.activeUser = user;
    }
}

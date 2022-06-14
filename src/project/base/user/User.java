package project.base.user;

public abstract class User {

    private final String username;
//    private String fullname;
//    private String password;
//    private String phone_num;
//    private String shift;
    public User(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

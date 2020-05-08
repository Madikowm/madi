package sample;

public class User {
    private String fullname;
    private String username;
    private String password;
    private String gender;

    public User(){}

    public User(String fullname, String username, String password, String gender) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.gender = gender;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String firstname) {
        this.fullname = firstname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}

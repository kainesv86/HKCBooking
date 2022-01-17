package entities;

public class User {

    private int userId;
    private String username;
    private String password;
    private String fullname;
    private String address;
    private String phone;
    private int roleId;
    private String email;

    public User(int userId, String username, String password, String fullname, String address, String phone, int roleId, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.address = address;
        this.phone = phone;
        this.roleId = roleId;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

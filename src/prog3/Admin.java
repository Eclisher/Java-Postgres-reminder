package src.prog3;
public class Admin  extends User {
    private String password;
    public Admin(int id, String Name, String Email, String PhoneNumber) {
        super(id, Name, Email, PhoneNumber);
        this.password =password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "Admin{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}

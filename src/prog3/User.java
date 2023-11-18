package src.prog3;

public abstract class User {
    private int id;
    private String Name;
    private String Email;
    private String PhoneNumber;

    public User(int id, String Name, String Email, String PhoneNumber) {
        this.id = id;
        this.Name = Name;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" +Name + '\'' +
                ", email='" + Email + '\'' +
                ", phoneNumber='" + PhoneNumber + '\'' +
                '}';
    }

}

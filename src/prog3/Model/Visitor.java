package src.prog3.Model;
public class Visitor  extends User{
    private String reference;

    public Visitor(int id, String Name, String Email, String PhoneNumber, String visitorReference) {
        super(id, Name, Email, PhoneNumber);
        this.reference = visitorReference;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }


    @Override
    public String toString() {
        return "Visitor{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", reference='" + reference + '\'' +
                '}';
    }


}

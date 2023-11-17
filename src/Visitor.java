package src;

public class Visitor  extends User{
    private String reference;

    public Visitor(int id, String Name, String Email, String PhoneNumber) {
        super(id, Name, Email, PhoneNumber);
        this.reference = reference;
    }


    public void borrowBook(Book book) {
        // Logic to handle borrowing a book
    }
    public void returnBook(Book book) {
        // Logic to handle returning a book
    }

}

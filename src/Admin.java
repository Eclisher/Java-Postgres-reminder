package src;

public class Admin  extends  User{
    public Admin(int id, String Name, String Email, String PhoneNumber) {
        super(id, Name, Email, PhoneNumber);
    }

    public void borrowBook(Visitor visitor, Book book){

    }
    public void returnBook(Visitor visitor, Book book){

    }
    public void addAuthor(Author author){

    }

    public void importBook(Book book){

    }

}

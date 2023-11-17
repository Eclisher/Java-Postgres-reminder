package src;

import java.util.Date;

public class Book {
    private int bookID;
    private String bookName;
    private Author author;
    private int pageNumbers;
    // private Topic topic;
    private Date releaseDate;

    public Book(int bookID, String bookName, Author author, int pageNumbers, Date releaseDate) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.author = author;
        this.pageNumbers = pageNumbers;
        this.releaseDate = releaseDate;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(int pageNumbers) {
        this.pageNumbers = pageNumbers;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}


package src.prog3.Model;

import java.time.LocalDate;

public class Book {
    private int bookID;
    private String bookName;
    private int author;
    private int pageNumbers;
    private  Topic topic;
    private LocalDate releaseDate;


    public Book(int bookId, String bookName, int authorId, int pageNumbers, Topic topic, LocalDate releaseDate) {
        this.bookID = bookId;
        this.bookName = bookName;
        this.author = authorId;
        this.pageNumbers = pageNumbers;
        this.releaseDate = releaseDate;
        this.topic = topic;
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

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(int pageNumbers) {
        this.pageNumbers = pageNumbers;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", authorId=" + author +
                ", pageNumbers=" + pageNumbers +
                ", topic=" + topic +
                ", releaseDate=" + releaseDate +
                '}';
    }
}


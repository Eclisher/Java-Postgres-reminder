package src.prog3.CrudOPeration;

import src.prog3.DBConnection;
import src.prog3.Interface.CrudOperation;
import src.prog3.Model.Book;
import src.prog3.Model.Topic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookCrudOperation implements CrudOperation<Book> {
    private static Connection connection;

    // Méthode pour obtenir une connexion à la base de données
    private static Connection getConnection() {
        return DBConnection.getConnection();
    }
    @Override
    public  List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try {
            Connection connection = getConnection();
            String query = "SELECT * FROM book";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int bookId = resultSet.getInt("book_id");
                String bookName = resultSet.getString("book_name");
                int authorId = resultSet.getInt("author_id");
                int pageNumbers = resultSet.getInt("page_numbers");
                String topicString = resultSet.getString("topic");
                Topic topic = Topic.fromString(topicString);
                java.sql.Date releaseDate = resultSet.getDate("release_date");

                Book book = new Book(bookId, bookName, authorId, pageNumbers, topic, releaseDate.toLocalDate());
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
    @Override
    public Book save(Book toSave) {
        try {
            Connection connection = getConnection();
            String query = "INSERT INTO book (book_name, author_id, page_numbers, topic, release_date) VALUES (?, ?, ?, CAST(? AS topic), ?)";
            PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            statement.setString(1, toSave.getBookName());
            statement.setInt(2, toSave.getAuthor());
            statement.setInt(3, toSave.getPageNumbers());
            statement.setString(4, toSave.getTopic().name());
            statement.setDate(5, java.sql.Date.valueOf(toSave.getReleaseDate()));
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                toSave.setBookID(generatedKeys.getInt(1));
            }

            System.out.println("Book saved successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
    }


    @Override
    public Book delete(Book toDelete) {
        try {
            Connection connection = getConnection();
            String query = "DELETE FROM book WHERE book_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, toDelete.getBookID());
            statement.executeUpdate();

            System.out.println("Book deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toDelete;
    }
    @Override
    public List<Book> saveAll(List<Book> toSave) {
        try {
            Connection connection = getConnection();
            String query = "INSERT INTO book (book_name, author_id, page_numbers, topic, release_date) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            for (Book book : toSave) {
                statement.setString(1, book.getBookName());
                statement.setInt(2, book.getAuthor());
                statement.setInt(3, book.getPageNumbers());
                statement.setString(4, book.getTopic().name());
                statement.setDate(5, java.sql.Date.valueOf(book.getReleaseDate()));
                statement.addBatch();
            }

            statement.executeBatch();

            System.out.println("Books saved successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
    }

}

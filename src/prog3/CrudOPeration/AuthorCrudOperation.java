package src.prog3.CrudOPeration;

import src.prog3.DBConnection;
import src.prog3.Interface.CrudOperation;
import src.prog3.Model.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorCrudOperation implements CrudOperation<Author> {
    private static Connection connection;

    // Méthode pour obtenir une connexion à la base de données
    private static Connection getConnection() {
        return DBConnection.getConnection();
    }
    @Override
    // Méthode pour trouver tous les auteurs
    public List<Author> findAll() {
        List<Author> authors = new ArrayList<>();
        try {
            Connection connection = getConnection();
            String query = "SELECT * FROM author";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int authorId = resultSet.getInt("author_id");
                String authorName = resultSet.getString("author_name");
                char sex = resultSet.getString("sex").charAt(0);
                Author author = new Author(authorId, authorName, sex);
                authors.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    @Override
    public Author save(Author toSave) {
        try {
            Connection connection = getConnection();
            String query = "INSERT INTO author (author_name, sex) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            statement.setString(1, toSave.getAuthorName());
            statement.setString(2, String.valueOf(toSave.getSex()));
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                toSave.setAuthorID(generatedKeys.getInt(1));
            }
            System.out.println("Author saved successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public Author delete(Author toDelete) {
        try {
            Connection connection = getConnection();
            String query = "DELETE FROM author WHERE author_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, toDelete.getAuthorID());
            statement.executeUpdate();

            System.out.println("Author deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toDelete;
    }

    @Override
    public List<Author> saveAll(List<Author> toSave) {
        try {
            Connection connection = getConnection();
            String query = "INSERT INTO author (author_name, sex) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            for (Author author : toSave) {
                statement.setString(1, author.getAuthorName());
                statement.setString(2, String.valueOf(author.getSex()));
                statement.addBatch();
            }

            statement.executeBatch();

            System.out.println("Authors saved successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
    }

}

package src.prog3;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AdminCrudOperation  implements CrudOperation <Admin>{
    private static Connection connection;
    // Méthode pour obtenir une connexion à la base de données
    private static Connection getConnection() {
        return DBConnection.getConnection();
    }
    @Override
    public List<Admin> findAll() {
        List<Admin> admins = new ArrayList<>();
        try {
            Connection connection = getConnection();
            String query = "SELECT * FROM admin";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int adminId = resultSet.getInt("admin_id");
                String adminName = resultSet.getString("admin_name");
                String adminEmail = resultSet.getString("admin_email");
                String adminPassword = resultSet.getString("admin_password");
                Admin admin = new Admin(adminId, adminName, adminEmail, adminPassword);
                admins.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }

    @Override
    public Admin save(Admin toSave) {
        try {
            Connection connection = getConnection();
            String query = "INSERT INTO admin (admin_name, admin_email, admin_password) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, toSave.getName());
            statement.setString(2, toSave.getEmail());
            statement.setString(3, toSave.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public Admin delete(Admin toDelete) {
        try {
            Connection connection = getConnection();
            String query = "DELETE FROM admin WHERE admin_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, toDelete.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toDelete;
    }

    @Override
    public List<Admin> saveAll(List<Admin> toSave) {
        try {
            Connection connection = getConnection();
            for (Admin admin : toSave) {
                String query = "INSERT INTO admin (admin_name, admin_email, admin_password) VALUES (?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, admin.getName());
                statement.setString(2, admin.getEmail());
                statement.setString(3, admin.getPassword());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
    }

}

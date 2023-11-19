    package src.prog3.CrudOPeration;

    import src.prog3.DBConnection;
    import src.prog3.Interface.CrudOperation;
    import src.prog3.Model.Visitor;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.ArrayList;
    import java.util.List;


    public class VisitorCrudOperation  implements CrudOperation<Visitor> {
        private static Connection connection;

        // Méthode pour obtenir une connexion à la base de données
        private static Connection getConnection() {
            return DBConnection.getConnection();
        }
        @Override
        public List<Visitor> findAll() {
            List<Visitor> visitors = new ArrayList<>();
            try {
                Connection connection = getConnection();
                String query = "SELECT * FROM subscribers"; // Assurez-vous que la table dans la base de données est correcte
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int visitorId = resultSet.getInt("subscriber_id");
                    String visitorName = resultSet.getString("subscriber_name");
                    String visitorEmail = resultSet.getString("email");
                    String visitorPhoneNumber = resultSet.getString("phone_number");
                    String visitorReference = resultSet.getString("reference");
                    Visitor visitor = new Visitor( visitorId, visitorName,visitorEmail,visitorPhoneNumber,visitorReference);
                    visitors.add(visitor);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return visitors;
        }

        @Override
        public Visitor save(Visitor toSave) {
            try {
                Connection connection = getConnection();
                String query = "INSERT INTO subscribers (subscriber_name, email, phone_number, reference) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

                statement.setString(1, toSave.getName());
                statement.setString(2, toSave.getEmail());
                statement.setString(3, toSave.getPhoneNumber());
                statement.setString(4, toSave.getReference());

                statement.executeUpdate();

                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    toSave.setId(generatedKeys.getInt(1));
                }

                System.out.println("Visitor saved successfully!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return toSave;
        }

        @Override
        public Visitor delete(Visitor toDelete) {
            try {
                Connection connection = getConnection();
                String query = "DELETE FROM subscribers WHERE subscriber_id = ?";
                PreparedStatement statement = connection.prepareStatement(query);

                statement.setInt(1, toDelete.getId());
                statement.executeUpdate();

                System.out.println("Visitor deleted successfully!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return toDelete;
        }

        @Override
        public List<Visitor> saveAll(List<Visitor> toSave) {
            try {
                Connection connection = getConnection();
                String query = "INSERT INTO subscribers (subscriber_name, email, phone_number, reference) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

                for (Visitor visitor : toSave) {
                    statement.setString(1, visitor.getName());
                    statement.setString(2, visitor.getEmail());
                    statement.setString(3, visitor.getPhoneNumber());
                    statement.setString(4, visitor.getReference());
                    statement.addBatch();
                }

                statement.executeBatch();

                System.out.println("Visitors saved successfully!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return toSave;
        }

    }

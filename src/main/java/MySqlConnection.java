import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/water-biling-system";
        String user = "root";
        String password = "root";
        Connection connection;
        Statement statement;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

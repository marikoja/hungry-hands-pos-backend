import java.sql.*;

public class Database {
    private final String url = "jdbc:postgresql://localhost:5433/capstone";
    private final String user = "capstone";
    private final String password = "maggie";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }


}

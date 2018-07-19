import java.sql.*;
import java.net.*;

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

//        ~~~~~~~~LOCAL DATABSE TO HEROKU~~~~~~
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection(url, user, password);
//            System.out.println("Connected to the PostgreSQL server successfully.");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//
//        return conn;


//        ~~~~~~~~DEPLOY DATABSE TO HEROKU~~~~~~
        Connection conn = null;
        URI dbUri = null;
        try {
            dbUri = new URI(System.getenv("DATABASE_URL"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";

        try {
            conn = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }


}

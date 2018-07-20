import java.sql.*;
import java.net.*;

public class Database {
//    private static final String DATABASE_URL = "postgres://wrbqywcdkyrmod:3e8829002eac935e6feb847cec1980861643a07937aa7deecd7bf367ee2f3836@ec2-54-83-59-239.compute-1.amazonaws.com:5432/dcc678p2ftm0dd";

    private final String url = "jdbc:postgresql://localhost:5433/capstone";
    private final String user = "capstone";
    private final String password = "maggie";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() {

//        ~~~~~~~~LOCAL DATABASE~~~~~~
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

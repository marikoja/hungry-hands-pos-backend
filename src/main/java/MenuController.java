import static spark.Spark.*;
import java.sql.*;

public class MenuController {

    public MenuController(Connection conn) {

        get("/menu", (req, res) -> {

            String SQL = "SELECT * FROM menu_item";
            int count = 0;
            String results = null;

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(SQL)) {
                results = JsonUtil.convertResultSetIntoJSON(rs).toString();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            return results;
        });

        get("/menu_item/:item_number", (req, res) -> {

            String SQL = "SELECT * " +
                    "FROM menu_item " +
                    "WHERE menu_item_id = "+
                    req.params(":item_number")+";";
            int count = 0;
            String results = null;

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(SQL)) {
                results = JsonUtil.convertResultSetIntoJSON(rs).toString();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            return results;

        });

    }
}
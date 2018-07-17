import static spark.Spark.*;
import java.sql.*;

public class MenuController {

    private Database db = new Database();

    public MenuController() {

        Connection conn = db.connect();
        get("/menu", (req, res) -> MenuItem.getAllItems(), JsonUtil.json());
        get("/menu/:item_number", (req, res) -> {

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
        post("/menu/:", (req, res) -> {
            //...
        });

    }
}
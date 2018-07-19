import static spark.Spark.*;
import java.sql.*;
import org.json.*;

public class MenuController {

    public MenuController(Connection conn) {

        get("/menu", (req, res) -> {

            String SQL = "SELECT * FROM menu_item";
            int count = 0;
            String results = null;

            try (Statement stmt = conn.createStatement();ResultSet rs = stmt.executeQuery(SQL)) {
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

        post("/menu/:menu_id/menu_item", (req, res) -> {

            JSONObject obj = new  JSONObject(req.body());

            String SQL = "INSERT INTO menu_item (menu_id, name, price, description, quantity, img) " +
                    "VALUES (1,'"+obj.get("name")+"',"+obj.get("price")+",'"+obj.get("description")+"',"+obj.get("quantity")+",'"+obj.get("img")+"') " +
                    "RETURNING menu_item_id, name";
            int count = 0;
            String results = null;

            try (Statement stmt = conn.createStatement();ResultSet rs = stmt.executeQuery(SQL)) {
                results = JsonUtil.convertResultSetIntoJSON(rs).toString();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            return results;
        });

        put("/menu/:menu_id/menu_item/:menu_item_id", (req, res) -> {

            JSONObject obj = new  JSONObject(req.body());

            String SQL = "UPDATE menu_item " +
                    "SET (name, price, description, quantity, img) " +
                    "= ('"+obj.get("name")+"',"+obj.get("price")+",'"+obj.get("description")+"',"+obj.get("quantity")+",'"+obj.get("img")+"') " +
                    "WHERE menu_id = "+req.params(":menu_id")+" AND menu_item_id = "+req.params(":menu_item_id")+" " +
                    "RETURNING menu_item_id, name;";

            int count = 0;
            String results = null;

            try (Statement stmt = conn.createStatement();ResultSet rs = stmt.executeQuery(SQL)) {
                results = JsonUtil.convertResultSetIntoJSON(rs).toString();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            return results;
        });
    }
}
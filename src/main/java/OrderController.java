import static spark.Spark.*;
import java.sql.*;
import org.json.*;



public class OrderController {


    public OrderController(Connection conn) {

        post("/order", (req, res) -> {

            JSONObject obj = new  JSONObject(req.body());

            String SQL = "INSERT INTO \"order\" (customer_id, status, company_id) VALUES ("+obj.get("customer_id")+",'"+obj.get("status")+"',1) RETURNING order_id";
            int count = 0;
            String results = null;

            try (Statement stmt = conn.createStatement();ResultSet rs = stmt.executeQuery(SQL)) {
                results = JsonUtil.convertResultSetIntoJSON(rs).toString();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            return results;
        });

        post("/order/:order_id", (req, res) -> {

            JSONObject obj = new  JSONObject(req.body());

            String SQL = "INSERT INTO order_menu_item (menu_item_id, quantity, order_id) VALUES ("+obj.get("menu_item_id")+",1,"+ req.params(":order_id")+") RETURNING order_menu_item_id, order_id";
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

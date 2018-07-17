import static spark.Spark.*;
import java.sql.*;



public class OrderController {

    private Database db = new Database();

    public OrderController() {

        Connection conn = db.connect();
        get("/order", (req, res) -> OrderItem.getAllItems(), JsonUtil.json());
        

    }
}

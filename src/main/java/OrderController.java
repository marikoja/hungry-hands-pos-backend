import static spark.Spark.*;
import java.sql.*;



public class OrderController {


    public OrderController(Connection conn) {

        get("/hello", (request, response) -> {
            return "Hello World";
        });

        get("/order", (req, res) -> OrderItem.getAllItems(), JsonUtil.json());


    }

}

import static spark.Spark.*;

public class MenuController {
    public MenuController() {
        get("/menu", (req, res) -> MenuItem.getAllItems(), JsonUtil.json());

        get("/menu/:id", (req, res) -> {
            String id = req.params(":id");
            MenuItem item = MenuItem.getId(id);
            if (item != null) {
                return item;
            }
            res.status(400);
            return new ResponseError("No item with id '%s' found", id);
        }, json());
    }
}
import java.util.ArrayList;

public class OrderItem {
    private int id;
    private int order_item_id;
    private String name;
    private String description;
    private Double price;
    private String image_url;
    private int quantity;

    public OrderItem(int id, int order_item_id, String name, String description, Double price, String image_url, int quantity) {
        this.id = id;
        this.order_item_id = order_item_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image_url = image_url;
        this.quantity = quantity;
    }

    public static ArrayList<OrderItem> getAllItems() {
        ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
        return orderItems;
    }

    public int getId() {
        return id;
    }

    public int getOrder_item_Id() {
        return order_item_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImage_url() {
        return image_url;
    }

    public int getQuantity() {
        return quantity;
    }
}

import java.lang.reflect.Array;
import java.util.ArrayList;
public class MenuItem {
    int id;
    String name;
    String description;
    Double price;
    String image_url;
    int quantity;

    public MenuItem(int id, String name, String description, Double price, String image_url, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image_url = image_url;
        this.quantity = quantity;
    }

    public static ArrayList<MenuItem> getAllItems() {
        ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
        menuItems.add(new MenuItem(1, "Burger", "A tasty fucking burger.", 14.99, "https://unsplash.com/photos/4cGJx5u2Z04",50));
        menuItems.add(new MenuItem(2, "Fried Ramen", "Crunchy ramen noodz", 5.99, "https://unsplash.com/photos/1WeMwcnSXoI",50));
        menuItems.add(new MenuItem(3, "PB & J", "White bread, peanut butter and jelly", 3.00, "https://unsplash.com/photos/1WeMwcnSXoI",50));
        return menuItems;
    }

    public int getId() {
        return id;
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

package version02;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Order {
    private final String id;
    private Map<String, Product> products;

    public Order(Map<String, Product> products) {
        this.id = UUID.randomUUID().toString();
        this.products = products;
    }

    public Order(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", products=" + products +
                '}';
    }
}

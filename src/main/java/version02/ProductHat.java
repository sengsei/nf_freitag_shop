package version02;

import java.util.UUID;

public class ProductHat implements Product {
    private final String id;
    private final String name;

    public ProductHat(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ProductHat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

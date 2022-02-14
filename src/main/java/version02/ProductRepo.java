package version02;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ProductRepo {
    private final Map<String, Product> products;

    public ProductRepo(Map<String, Product> products) {
        this.products = products;
    }

    public List<Product> list() {
        return products.values().stream().toList();
    }

    public Optional<Product> get(String id)  {
            return Optional.ofNullable(products.get(id));
    }



}

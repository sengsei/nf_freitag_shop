package version02;

import java.util.List;
import java.util.Optional;

public class ProductRepo {
    private final List<Product>products;

    public ProductRepo(List<Product> products) {
        this.products = products;
    }

    public List<Product> list() {
        return products;
    }

    public Optional<Product> get(int id)  {
            for (Product product : products) {
                if (product.getId() == id) {
                    return Optional.of(product);
                }
            }
           return Optional.empty();
    }
}

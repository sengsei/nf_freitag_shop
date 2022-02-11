package version01;

import java.util.List;

public class ProductRepo {
    private final List<Product>products;

    public ProductRepo(List<Product> products) {
        this.products = products;
    }

    public List<Product> list() {
        return products;
    }

    public Product get(int id) throws Exception {
            for (Product product : products) {
                if (product.getId() == id) {
                    return product;
                }
            }
            throw new Exception("Element is not in List!");
    }
}

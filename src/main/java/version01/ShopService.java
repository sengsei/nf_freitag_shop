package version01;

import java.util.List;

public class ShopService {
    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public Product getProduct(int id){
        return productRepo.get(id);
    }

    public List<Product> listProducts(){
        return productRepo.list();
    }
}

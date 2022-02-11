package version02;

import java.util.List;

public class ShopService {
    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public Product getProduct(int id) throws Exception {
        return productRepo.get(id);
    }

    public List<Product> listProducts(){
        return productRepo.list();
    }

    public void addOrder(Order order){
        orderRepo.add(order);
    }

    public Order getOrder(int id){
        return orderRepo.get(id);
    }

    public List<Order> listOrders(){
        return orderRepo.list();
    }

}

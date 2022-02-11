package version02;

import java.util.List;
import java.util.Optional;

public class OrderRepo {
    private final List<Order>orders;

    public OrderRepo(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> list(){
        return orders;
    }

    public Optional<Order> get(int id){
        for (Order order : orders) {
            if (order.getId() == id) {
                return Optional.of(order);
            }
        }
        return Optional.empty();
    }

    public void add(Order order){
        orders.add(order);
    }
}

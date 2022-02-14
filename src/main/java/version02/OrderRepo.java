package version02;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public class OrderRepo {
    private final Map<String, Order> orders;

    public OrderRepo(Map<String, Order> orders) {
        this.orders = orders;
    }

    public List<Order> list(){
        return orders.values().stream().toList();
    }

    public Optional<Order> get(String id){
        return Optional.ofNullable(orders.get(id));
    }

    public void add(Order order){

        orders.put(order.getId(), order);
    }
}



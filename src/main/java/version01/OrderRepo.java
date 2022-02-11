package version01;

import java.util.List;

public class OrderRepo {
    private final List<Order>orders;

    public OrderRepo(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> list(){
        return orders;
    }

    public Order get(int id){
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    public void add(Order order){
        orders.add(order);
    }
}

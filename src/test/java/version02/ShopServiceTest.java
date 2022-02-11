package version02;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    void shouldReturnExceptionProductListisEmpty() {
        Product p1 = new Product(1234, "BlackHat");
        List<Product> productList = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        ProductRepo productRepo = new ProductRepo(productList);
        OrderRepo orderRepo = new OrderRepo(orders);
        ShopService shopService = new ShopService(productRepo,orderRepo);
        Optional<Product> pWithOpt = shopService.getProduct(1);

        assertFalse(pWithOpt.isPresent());
    }

}
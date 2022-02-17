package version02;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {


    @Test
    void shouldReturnExceptionProductListIsEmpty() {
        Product p1 = new ProductHat("BlackHat");
        Map<String, Product> productList = new HashMap<>();
        Map<String, Order> orders = new HashMap<>();
        ProductRepo productRepo = new ProductRepo(productList);
        OrderRepo orderRepo = new OrderRepo(orders);
        ShopService shopService = new ShopService(productRepo,orderRepo);
        Optional<Product> pWithOpt = shopService.getProduct("1");

        assertFalse(pWithOpt.isPresent());
    }

    @Test
    void shouldListProductsHats() {
        Product p1 = new ProductHat("BlackHat");
        Map<String, Product> productList = new HashMap<>();
        productList.put("123", p1);
        Map<String, Order> orders = new HashMap<>();
        ProductRepo productRepo = new ProductRepo(productList);
        OrderRepo orderRepo = new OrderRepo(orders);
        ShopService shopService = new ShopService(productRepo,orderRepo);

        List<Product> result = shopService.listProducts();

        assertTrue(result.contains(p1));
    }

    @Test
    void shouldListProductsShoes() {
        Product p1 = new ProductShoes("BlackShoe");
        Map<String, Product> productList = new HashMap<>();
        productList.put("123", p1);
        Map<String, Order> orders = new HashMap<>();
        ProductRepo productRepo = new ProductRepo(productList);
        OrderRepo orderRepo = new OrderRepo(orders);
        ShopService shopService = new ShopService(productRepo,orderRepo);
        List<Product> result = shopService.listProducts();

        assertTrue(result.contains(p1));

    }

    @Test
    void shouldGetFirstOrders() {
        Product p1 = new ProductHat("BlackHat");
        Product p2 = new ProductHat("WhiteHat");
        Map<String, Product> productList = new HashMap<>();
        Order o1 = new Order(productList);
        Map<String, Order> orders = new HashMap<>();
        OrderRepo orderRepo = new OrderRepo(orders);
        ProductRepo productRepo = new ProductRepo(productList);
        ShopService shopService = new ShopService(productRepo, orderRepo);
        shopService.addOrder(o1);
        Optional<Order> result = shopService.getOrder(o1.getId());

        assertEquals(result.get(), shopService.getOrder(o1.getId()).get());
    }

    @Test
    void shouldListOrders() {
        Map<String, Product> productList = new HashMap<>();
        Order o1 = new Order(productList);
        Map<String, Order> orders = new HashMap<>();
        OrderRepo orderRepo = new OrderRepo(orders);
        ProductRepo productRepo = new ProductRepo(productList);
        ShopService shopService = new ShopService(productRepo, orderRepo);
        shopService.addOrder(o1);
        List<Order> result = shopService.listOrders();

        assertTrue(result.contains(o1));
    }

}
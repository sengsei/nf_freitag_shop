package version02;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {


    @Test
    void shouldReturnExceptionProductListIsEmpty() {
        Product p1 = new ProductHat(1234, "BlackHat");
        List<Product> productList = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        ProductRepo productRepo = new ProductRepo(productList);
        OrderRepo orderRepo = new OrderRepo(orders);
        ShopService shopService = new ShopService(productRepo,orderRepo);
        Optional<Product> pWithOpt = shopService.getProduct(1);

        assertFalse(pWithOpt.isPresent());
    }

    @Test
    void shouldListProductsHats() {
        Product p1 = new ProductHat(1234, "BlackHat");
        List<Product> productList = new ArrayList<>();
        productList.add(p1);
        List<Order> orders = new ArrayList<>();
        ProductRepo productRepo = new ProductRepo(productList);
        OrderRepo orderRepo = new OrderRepo(orders);
        ShopService shopService = new ShopService(productRepo,orderRepo);

        assertTrue(productList.contains(p1), String.valueOf(shopService.listProducts().contains(p1)));
    }

    @Test
    void shouldListProductsShoes() {
        Product p1 = new ProductShoes(1234, "BlackShoe");
        List<Product> productList = new ArrayList<>();
        productList.add(p1);
        List<Order> orders = new ArrayList<>();
        ProductRepo productRepo = new ProductRepo(productList);
        OrderRepo orderRepo = new OrderRepo(orders);
        ShopService shopService = new ShopService(productRepo,orderRepo);

        assertTrue(productList.contains(p1), String.valueOf(shopService.listProducts().contains(p1)));
    }

    @Test
    void shouldGetFirstOrders() {
        Product p1 = new ProductHat(1234, "BlackHat");
        Product p2 = new ProductHat(1235, "WhiteHat");
        List<Product> productList = new ArrayList<>(Arrays.asList(p1, p2));
        Order o1 = new Order(1, productList);
        List<Order> orders = new ArrayList<>();
        OrderRepo orderRepo = new OrderRepo(orders);
        ProductRepo productRepo = new ProductRepo(productList);
        ShopService shopService = new ShopService(productRepo, orderRepo);
        shopService.addOrder(o1);
        String result = "Optional[Order{id=1, products=[ProductHat{id=1234, name='BlackHat'}, ProductHat{id=1235, name='WhiteHat'}]}]";

        assertEquals(result, shopService.getOrder(1).toString());
    }

    @Test
    void shouldListOrders() {
        List<Product> productList = new ArrayList<>();
        Order o1 = new Order(1, productList);
        List<Order> orders = new ArrayList<>();
        OrderRepo orderRepo = new OrderRepo(orders);
        ProductRepo productRepo = new ProductRepo(productList);
        ShopService shopService = new ShopService(productRepo, orderRepo);
        shopService.addOrder(o1);
        String result = "[Order{id=1, products=[]}]";

        assertEquals(result, shopService.listOrders().toString());
    }






}
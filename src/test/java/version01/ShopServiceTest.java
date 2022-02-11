package version01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    void shouldReturnOneProduct() throws Exception {
        Product p1 = new Product(1234, "BlackHat");
        List<Product> productList = new ArrayList<>();
        productList.add(p1);
        List<Order> orders = new ArrayList<>();
        ProductRepo productRepo = new ProductRepo(productList);
        OrderRepo orderRepo = new OrderRepo(orders);
        ShopService shopService = new ShopService(productRepo,orderRepo);
        shopService.getProduct(1234);

        assertEquals("BlackHat", shopService.getProduct(1234).getName());
    }

    @Test
    void shouldReturnListOfProducts(){
        Product p1 = new Product(1234, "BlackHat");
        Product p2 = new Product(1235, "WhiteHat");
        List<Product> productList = new ArrayList<>(Arrays.asList(p1, p2));
        ProductRepo productRepo = new ProductRepo(productList);
        List<Order> orders = new ArrayList<>();
        OrderRepo orderRepo = new OrderRepo(orders);
        ShopService shopService = new ShopService(productRepo, orderRepo);
        shopService.listProducts();
        String result = "[Product{id=1234, name='BlackHat'}, Product{id=1235, name='WhiteHat'}]";

        assertEquals(result, shopService.listProducts().toString());
    }

    @Test
    void shouldReturnExeptionProductListisEmpty() throws Exception {
        Product p1 = new Product(1234, "BlackHat");
        List<Product> productList = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        ProductRepo productRepo = new ProductRepo(productList);
        OrderRepo orderRepo = new OrderRepo(orders);
        ShopService shopService = new ShopService(productRepo,orderRepo);

        assertThrows(Exception.class, () -> shopService.getProduct(123));
    }

    @Test
    void shouldAddAndGetFirstOrder(){
        Product p1 = new Product(1234, "BlackHat");
        Product p2 = new Product(1235, "WhiteHat");
        List<Product> productList = new ArrayList<>(Arrays.asList(p1, p2));
        Order o1 = new Order(1, productList);
        List<Order> orders = new ArrayList<>();
        OrderRepo orderRepo = new OrderRepo(orders);
        ProductRepo productRepo = new ProductRepo(productList);
        ShopService shopService = new ShopService(productRepo, orderRepo);
        shopService.addOrder(o1);
        String result = "Order{id=1, products=[Product{id=1234, name='BlackHat'}, Product{id=1235, name='WhiteHat'}]}";

       assertEquals(result, shopService.getOrder(1).toString());
    }

    @Test
    void shouldListOrders(){
        Product p1 = new Product(1234, "BlackHat");
        Product p2 = new Product(1235, "WhiteHat");
        List<Product> productList = new ArrayList<>(Arrays.asList(p1, p2));
        Order o1 = new Order(1, productList);
        List<Order> orders = new ArrayList<>();
        OrderRepo orderRepo = new OrderRepo(orders);
        ProductRepo productRepo = new ProductRepo(productList);
        ShopService shopService = new ShopService(productRepo, orderRepo);
        shopService.addOrder(o1);
        String result = "[Order{id=1, products=[Product{id=1234, name='BlackHat'}, Product{id=1235, name='WhiteHat'}]}]";

        assertEquals(result, shopService.listOrders().toString());
    }




}
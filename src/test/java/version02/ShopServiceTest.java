package version02;

import org.junit.jupiter.api.Test;
import version01.Order;
import version01.OrderRepo;
import version01.Product;
import version01.ProductRepo;
import version01.ShopService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {
    @Test
    void shouldReturnOneProduct() throws Exception {
        version01.Product p1 = new version01.Product(1234, "BlackHat");
        List<version01.Product> productList = new ArrayList<>();
        productList.add(p1);
        List<version01.Order> orders = new ArrayList<>();
        version01.ProductRepo productRepo = new version01.ProductRepo(productList);
        version01.OrderRepo orderRepo = new version01.OrderRepo(orders);
        version01.ShopService shopService = new version01.ShopService(productRepo,orderRepo);
        shopService.getProduct(1234);

        assertEquals("BlackHat", shopService.getProduct(1234).getName());
    }

    @Test
    void shouldReturnListOfProducts(){
        version01.Product p1 = new version01.Product(1234, "BlackHat");
        version01.Product p2 = new version01.Product(1235, "WhiteHat");
        List<version01.Product> productList = new ArrayList<>(Arrays.asList(p1, p2));
        version01.ProductRepo productRepo = new version01.ProductRepo(productList);
        List<version01.Order> orders = new ArrayList<>();
        version01.OrderRepo orderRepo = new version01.OrderRepo(orders);
        version01.ShopService shopService = new version01.ShopService(productRepo, orderRepo);
        shopService.listProducts();
        String result = "[Product{id=1234, name='BlackHat'}, Product{id=1235, name='WhiteHat'}]";

        assertEquals(result, shopService.listProducts().toString());
    }

    @Test
    void shouldReturnExeptionProductListisEmpty() throws Exception {
        version01.Product p1 = new version01.Product(1234, "BlackHat");
        List<version01.Product> productList = new ArrayList<>();
        List<version01.Order> orders = new ArrayList<>();
        version01.ProductRepo productRepo = new version01.ProductRepo(productList);
        version01.OrderRepo orderRepo = new version01.OrderRepo(orders);
        version01.ShopService shopService = new version01.ShopService(productRepo,orderRepo);

        assertThrows(Exception.class, () -> shopService.getProduct(123));
    }

    @Test
    void shouldAddAndGetFirstOrder(){
        version01.Product p1 = new version01.Product(1234, "BlackHat");
        version01.Product p2 = new version01.Product(1235, "WhiteHat");
        List<version01.Product> productList = new ArrayList<>(Arrays.asList(p1, p2));
        version01.Order o1 = new version01.Order(1, productList);
        List<version01.Order> orders = new ArrayList<>();
        version01.OrderRepo orderRepo = new version01.OrderRepo(orders);
        version01.ProductRepo productRepo = new version01.ProductRepo(productList);
        version01.ShopService shopService = new version01.ShopService(productRepo, orderRepo);
        shopService.addOrder(o1);
        String result = "Order{id=1, products=[Product{id=1234, name='BlackHat'}, Product{id=1235, name='WhiteHat'}]}";

        assertEquals(result, shopService.getOrder(1).toString());
    }

    @Test
    void shouldListOrders(){
        version01.Product p1 = new version01.Product(1234, "BlackHat");
        version01.Product p2 = new version01.Product(1235, "WhiteHat");
        List<Product> productList = new ArrayList<>(Arrays.asList(p1, p2));
        version01.Order o1 = new version01.Order(1, productList);
        List<Order> orders = new ArrayList<>();
        version01.OrderRepo orderRepo = new OrderRepo(orders);
        version01.ProductRepo productRepo = new ProductRepo(productList);
        version01.ShopService shopService = new ShopService(productRepo, orderRepo);
        shopService.addOrder(o1);
        String result = "[Order{id=1, products=[Product{id=1234, name='BlackHat'}, Product{id=1235, name='WhiteHat'}]}]";

        assertEquals(result, shopService.listOrders().toString());
    }


}
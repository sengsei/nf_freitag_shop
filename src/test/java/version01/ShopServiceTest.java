package version01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    void shouldReturnOneProduct(){
        Product p1 = new Product(1234, "BlackHat");
        List<Product> productList = new ArrayList<>();
        productList.add(p1);
        ProductRepo productRepo = new ProductRepo(productList);
        OrderRepo orderRepo = new OrderRepo();
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
        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);
        shopService.listProducts();

        assertEquals("[Product{id=1234, name='BlackHat'}, Product{id=1235, name='WhiteHat'}]", shopService.listProducts().toString());


    }

}
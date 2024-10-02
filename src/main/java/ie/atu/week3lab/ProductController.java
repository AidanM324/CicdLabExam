package ie.atu.week3lab;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;
@RestController

public class ProductController {
    private List<Product> products = new ArrayList<>();

    public ProductController(){
        products.add(new Product("Tv", "made by Sony", "Electronics", 101));
        products.add(new Product("Radio", "made by Sony", "Electronics", 102));

    }

    @GetMapping("/getProducts")
    public List<Product> getProducts()
    {
        return products;
    }

    @PostMapping("addProduct")
    public ResponseEntity<List> addProduct(@RequestBody Product product)
    {
        products.add(product);
        return ResponseEntity.ok(products);
    }
}

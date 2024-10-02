package ie.atu.week3lab;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
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

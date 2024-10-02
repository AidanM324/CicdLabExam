package ie.atu.week3lab;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
@RestController

public class ProductController {
    private List<Product> products = new ArrayList<>();

    public ProductController(){
        products.add(new Product("Tv", "made by Sony", 101, 101));
        products.add(new Product("Radio", "made by Sony", 102, 102));

    }

    @GetMapping("/getProducts")
    public List<Product> getProducts()
    {
        return products;
    }

    @PostMapping("/addProduct")
    public ResponseEntity<List> addProduct(@RequestBody Product product)
    {
        products.add(product);
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{id}")
    public String putId(@RequestParam int id, @RequestBody Product product)
    {
        return "product is being updated";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable long id) {
        int num = (int) id;

        for (int count = 0; count < products.size(); count++) {
            if (products.get(count).getId() == num) {
                products.remove(count);
            }
        }
        return ResponseEntity.ok(products);
    }
}

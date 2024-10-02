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
    public ResponseEntity<List> editProduct(@PathVariable int id, @RequestBody Product product)
    {
       for(int i = 0; i< products.size(); i++){
           if(products.get(i).getId() == id){
               products.set(i, product);
           }
       }
       return ResponseEntity.ok(products);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List> deleteProduct(@PathVariable int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(id);
            }
        }
        return ResponseEntity.ok(products);
    }
}

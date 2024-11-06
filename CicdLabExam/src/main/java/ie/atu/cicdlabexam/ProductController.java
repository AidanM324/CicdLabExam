package ie.atu.cicdlabexam;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.ArrayList;

@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products:")
    public List<Product> getProducts(){return productService.getProducts();}


    @PostMapping("/addProduct")
    public List<Product> addProduct(@Valid @RequestBody Product product){
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public List<Product> editProduct(@Valid @PathVariable int id, @RequestBody Product product)
    {
        return productService.editProduct(product, id);
    }

    @DeleteMapping("/delete/{id}")
    public List<Product> deleteProduct(@Valid @PathVariable int id){
        return productService.deleteProduct(id);
    }

}

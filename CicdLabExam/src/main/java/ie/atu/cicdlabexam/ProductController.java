package ie.atu.cicdlabexam;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{productCode}")
    public List<Product> getProducts(@Valid @RequestBody String productCode ){return productService.getProducts();}


    @PostMapping("/products")
    public List<Product> addProduct(@Valid @RequestBody Product product){
        return productService.addProduct(product);
    }

    @PutMapping("/products/{productCode}")
    public List<Product> editProduct(@Valid @RequestBody String productCode, @RequestBody Product product)
    {
        return productService.editProduct(product, productCode);
    }

    @DeleteMapping("/products/{productCode}")
    public List<Product> deleteProduct(@Valid @RequestBody String productCode){
        return productService.deleteProduct(productCode);
    }

}

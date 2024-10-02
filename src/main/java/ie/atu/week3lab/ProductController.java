package ie.atu.week3lab;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")

public class ProductController {
    private List<Product> products = new ArrayList<>();

    public ProductController(){
        products.add(new Product("Tv", "made by Sony", 899, 101));
        products.add(new Product("Radio", "made by Sony", 99, 102));

    }

    @GetMapping("/getProducts")
    public String getProducts()
    {
        return products;
    }
}

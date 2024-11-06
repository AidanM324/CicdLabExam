package ie.atu.cicdlabexam;


import lombok.Data;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.ArrayList;

@Data
@Service
public class ProductService {
    private List<Product> productList = new ArrayList<>();

    public List<Product> getProducts(){return productList;}

    public List<Product> addProduct(Product product) {
        productList.add(product);
        return productList;
    }

    public List<Product> editProduct(Product product, int id) {
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getId() == id) {
                productList.set(i, product);
            }
        }
    return productList;
    }

    public List<Product> deleteProduct(int id){
        for(int i = 0; i< productList.size(); i++){
            if(productList.get(i).getId() == id){
                productList.remove(i);
            }
        }
        return productList;
    }


    }





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

    public List<Product> addProduct(Product product, String productCode) {
        if(productList.contains(productCode)){
            throw new DuplicateProductCodeException("productCode" + productCode + "already exists.");
        }
        productList.add(product);
        return productList;
    }

    public List<Product> editProduct(Product product, String productCode) {
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getProductCode() == productCode) {
                productList.set(i, product);
            }
        }
    return productList;
    }

    public List<Product> deleteProduct(String productCode){
        for(int i = 0; i< productList.size(); i++){
            if(productList.get(i).getProductCode() == productCode){
                productList.remove(i);
            }
        }
        return productList;
    }


    }





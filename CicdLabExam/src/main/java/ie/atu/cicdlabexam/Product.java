package ie.atu.cicdlabexam;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Pattern(regexp = "PROD-XXXX", message = "ProductCode must be in the format PROD-XXXX")
    private String productCode;
    @Size(max=100, message = "must be max 100 characters")
    private String productName;

    private String category;
    @Min(value=1, message= "Must be a positive value")
    private int quantityInStock;
    @Min(value=1, message= "Must be greater or equal to 1")
    private float price;






}

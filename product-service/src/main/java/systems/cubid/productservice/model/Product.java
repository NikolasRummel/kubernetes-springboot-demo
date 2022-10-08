package systems.cubid.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Nikolas Rummel
 * @since 25.09.22
 */
@Data
@AllArgsConstructor
public class Product {

    private Long id;
    private String name;
    private String description;
    private String imageLink;
    private String creator;
    private ProductType productType;
    private long productCreated;
    private double price;


}

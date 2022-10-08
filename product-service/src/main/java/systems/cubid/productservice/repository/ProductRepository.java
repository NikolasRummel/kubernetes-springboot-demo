package systems.cubid.productservice.repository;

import java.util.ArrayList;
import java.util.List;
import systems.cubid.productservice.model.Product;

/**
 * @author Nikolas Rummel
 * @since 25.09.22
 */
public class ProductRepository {

    private List<Product> products = new ArrayList<>();

    public Product add(Product product) {
        product.setId((long) (products.size()+1));
        products.add(product);
        return product;
    }

    public Product remove(Product product) {
        products.remove(product);
        return product;
    }

    public Product findById(Long id) {
        return products.stream()
            .filter(product -> product.getId().equals(id))
            .findFirst()
            .orElseThrow();
    }

    public List<Product> findAll() {
        return products;
    }

}

package systems.cubid.productservice.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import systems.cubid.productservice.model.Product;
import systems.cubid.productservice.repository.ProductRepository;

/**
 * @author Nikolas Rummel
 * @since 25.09.22
 */
@RestController
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public List<Product> getAllUsers() {
        LOGGER.info("Find all products");
        return productRepository.findAll();
    }

    @PostMapping("/")
    public Product add(@RequestBody Product product) {
        LOGGER.info("Add product: {}", product);
        return productRepository.add(product);
    }

    @DeleteMapping("/")
    public Product delete(@RequestBody Product product) {
        LOGGER.info("Delete product: {}", product);
        return productRepository.remove(product);
    }
}

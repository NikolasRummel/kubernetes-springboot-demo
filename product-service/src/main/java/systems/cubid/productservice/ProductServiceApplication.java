package systems.cubid.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import systems.cubid.productservice.model.Product;
import systems.cubid.productservice.model.ProductType;
import systems.cubid.productservice.repository.ProductRepository;

@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    ProductRepository userRepository() {
        ProductRepository repository = new ProductRepository();
        repository.add(
            new Product(-1L, "exampleProject", "description", "http://google.com/example.img",
                "CubePixels", ProductType.STANDALONE, 0L, 4.99));
        return repository;
    }

}

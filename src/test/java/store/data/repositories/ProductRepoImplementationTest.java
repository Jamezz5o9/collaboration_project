package store.data.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import store.data.models.Category;
import store.data.models.Product;
import store.exceptions.InvalidProduct;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoImplementationTest {
    private ProductRepository productRepository = new ProductRepoImplementation();
    private Product product;
    private Product product1;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setCategory(Category.CAR);
        product.setQuantity(200);
        product.setName("Honda");
        product.setPrice(BigDecimal.valueOf(5000));

        product1 = new Product();
        product1.setCategory(Category.FASHION);
        product1.setQuantity(5);
        product1.setName("Ankara");
        product1.setPrice(BigDecimal.valueOf(500));
    }

    @Test
    void save() {
        Product savedProduct = productRepository.save(product);
        Product savedProduct1 = productRepository.save(product1);
        assertEquals("Honda", product.getName());
        assertNotNull(savedProduct);
        assertEquals(1, savedProduct.getId());
        assertEquals(2, savedProduct1.getId());
    }

    @Test
    void delete() {
        Product savedProduct = productRepository.save(product);
        Product savedProduct1 = productRepository.save(product);
        productRepository.delete(savedProduct);
        productRepository.delete(savedProduct1);
        assertThrows(InvalidProduct.class, () -> productRepository.find("Honda"));
        assertThrows(InvalidProduct.class, () -> productRepository.find("Ankara"));
    }

    @Test
    void find() {
        Product savedProduct = productRepository.save(product);
        Product savedProduct1 = productRepository.save(product1);
        Product freshProduct = productRepository.find(savedProduct.getName());
        Product freshProduct1 = productRepository.find(savedProduct1.getName());
        assertNotNull(freshProduct);
        assertNotNull(freshProduct1);
        assertEquals(savedProduct.getName(), freshProduct.getName());
        assertEquals(savedProduct1.getName(), freshProduct1.getName());


    }

    @Test
    void findAll() {
    }

    @Test
    void findByCategory() {
    }
}
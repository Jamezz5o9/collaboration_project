package store.data.repositories;

import store.data.models.Category;
import store.data.models.Product;

import java.util.List;

public interface ProductRepository {
    Product save(Product product);
    void delete(Product product);
    Product find(String name);
    List<Product> findAll();
    List<Product> findByCategory(Category category);
}

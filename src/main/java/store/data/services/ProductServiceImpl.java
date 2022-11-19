package store.data.services;

import store.data.dto.AddProductRequest;
import store.data.dto.AddProductResponse;
import store.data.models.Category;
import store.data.models.Product;
import store.data.repositories.ProductRepoImplementation;
import store.data.repositories.ProductRepository;

import java.math.BigDecimal;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository = new ProductRepoImplementation();

    @Override
    public AddProductResponse orderProduct(AddProductRequest request) {
        Product product = new Product();
        product.setPrice(BigDecimal.valueOf(request.getPrice()));
        product.setQuantity(request.getQuantity());
        product.setCategory(Category.valueOf(request.getCategory()));
        product.setName(request.getName());
        Product productSaved = productRepository.save(product);

        AddProductResponse response = new AddProductResponse();
        response.setProductName(productSaved.getName());
        response.setMessage("product successfully created");
        response.setStatusCode(200);
        return  response;
    }

    @Override
    public Product getProductByName(String name) {
       return productRepository.find(name);
    }
}

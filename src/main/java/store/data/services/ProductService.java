package store.data.services;

import store.data.dto.AddProductRequest;
import store.data.dto.AddProductResponse;
import store.data.models.Product;

public interface ProductService {
    AddProductResponse addProduct(AddProductRequest request);
    Product getProductByName(String name);
    Product updateProductInDb(Product product);
}

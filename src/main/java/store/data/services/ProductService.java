package store.data.services;

import store.data.dto.AddProductRequest;
import store.data.dto.AddProductResponse;

public interface ProductService {
    AddProductResponse orderProduct(AddProductRequest request);
    String getProductById(int id);
}

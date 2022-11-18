package store.data.repositories;

import store.data.models.Category;
import store.data.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepoImplementation implements ProductRepository{
    private final List<Product> product = new ArrayList<>();

    @Override
    public Product save(Product savedProduct) {
        if(savedProduct.getId() > 0) return  replaceProductInDB(savedProduct);
        int id = generateId();
        savedProduct.setId(id);
        product.add(savedProduct);
        return savedProduct;
    }

    private Product replaceProductInDB(Product repProduct) {
        for(int i = 0; i < product.size(); i++){
            if(product.get(i).getId() == repProduct.getId()){
                product.add(i, repProduct);
                return repProduct;
            }

        }
        throw new StoreException("Unable to replace products in the DB");
    }

    private int generateId() {
        int freshId = product.size();
        return freshId + 1;
    }

    @Override
    public void delete(Product delProduct) {
        product.remove(delProduct);
    }

    @Override
    public Product find(String name) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return null;
    }
}

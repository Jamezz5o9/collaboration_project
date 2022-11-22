package store.data.repositories;

import store.data.models.Category;
import store.data.models.Product;
import store.exceptions.InvalidProduct;
import store.exceptions.StoreException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductRepoImplementation implements ProductRepository{
    private static List<Product> product = new ArrayList<>();

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
        for (Product value : product) {
            if (Objects.equals(value.getName(), name)) return value;
        }
        throw new InvalidProduct(String.format("%s", "product with " + name  + " is not found"));

    }

    @Override
    public List<Product> findAll() {
        return product;
    }

    @Override
    public List<Product> findByCategory(Category category) {
        List<Product> freshProduct = new ArrayList<>();
        for(Product prod: product){
            if(prod.getCategory() == category)freshProduct.add(prod);
        }
        return freshProduct;
    }
}

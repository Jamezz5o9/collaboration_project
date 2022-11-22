package store.data.dto;

import lombok.Data;
import store.data.models.Category;

@Data
public class ProductOrderRequest {
    private int customerId;
    private String productName;
    private int quantity;
    private Category category;

}

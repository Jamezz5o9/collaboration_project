package store.data.dto;

import lombok.Data;
import store.data.models.Category;

import java.math.BigDecimal;

@Data
public class AddProductRequest {
    private String name;
    private BigDecimal price;
    private Category category;
    private int quantity;
}

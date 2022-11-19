package store.data.dto;

import lombok.Data;

@Data
public class ProductOrderRequest {
    private int customerId;
    private int productName;
    private int quantity;

}

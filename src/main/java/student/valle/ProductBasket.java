package student.valle;

import lombok.Getter;

import java.util.List;

@Getter
public class ProductBasket {
    private final List<Product> productList;

    public ProductBasket(List<Product> productList) {
        this.productList = productList;
    }

    public Double calculateTaxedAmount() {
        if (!this.productList.isEmpty()) return this.productList.get(0).calculateTaxedPrice();
        return 0.0;
    }
}

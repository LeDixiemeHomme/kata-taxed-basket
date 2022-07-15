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
        return productList.stream().mapToDouble(Product::calculateTaxedPrice).sum();
    }

    public Double calculateTaxesOnly() {
        return 0.0;
    }
}

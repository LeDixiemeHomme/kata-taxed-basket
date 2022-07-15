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
        if (this.productList.isEmpty()) return 0.0;
        return this.productList.stream().mapToDouble(Product::calculateTaxedPrice).sum();
    }

    public Double calculateTaxesOnly() {
        if (this.productList.isEmpty()) return 0.0;
        return this.productList.stream().mapToDouble(Product::calculateTaxeOnly).sum() ;
    }
}

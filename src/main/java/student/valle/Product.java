package student.valle;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Product {
    private Double price;
    private List<ProductType> types;
    private String name;

    public Double calculateTaxedPrice() {
        if (types.contains(ProductType.BOOK)) return new Amount( price + (price * 10.00/100)).getRoundedValue();

        return price;
    }
}

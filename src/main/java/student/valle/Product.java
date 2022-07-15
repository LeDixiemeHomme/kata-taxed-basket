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
    private Integer quantity;

    public Double calculateTaxedPrice() {
        Integer quantityRef;
        if (quantity != null) {
            quantityRef = this.quantity;
        } else {
            quantityRef = 1;
        }

        Amount refAmount;

        if (types.contains(ProductType.BOOK)) {
            refAmount = new Amount(price + (price * 10.00 / 100));
        } else if (types.contains(ProductType.BASIC_NECESSITIES)) {
            refAmount = new Amount(price);
        } else {
            refAmount = new Amount(price + (price * 20.00/100));
        }

        if (types.contains(ProductType.IMPORTED)) return refAmount.getRoundedValue() + new Amount(price * 5.00 / 100).getRoundedValue();

        return refAmount.getRoundedValue() * quantityRef;
    }

    public Double calculateTaxeOnly() {
        Integer quantityRef;
        if (quantity != null) {
            quantityRef = this.quantity;
        } else {
            quantityRef = 1;
        }
        return this.calculateTaxedPrice() - this.price * quantityRef;
    }
}

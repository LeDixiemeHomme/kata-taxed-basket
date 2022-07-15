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

    private Double getTvaByProductType(List<ProductType> types) {
        if (types.contains(ProductType.BASIC_NECESSITIES)) {
            return 0.00;
        } else if (types.contains(ProductType.BOOK)) {
            return 0.10;
        } else {
            return 0.20;
        }
    }

    private Double getTiByProductType(List<ProductType> types) {
        if (types.contains(ProductType.IMPORTED)) {
            return 0.05;
        } else {
            return 0.00;
        }
    }

    public Double calculateTaxedPrice() {
        Double tva = this.getTvaByProductType(this.types);
        Double ti = this.getTiByProductType(this.types);

        Integer quantityRef;
        if (this.quantity != null) {
            quantityRef = this.quantity;
        } else {
            quantityRef = 1;
        }

        Double unitPrice = this.price + new Amount(this.price * tva).getRoundedValue() + new Amount(this.price * ti).getRoundedValue();

        return new Amount(unitPrice * quantityRef).getValue();
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

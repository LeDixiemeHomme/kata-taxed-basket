package student.valle;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@Builder
@Getter
public class Product {
    @NonNull
    private Double price;
    @NonNull
    private List<ProductType> types;
    @NonNull
    private String name;
    @NonNull
    private final Integer quantity;

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

        Double unitPrice = this.price + new Amount(this.price * tva).getRoundedValue() + new Amount(this.price * ti).getRoundedValue();

        return new Amount(unitPrice * this.quantity).getValue();
    }

    public Double calculateTaxeOnly() {
        return this.calculateTaxedPrice() - this.amountTaxeFree();
    }

    private Double amountTaxeFree() {
        return this.price * this.quantity;
    }
}

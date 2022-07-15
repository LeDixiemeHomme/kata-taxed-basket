package student.valle;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class ReceiptPrinter {
    @NonNull
    private final ProductBasket productBasket;

    public ReceiptPrinter(ProductBasket productBasket) {
        this.productBasket = productBasket;
    }

    public String printBasketReceipt() {

        return this.printProductBasket(this.productBasket) +
                "Montant des taxes : " + this.productBasket.calculateTaxesOnly() + "\n" +
                "\n" +
                "Total : " + this.productBasket.calculateTaxedAmount();
    }

    private String printOneProduct(Product product) {
        return product.getQuantity() + " " + product.getName() + " à " + product.getPrice() + " : " + product.calculateTaxedPrice() + "\n";
    }

    private String printProductBasket(ProductBasket productBasket) {
        StringBuilder sb = new StringBuilder();
        productBasket.getProductList().forEach(product -> sb.append(this.printOneProduct(product)));
        return sb.toString();
    }
}

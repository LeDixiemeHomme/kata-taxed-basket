package student.valle;

import lombok.Getter;

@Getter
public class ReceiptPrinter {
    private ProductBasket productBasket;

    public ReceiptPrinter(ProductBasket productBasket) {
        this.productBasket = productBasket;
    }

    public String printBasketReceipt() {
        if (this.productBasket.getProductList().isEmpty())
        return "\n" +
                "Montant des taxes : 0.00\n" +
                "\n" +
                "Total : 0.00";

        return this.printOneProduct(this.productBasket.getProductList().get(0)) +
                "Montant des taxes : " + this.productBasket.calculateTaxesOnly() + "\n" +
                "\n" +
                "Total : " + this.productBasket.calculateTaxedAmount();
    }

    private String printOneProduct(Product product) {
        Integer quantityRef;
        if (product.getQuantity() != null) {
            quantityRef = product.getQuantity();
        } else {
            quantityRef = 1;
        }

        return quantityRef.toString() + " " + product.getName() + " à " + product.getPrice() + " : " + product.calculateTaxedPrice() + "\n";
    }
}

package student.valle;

import lombok.Getter;

@Getter
public class ReceiptPrinter {
    private ProductBasket productBasket;

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
        Integer quantityRef;
        if (product.getQuantity() != null) {
            quantityRef = product.getQuantity();
        } else {
            quantityRef = 1;
        }

        return quantityRef.toString() + " " + product.getName() + " à " + product.getPrice() + " : " + product.calculateTaxedPrice() + "\n";
    }

    private String printProductBasket(ProductBasket productBasket) {
        StringBuilder sb = new StringBuilder();
        productBasket.getProductList().forEach(product -> sb.append(this.printOneProduct(product)));
        return sb.toString();
    }
}

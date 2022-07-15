package student.valle;

import lombok.Getter;

@Getter
public class ReceiptPrinter {
    private ProductBasket productBasket;

    public ReceiptPrinter(ProductBasket productBasket) {
        this.productBasket = productBasket;
    }

    public String printBasketReceipt() {
        return "\n" +
                "Montant des taxes : 0.00\n" +
                "\n" +
                "Total : 0.00";
    }
}

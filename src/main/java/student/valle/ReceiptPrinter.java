package student.valle;

import lombok.Getter;

@Getter
public class ReceiptPrinter {
    private ProductBasket productBasket;

    public ReceiptPrinter(ProductBasket productBasket) {
        this.productBasket = productBasket;
    }

    public String printBasketReceipt() {
        return "Empty basket";
    }
}

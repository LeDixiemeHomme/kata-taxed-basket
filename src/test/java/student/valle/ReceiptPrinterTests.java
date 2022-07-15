package student.valle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiptPrinterTests {

    @Test
    void printReceiptWithNoProduct() {
        ProductBasket productBasket = new ProductBasket(Arrays.asList());

        ReceiptPrinter receiptPrinter = new ReceiptPrinter(productBasket);

        assertEquals("Empty basket", receiptPrinter.printBasketReceipt());
    }
}

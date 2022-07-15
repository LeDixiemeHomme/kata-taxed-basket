package student.valle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiptPrinterTests {

    @Test
    void printReceiptWithNoProduct() {
        ProductBasket productBasket = new ProductBasket(Arrays.asList());

        ReceiptPrinter receiptPrinter = new ReceiptPrinter(productBasket);

        assertEquals("\n" +
                "Montant des taxes : 0.00\n" +
                "\n" +
                "Total : 0.00", receiptPrinter.printBasketReceipt());
    }

    @Test
    void printReceiptWithOneProduct() {
        Product product = Product.builder().name("Boxe of headache drug").types(Arrays.asList(ProductType.BASIC_NECESSITIES)).price(9.75).quantity(3).build();
        ProductBasket productBasket = new ProductBasket(Arrays.asList(product));

        ReceiptPrinter receiptPrinter = new ReceiptPrinter(productBasket);

        assertEquals("3 Boxe of headache drug à 9.75 : 29.25\n" +
                "Montant des taxes : 0.0\n" +
                "\n" +
                "Total : 29.25", receiptPrinter.printBasketReceipt());
    }
}

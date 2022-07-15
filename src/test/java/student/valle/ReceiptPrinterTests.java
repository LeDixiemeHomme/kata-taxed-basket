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
        Product product = Product.builder().name("book").types(Arrays.asList(ProductType.BOOK)).price(25.00).build();
        ProductBasket productBasket = new ProductBasket(Arrays.asList(product));

        ReceiptPrinter receiptPrinter = new ReceiptPrinter(productBasket);

        assertEquals("1 book à 25.00 : 27.50\n" +
                "Montant des taxes : 2.50\n" +
                "\n" +
                "Total : 27.50", receiptPrinter.printBasketReceipt());
    }
}

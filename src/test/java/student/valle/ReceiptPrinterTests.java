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

    @Test
    void printReceiptWithTwoProducts() {
        Product product1 = Product.builder().name("Chocolate boxe").types(Arrays.asList(ProductType.BASIC_NECESSITIES, ProductType.IMPORTED)).price(10.00).quantity(2).build();
        Product product2 = Product.builder().name("Bottle of parfum").types(Arrays.asList(ProductType.IMPORTED)).price(47.50).quantity(3).build();
        ProductBasket productBasket = new ProductBasket(Arrays.asList(product1, product2));

        ReceiptPrinter receiptPrinter = new ReceiptPrinter(productBasket);

        assertEquals("2 Chocolate boxe à 10.0 : 21.0\n" +"3 Bottle of parfum à 47.5 : 178.2\n" +
                "Montant des taxes : 36.7\n" +
                "\n" +
                "Total : 199.2", receiptPrinter.printBasketReceipt());
    }
}

package student.valle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTests {

    @Test
    void getTaxedBasicNecessitiesProduct() {
        Product product = Product.builder().name("drug").types(Arrays.asList(ProductType.BASIC_NECESSITIES)).price(10.00).build();
        assertEquals(10.00, product.calculateTaxedPrice());
    }

    @Test
    void getTaxedBookProduct() {
        Product product = Product.builder().name("book").types(Arrays.asList(ProductType.BOOK)).price(10.00).build();
        Product product2 = Product.builder().name("book").types(Arrays.asList(ProductType.BOOK)).price(25.00).build();
        assertEquals(11.00, product.calculateTaxedPrice());
        assertEquals(27.50, product2.calculateTaxedPrice());
    }

    @Test
    void getTaxedRegularProduct() {
        Product product = Product.builder().name("regular").types(Arrays.asList()).price(10.00).build();
        Product product2 = Product.builder().name("regular").types(Arrays.asList()).price(25.00).build();
        assertEquals(12.00, product.calculateTaxedPrice());
        assertEquals(30.00, product2.calculateTaxedPrice());
    }

    @Test
    void getTaxedImportedBasicNecessitiesProduct() {
        Product product = Product.builder().name("drug").types(Arrays.asList(ProductType.BASIC_NECESSITIES, ProductType.IMPORTED)).price(10.00).build();
        Product product2 = Product.builder().name("drug").types(Arrays.asList(ProductType.BASIC_NECESSITIES, ProductType.IMPORTED)).price(25.00).build();
        assertEquals(10.50, product.calculateTaxedPrice());
        assertEquals(26.25, product2.calculateTaxedPrice());
    }

    @Test
    void getTaxedImportedBookProduct() {
        Product product = Product.builder().name("book").types(Arrays.asList(ProductType.BOOK, ProductType.IMPORTED)).price(10.00).build();
        Product product2 = Product.builder().name("book").types(Arrays.asList(ProductType.BOOK, ProductType.IMPORTED)).price(25.00).build();
        assertEquals(11.50, product.calculateTaxedPrice());
        assertEquals(28.75, product2.calculateTaxedPrice());
    }

    @Test
    void getTaxedImportedRegularProduct() {
        Product product = Product.builder().name("regular").types(Arrays.asList(ProductType.IMPORTED)).price(10.00).build();
        Product product2 = Product.builder().name("regular").types(Arrays.asList(ProductType.IMPORTED)).price(25.00).build();
        assertEquals(12.50, product.calculateTaxedPrice());
        assertEquals(31.25, product2.calculateTaxedPrice());
    }

    @Test
    void getAmountWithOneQuantity() {
        Product product = Product.builder().name("drug").types(Arrays.asList(ProductType.BASIC_NECESSITIES)).price(10.00).quantity(1).build();
        assertEquals(10.00, product.calculateTaxedPrice());
    }

}

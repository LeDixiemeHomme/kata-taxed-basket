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

}

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

}

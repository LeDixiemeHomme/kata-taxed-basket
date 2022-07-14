package student.valle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductBasketTests {

    @Test
    void getAmountOfBasketWithNoProduct() {
        ProductBasket productBasket = new ProductBasket(Arrays.asList());

        assertEquals(0.0, productBasket.calculateTaxedAmount());
    }
}

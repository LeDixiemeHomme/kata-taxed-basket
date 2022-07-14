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

    @Test
    void getAmountOfBasketWithOneProduct() {
        Product product = Product.builder().name("book").types(Arrays.asList(ProductType.BOOK)).price(25.00).build();
        ProductBasket productBasket = new ProductBasket(Arrays.asList(product));

        assertEquals(27.50, productBasket.calculateTaxedAmount());
    }
}

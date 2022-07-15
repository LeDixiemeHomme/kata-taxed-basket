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

    @Test
    void getAmountOfBasketWithTwoProducts() {
        Product product = Product.builder().name("book").types(Arrays.asList(ProductType.BOOK)).price(10.00).build();
        Product product2 = Product.builder().name("book").types(Arrays.asList(ProductType.BOOK)).price(25.00).build();
        ProductBasket productBasket = new ProductBasket(Arrays.asList(product, product2));

        assertEquals(38.50, productBasket.calculateTaxedAmount());
    }

    @Test
    void getAmountOfBasketTaxesWithNoProduct() {
        ProductBasket productBasket = new ProductBasket(Arrays.asList());

        assertEquals(0.0, productBasket.calculateTaxesOnly());
    }

    @Test
    void getAmountOfBasketTaxesWithOneProduct() {
        Product product = Product.builder().name("book").types(Arrays.asList(ProductType.BOOK)).price(25.00).build();
        ProductBasket productBasket = new ProductBasket(Arrays.asList(product));

        assertEquals(2.50, productBasket.calculateTaxesOnly());
    }

    @Test
    void getAmountOfBasketTaxesWithTwoProducts() {
        Product product = Product.builder().name("book").types(Arrays.asList(ProductType.BOOK)).price(10.00).build();
        Product product2 = Product.builder().name("book").types(Arrays.asList(ProductType.BOOK)).price(25.00).build();
        ProductBasket productBasket = new ProductBasket(Arrays.asList(product, product2));

        assertEquals(3.50, productBasket.calculateTaxesOnly());
    }
}

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

    @Test
    void getAmountOfBasketExampleOne() {
        Product product1 = Product.builder().name("book").types(Arrays.asList(ProductType.BOOK)).price(12.49).quantity(2).build();
        Product product2 = Product.builder().name("CD").types(Arrays.asList()).price(14.99).quantity(1).build();
        Product product3 = Product.builder().name("Chocolate bar").types(Arrays.asList(ProductType.BASIC_NECESSITIES)).price(0.85).quantity(3).build();

        ProductBasket productBasket = new ProductBasket(Arrays.asList(product1, product2, product3));

        assertEquals(48.02, productBasket.calculateTaxedAmount());
        assertEquals(5.50, productBasket.calculateTaxesOnly());
    }

    @Test
    void getAmountOfBasketExampleTwo() {
        Product product1 = Product.builder().name("Chocolate boxe").types(Arrays.asList(ProductType.BASIC_NECESSITIES, ProductType.IMPORTED)).price(10.00).quantity(2).build();
        Product product2 = Product.builder().name("Bottle of parfum").types(Arrays.asList(ProductType.IMPORTED)).price(47.50).quantity(3).build();

        ProductBasket productBasket = new ProductBasket(Arrays.asList(product1, product2));

        assertEquals(199.20, productBasket.calculateTaxedAmount());
        assertEquals(36.70, productBasket.calculateTaxesOnly());
    }

    @Test
    void getAmountOfBasketExampleThree() {
        Product product1 = Product.builder().name("Bottle of parfum").types(Arrays.asList(ProductType.IMPORTED)).price(27.99).quantity(2).build();
        Product product2 = Product.builder().name("Bottle of parfum").types(Arrays.asList()).price(18.99).quantity(1).build();
        Product product3 = Product.builder().name("Boxe of headache drug").types(Arrays.asList(ProductType.BASIC_NECESSITIES)).price(9.75).quantity(3).build();
        Product product4 = Product.builder().name("Chocolate boxe").types(Arrays.asList(ProductType.BASIC_NECESSITIES, ProductType.IMPORTED)).price(11.25).quantity(2).build();

        ProductBasket productBasket = new ProductBasket(Arrays.asList(product1, product2, product3, product4));

        assertEquals(145.72, productBasket.calculateTaxedAmount());
        assertEquals(19.00, productBasket.calculateTaxesOnly());
    }
}

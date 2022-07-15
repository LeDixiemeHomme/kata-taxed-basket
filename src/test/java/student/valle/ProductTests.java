package student.valle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTests {

    @Test
    void getTaxedBasicNecessitiesProduct() {
        Product product = Product.builder().name("drug").types(Arrays.asList(ProductType.BASIC_NECESSITIES)).price(10.00).quantity(1).build();
        assertEquals(10.00, product.calculateTaxedPrice());
    }

    @Test
    void getTaxedBookProduct() {
        Product product = Product.builder().name("book").types(Arrays.asList(ProductType.BOOK)).price(10.00).quantity(1).build();
        Product product2 = Product.builder().name("book").types(Arrays.asList(ProductType.BOOK)).price(25.00).quantity(1).build();
        assertEquals(11.00, product.calculateTaxedPrice());
        assertEquals(27.50, product2.calculateTaxedPrice());
    }

    @Test
    void getTaxedRegularProduct() {
        Product product = Product.builder().name("regular").types(Arrays.asList()).price(10.00).quantity(1).build();
        Product product2 = Product.builder().name("regular").types(Arrays.asList()).price(25.00).quantity(1).build();
        assertEquals(12.00, product.calculateTaxedPrice());
        assertEquals(30.00, product2.calculateTaxedPrice());
    }

    @Test
    void getTaxedImportedBasicNecessitiesProduct() {
        Product product = Product.builder().name("drug").types(Arrays.asList(ProductType.BASIC_NECESSITIES, ProductType.IMPORTED)).price(10.00).quantity(1).build();
        Product product2 = Product.builder().name("drug").types(Arrays.asList(ProductType.BASIC_NECESSITIES, ProductType.IMPORTED)).price(25.00).quantity(1).build();
        assertEquals(10.50, product.calculateTaxedPrice());
        assertEquals(26.25, product2.calculateTaxedPrice());
    }

    @Test
    void getTaxedImportedBookProduct() {
        Product product = Product.builder().name("book").types(Arrays.asList(ProductType.BOOK, ProductType.IMPORTED)).price(10.00).quantity(1).build();
        Product product2 = Product.builder().name("book").types(Arrays.asList(ProductType.BOOK, ProductType.IMPORTED)).price(25.00).quantity(1).build();
        assertEquals(11.50, product.calculateTaxedPrice());
        assertEquals(28.75, product2.calculateTaxedPrice());
    }

    @Test
    void getTaxedImportedRegularProduct() {
        Product product = Product.builder().name("regular").types(Arrays.asList(ProductType.IMPORTED)).price(10.00).quantity(1).build();
        Product product2 = Product.builder().name("regular").types(Arrays.asList(ProductType.IMPORTED)).price(25.00).quantity(1).build();
        assertEquals(12.50, product.calculateTaxedPrice());
        assertEquals(31.25, product2.calculateTaxedPrice());
    }

    @Test
    void getAmountWithOneQuantity() {
        Product product = Product.builder().name("drug").types(Arrays.asList(ProductType.BASIC_NECESSITIES)).price(10.00).quantity(1).build();
        assertEquals(10.00, product.calculateTaxedPrice());
    }

    @Test
    void getAmountWithTwoQuantity() {
        Product product = Product.builder().name("drug").types(Arrays.asList(ProductType.BASIC_NECESSITIES)).price(10.00).quantity(2).build();
        assertEquals(20.00, product.calculateTaxedPrice());
    }

    @Test
    void getAmountOfTwoBooks() {
        Product product = Product.builder().name("book").types(Arrays.asList(ProductType.BOOK)).price(12.49).quantity(2).build();
        assertEquals(27.48, product.calculateTaxedPrice());
    }

    @Test
    void getAmountOfOneCD() {
        Product product = Product.builder().name("CD").types(Arrays.asList()).price(14.99).quantity(1).build();
        assertEquals(17.99, product.calculateTaxedPrice());
    }

    @Test
    void getAmountOfThreeChocolateBar() {
        Product product = Product.builder().name("Chocolate bar").types(Arrays.asList(ProductType.BASIC_NECESSITIES)).price(0.85).quantity(3).build();
        assertEquals(2.55, product.calculateTaxedPrice());
    }

    @Test
    void getAmountOfTwoImportedChocolateBoxes() {
        Product product = Product.builder().name("Chocolate boxe").types(Arrays.asList(ProductType.BASIC_NECESSITIES, ProductType.IMPORTED)).price(10.00).quantity(2).build();
        assertEquals(21.00, product.calculateTaxedPrice());
    }

    @Test
    void getAmountOfThreeImportedBottleOfParfum() {
        Product product = Product.builder().name("Bottle of parfum").types(Arrays.asList(ProductType.IMPORTED)).price(47.50).quantity(3).build();
        assertEquals(178.2, product.calculateTaxedPrice());
    }

    @Test
    void getAmountOfTwoImportedBottleOfParfum() {
        Product product = Product.builder().name("Bottle of parfum").types(Arrays.asList(ProductType.IMPORTED)).price(27.99).quantity(2).build();
        assertEquals(69.98, product.calculateTaxedPrice());
    }

    @Test
    void getAmountOfOneBottleOfParfum() {
        Product product = Product.builder().name("Bottle of parfum").types(Arrays.asList()).price(18.99).quantity(1).build();
        assertEquals(22.79, product.calculateTaxedPrice());
    }

    @Test
    void getAmountOfThreeBoxesOfHeadacheDrug() {
        Product product = Product.builder().name("Boxe of headache drug").types(Arrays.asList(ProductType.BASIC_NECESSITIES)).price(9.75).quantity(3).build();
        assertEquals(29.25, product.calculateTaxedPrice());
    }

    @Test
    void getAmountOfTwoImportedChocolateBoxesBis() {
        Product product = Product.builder().name("Chocolate boxe").types(Arrays.asList(ProductType.BASIC_NECESSITIES, ProductType.IMPORTED)).price(11.25).quantity(2).build();
        assertEquals(23.70, product.calculateTaxedPrice());
    }
}

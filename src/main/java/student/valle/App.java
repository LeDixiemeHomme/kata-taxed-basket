package student.valle;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Product product1B1 = Product.builder().name("livres").quantity(2).types(Arrays.asList(ProductType.BOOK)).price(12.49).build();
        Product product2B1 = Product.builder().name("CD").quantity(1).types(Arrays.asList()).price(14.99).build();
        Product product3B1 = Product.builder().name("barres de chocolat").quantity(3).types(Arrays.asList(ProductType.BASIC_NECESSITIES)).price(0.85).build();
        ProductBasket basket1 = new ProductBasket(Arrays.asList(product1B1, product2B1, product3B1));
        System.out.println(new ReceiptPrinter(basket1).printBasketReceipt());

        Product product1B2 = Product.builder().name("boîtes de chocolats importée").quantity(2).types(Arrays.asList(ProductType.BASIC_NECESSITIES, ProductType.IMPORTED)).price(10.00).build();
        Product product2B2 = Product.builder().name("flacons de parfum importé").quantity(3).types(Arrays.asList(ProductType.IMPORTED)).price(47.50).build();
        ProductBasket basket2 = new ProductBasket(Arrays.asList(product1B2, product2B2));
        System.out.println(new ReceiptPrinter(basket2).printBasketReceipt());

        Product product1B3 = Product.builder().name("flacons de parfum importé").quantity(2).types(Arrays.asList(ProductType.IMPORTED)).price(27.99).build();
        Product product2B3 = Product.builder().name("flacon de parfum").quantity(1).types(Arrays.asList()).price(18.99).build();
        Product product3B3 = Product.builder().name("boîtes de pilules contre la migraine").quantity(3).types(Arrays.asList(ProductType.BASIC_NECESSITIES)).price(9.75).build();
        Product product4B3 = Product.builder().name("boîtes de chocolats importés").quantity(2).types(Arrays.asList(ProductType.BASIC_NECESSITIES, ProductType.IMPORTED)).price(11.25).build();
        ProductBasket basket3 = new ProductBasket(Arrays.asList(product1B3, product2B3, product3B3, product4B3));
        System.out.println(new ReceiptPrinter(basket3).printBasketReceipt());
    }
}

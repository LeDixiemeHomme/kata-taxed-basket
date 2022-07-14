package student.valle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AmountTests {

    @Test
    void getRoundedAmountWith0() {
        Amount amount = new Amount(10.00);
        assertEquals(10.00, amount.getRoundedValue());
    }

}

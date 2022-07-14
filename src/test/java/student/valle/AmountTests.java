package student.valle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AmountTests {

    @Test
    void getRoundedAmountWith0() {
        assertEquals(10.00, new Amount(10.00).getRoundedValue());
    }

    @Test
    void getRoundedAmountWithBetween1And4() {
        assertEquals(10.05, new Amount(10.01).getRoundedValue());
        assertEquals(10.05, new Amount(10.02).getRoundedValue());
        assertEquals(10.05, new Amount(10.03).getRoundedValue());
        assertEquals(10.05, new Amount(10.04).getRoundedValue());
    }

    @Test
    void getRoundedAmountWith5() {
        assertEquals(10.05, new Amount(10.05).getRoundedValue());
    }

    @Test
    void getRoundedAmountWithBetween6And9() {
        assertEquals(11.00, new Amount(10.06).getRoundedValue());
        assertEquals(11.00, new Amount(10.07).getRoundedValue());
        assertEquals(11.00, new Amount(10.08).getRoundedValue());
        assertEquals(11.00, new Amount(10.09).getRoundedValue());
    }

}

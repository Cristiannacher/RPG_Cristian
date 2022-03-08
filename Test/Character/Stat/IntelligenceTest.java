package Character.Stat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntelligenceTest {

    int initialValue = 5;
    Intelligence intel;
    @BeforeEach
    void setUp() {
        intel = new Intelligence(initialValue);
    }

    @Test
    void Constructor_Getvalue_ReturnInitialValue() {
        assertEquals(initialValue,intel.getValue());
    }

    @Test
    void IncreaseValue_IncreaseValueBy1() {
        intel.increase();
        assertEquals(initialValue+1,intel.getValue());
    }

    @Test
    void DecreaseValue_DecreaseValueBy1() {
        intel.decrease();
        assertEquals(initialValue-1,intel.getValue());
    }

    @Test
    void testToString() {
        String expected =  "Inteligence: 5";
        assertEquals(expected, intel.toString());
    }
}
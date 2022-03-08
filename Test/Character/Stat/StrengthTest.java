package Character.Stat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrengthTest {

    int initialValue = 5;
     Strength str;
    @BeforeEach
    void setUp() {
        str = new Strength(initialValue);
    }

    @Test
    void Constructor_Getvalue_ReturnInitialValue() {
        assertEquals(initialValue,str.getValue());
    }

    @Test
    void IncreaseValue_IncreaseValueBy1() {
        str.increase();
        assertEquals(initialValue+1,str.getValue());
    }

    @Test
    void DecreaseValue_DecreaseValueBy1() {
        str.decrease();
        assertEquals(initialValue-1,str.getValue());
    }

    @Test
    void testToString() {
        String expected =  "Strenght: 5";
        assertEquals(expected, str.toString());
    }
}
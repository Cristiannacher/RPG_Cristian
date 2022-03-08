package Character.Stat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DexterityTest {

    int initialValue = 5;
    Dexterity dex;
    @BeforeEach
    void setUp() {
        dex = new Dexterity(initialValue);
    }

    @Test
    void Constructor_Getvalue_ReturnInitialValue() {
        assertEquals(initialValue,dex.getValue());
    }

    @Test
    void IncreaseValue_IncreaseValueBy1() {
        dex.increase();
        assertEquals(initialValue+1,dex.getValue());
    }

    @Test
    void DecreaseValue_DecreaseValueBy1() {
        dex.decrease();
        assertEquals(initialValue-1,dex.getValue());
    }

    @Test
    void testToString() {
        String expected =  "Dexterity: 5";
        assertEquals(expected, dex.toString());
    }
}
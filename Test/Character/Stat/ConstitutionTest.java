package Character.Stat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstitutionTest {

    int inicialValue = 5;
    Constitution cons;

    @BeforeEach
    void setUp() {
        cons = new Constitution(inicialValue);
    }

    @Test
    void Constructor_GetValue_GetinicalValue() {
        assertEquals(inicialValue,cons.getValue());
    }

    @Test
    void IncreaseValue_IncreaseValueBy1() {
        cons.increase();
        assertEquals(inicialValue+1,cons.getValue());
    }

    @Test
    void Decrease_DecreaseValueBy1() {
        cons.decrease();
        assertEquals(inicialValue-1,cons.getValue());
    }

    @Test
    void testToString() {
        String expected =  "Constitution: 5";
        assertEquals(expected, cons.toString());
    }
}
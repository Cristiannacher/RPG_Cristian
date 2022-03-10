package Character.Stat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatTest {

    int inicialValue = 5;
    Stat stat;

    @BeforeEach
    void setUp() {
        stat = new StatMock(inicialValue) ;
    }

    @Test
    void Constructor_GetValue_GetinicalValue() {
        assertEquals(inicialValue, stat.getValue());
    }

    @Test
    void IncreaseValue_IncreaseValueBy1() {
        stat.increase();
        assertEquals(inicialValue+1, stat.getValue());
    }

    @Test
    void Decrease_DecreaseValueBy1() {
        stat.decrease();
        assertEquals(inicialValue-1, stat.getValue());
    }

    @Test
    void testToString() {
        String expected =  "Constitution: 5";
        assertEquals(expected, stat.toString());
    }
}
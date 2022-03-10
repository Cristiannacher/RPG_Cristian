package Character.Race;

import Character.Stat.Constitution;
import Character.Stat.Dexterity;
import Character.Stat.Intelligence;
import Character.Stat.Strength;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrujaTest {

    Bruja bruja;

    @BeforeEach
    void setUp() {
        bruja = new Bruja();
    }

    @Test
    void strength_GetStrenghtValue_ModifierStrengthValue() {
        assertEquals(-2, bruja.modifier(new Strength(0)));
    }

    @Test
    void intelligence_GetIntelligenceValue_ModifierIntelligenceValue() {
        assertEquals(4, bruja.modifier(new Intelligence(0)));
    }

    @Test
    void intelligence_GetDexteretyValue_ModifierDexteretyValue() {
        assertEquals(3, bruja.modifier(new Dexterity(0)));
    }

    @Test
    void constitution_GetConstitutionValue_ModifierConstituionValue() {
        assertEquals(0, bruja.modifier(new Constitution(0)));
    }
}
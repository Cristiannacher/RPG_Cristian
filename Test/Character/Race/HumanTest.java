package Character.Race;

import Character.Stat.Constitution;
import Character.Stat.Dexterity;
import Character.Stat.Intelligence;
import Character.Stat.Strength;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    Human humano;

    @BeforeEach
    void setUp() {
        humano = new Human();
    }

    @Test
    void strength_GetStrenghtValue_ModifierStrengthValue() {
        assertEquals(2, humano.modifier(new Strength(0)));
    }

    @Test
    void constitution_GetConstitutionValue_ModifierConstituionValue() {
        assertEquals(2, humano.modifier(new Constitution(0)));
    }

    @Test
    void intelligence_GetDexteretyValue_ModifierDexteretyValue() {
        assertEquals(1, humano.modifier(new Dexterity(0)));
    }

    @Test
    void intelligence_GetIntelligenceValue_ModifierIntelligenceValue() {
        assertEquals(0, humano.modifier(new Intelligence(0)));
    }
}

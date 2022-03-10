package Character.Race;

import Character.Stat.Constitution;
import Character.Stat.Dexterity;
import Character.Stat.Intelligence;
import Character.Stat.Strength;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrcTest {

    Orc orco;

    @BeforeEach
    void setUp() {
        orco = new Orc();
    }

    @Test
    void strength_GetStrenghtValue_ModifierStrengthValue() {
        assertEquals(5, orco.modifier(new Strength(0)));
    }

    @Test
    void intelligence_GetIntelligenceValue_ModifierIntelligenceValue() {
        assertEquals(-3, orco.modifier(new Intelligence(0)));
    }

    @Test
    void constitution_GetConstitutionValue_ModifierConstituionValue() {
        assertEquals(3, orco.modifier(new Constitution(0)));
    }

    @Test
    void intelligence_GetDexteretyValue_ModifierDexteretyValue() {
        assertEquals(0, orco.modifier(new Dexterity(0)));
    }
}
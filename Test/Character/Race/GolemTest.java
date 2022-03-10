package Character.Race;

import Character.Stat.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GolemTest {

    Golem golem;

    @BeforeEach
    void setUp() {
        golem = new Golem();
    }

    @Test
    void strength_GetStrenghtValue_ModifierStrengthValue() {
        assertEquals(4, golem.modifier(new Strength(0)));
    }

    @Test
    void constitution_GetConstitutionValue_ModifierConstituionValue() {
        assertEquals(4, golem.modifier(new Constitution(0)));
    }

    @Test
    void intelligence_GetIntelligenceValue_ModifierIntelligenceValue() {
        assertEquals(-3, golem.modifier(new Intelligence(0)));
    }

    @Test
    void Dexterety_GetDexteretyValue_ModifierDexteretyValue() {
        assertEquals(0, golem.modifier(new Dexterity(0)));
    }

}
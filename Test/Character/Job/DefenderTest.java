package Character.Job;

import Character.Stat.Constitution;
import Character.Stat.Intelligence;
import Character.Stat.Strength;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefenderTest {

    Defender defender;

    @BeforeEach
    void setUp() {
        defender = new Defender();
    }

    @Test
    void constitution_GetConstitutionValue_ModifierConstituionValue() {
        assertEquals(2, defender.modifier(new Constitution(0)));
    }
    @Test
    void strength_GetStrenghtValue_ModifierStrengthValue() {
        assertEquals(3, defender.modifier(new Strength(0)));
    }

    @Test
    void intelligence_GetIntelligenceValue_ModifierIntelligenceValue() {
        assertEquals(0, defender.modifier(new Intelligence(0)));
    }
}
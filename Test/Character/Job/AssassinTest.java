package Character.Job;

import Character.Stat.Constitution;
import Character.Stat.Dexterity;
import Character.Stat.Intelligence;
import Character.Stat.Strength;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssassinTest {

    Assassin assassin;
    @BeforeEach
    void setUp() {
        assassin = new Assassin();
    }

    @Test
    void dexterety_GetDexteretyValue_ModifierDexteretyValue() {
        assertEquals(3, assassin.modifier(new Dexterity(0)));
    }

    @Test
    void constitution_GetConstitutionValue_ModifierConstituionValue() {
        assertEquals(1, assassin.modifier(new Constitution(0)));
    }
    @Test
    void strength_GetStrenghtValue_ModifierStrengthValue() {
        assertEquals(1, assassin.modifier(new Strength(0)));
    }

    @Test
    void intelligence_GetIntelligenceValue_ModifierIntelligenceValue() {
        assertEquals(0, assassin.modifier(new Intelligence(0)));
    }
}
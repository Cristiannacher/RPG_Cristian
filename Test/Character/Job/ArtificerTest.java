package Character.Job;

import Character.Stat.Constitution;
import Character.Stat.Dexterity;
import Character.Stat.Intelligence;
import Character.Stat.Strength;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtificerTest {

    Artificer artificier;
    @BeforeEach
    void setUp() {
        artificier = new Artificer();
    }

    @Test
    void intelligence_GetIntelligenceValue_ModifierIntelligenceValue() {
        assertEquals(2, artificier.modifier(new Intelligence(0)));
    }

    @Test
    void dexterety_GetDexteretyValue_ModifierDexteretyValue() {
        assertEquals(2, artificier.modifier(new Dexterity(0)));
    }

    @Test
    void constitution_GetConstitutionValue_ModifierConstituionValue() {
        assertEquals(1, artificier.modifier(new Constitution(0)));
    }
    @Test
    void strength_GetStrenghtValue_ModifierStrengthValue() {
        assertEquals(0, artificier.modifier(new Strength(0)));
    }

}
package Character.Job;

import Character.Stat.Constitution;
import Character.Stat.Dexterity;
import Character.Stat.Intelligence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {

    Mage mage;

    @BeforeEach
    void setUp() {
        mage = new Mage();
    }

    @Test
    void dexterety_GetDexteretyValue_ModifierDexteretyValue() {
        assertEquals(1, mage.modifier(new Dexterity(0)));
    }

    @Test
    void intelligence_GetIntelligenceValue_ModifierIntelligenceValue() {
        assertEquals(4, mage.modifier(new Intelligence(0)));
    }

    @Test
    void constitution_GetConstitutionValue_ModifierConstituionValue() {
        assertEquals(0, mage.modifier(new Constitution(0)));
    }
}
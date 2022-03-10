package Character.Race;

import Character.Stat.Constitution;
import Character.Stat.Dexterity;
import Character.Stat.Intelligence;
import Character.Stat.Strength;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElfTest {

    Elf elf;

    @BeforeEach
    void setUp() {
        elf = new Elf();
    }

    @Test
    void intelligence_GetIntelligenceValue_ModifierIntelligenceValue() {
        assertEquals(3, elf.modifier(new Intelligence(0)));
    }

    @Test
    void intelligence_GetDexteretyValue_ModifierDexteretyValue() {
        assertEquals(3, elf.modifier(new Dexterity(0)));
    }

    @Test
    void constitution_GetConstitutionValue_ModifierConstituionValue() {
        assertEquals(-1, elf.modifier(new Constitution(0)));
    }

    @Test
    void strength_GetStrenghtValue_ModifierStrengthValue() {
        assertEquals(0, elf.modifier(new Strength(0)));
    }
}
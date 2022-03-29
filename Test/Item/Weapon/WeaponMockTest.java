package Item.Weapon;

import Character.Job.Job;
import Character.Job.Jobmock;
import Character.Race.Race;
import Character.Race.Racemock;
import Character.Stat.Constitution;
import Character.Stat.Dexterity;
import Character.Stat.Intelligence;
import Character.Stat.Strength;
import Item.Armor.ArmorkMock;
import Character.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponMockTest {
    private int jobValue = 5;
    private int raceValue = 5;
    private int strengthValue = 2;
    private int dexteretyValue = 2;
    private int constitutionValue = 2;
    private int intelligenceValue = 2;

    Race racemock = new Racemock(raceValue);
    Job jobmock = new Jobmock(jobValue);
    Character character;
    WeaponMock mock;

    @BeforeEach
    void setUp() {
        character = new Character("Pedro", racemock, jobmock, new Strength(strengthValue), new Dexterity(dexteretyValue), new Constitution(constitutionValue), new Intelligence(intelligenceValue));
        mock = new WeaponMock();
    }

    @Test
    void carry_youCanCarry() {
        mock.setStrength(strengthValue);
        int totalStrength = mock.getStrenght() + character.getStrengthValue();
        character.carryItem(mock);
        assertEquals(totalStrength, character.getStrengthValue());
    }
    @Test
    void carry_youCantCarry() {
        mock.setStrength(strengthValue);
        int totalStrength = mock.getStrenght() + character.getStrengthValue();
        character.carryItem(mock);
        character.carryItem(mock);
        assertEquals(totalStrength, character.getStrengthValue());
    }
}
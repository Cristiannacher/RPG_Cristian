package Character;

import Character.Job.Job;
import Character.Job.Jobmock;
import Character.Race.Race;
import Character.Race.Racemock;
import Character.Stat.Constitution;
import Character.Stat.Dexterity;
import Character.Stat.Intelligence;
import Character.Stat.Strength;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    private int jobValue = 5;
    private int raceValue = 5;
    private int strengthValue = 2;
    private int dexteretyValue = 2;
    private int constitutionValue = 2;
    private int intelligenceValue = 2;

    Race racemock = new Racemock(raceValue);
    Job jobmock = new Jobmock(jobValue);

    Character character = new Character("Pedro", racemock, jobmock, new Strength(strengthValue), new Dexterity(dexteretyValue), new Constitution(constitutionValue), new Intelligence(intelligenceValue));

    @Test
    void character_getName_haveCharacterName() {
        assertEquals("Pedro", character.getName());
    }

    @Test
    void character_getRace_haveCharacterRace() {
        assertEquals(racemock,character.getRace());
    }

    @Test
    void character_getJob_haverCharacterJob() {
        assertEquals(jobmock, character.getJob());
    }

    @Test
    void velocity_takeIntoAccountRaceAndJobModifiers() {
        int velocityExpected = (dexteretyValue + raceValue +jobValue)*2;
        assertEquals(velocityExpected,character.velocity());
    }

    @Test
    void power_takeIntoAccountRaceAndJobModifiers() {
        int powerExpected = (strengthValue +raceValue+jobValue)*2;
        assertEquals(powerExpected,character.power());
    }

    @Test
    void magic_takeIntoAccountRaceAndJobModifiers() {
        int magicExpected = (intelligenceValue+raceValue+jobValue)*2;
        assertEquals(magicExpected,character.magic());
    }

}
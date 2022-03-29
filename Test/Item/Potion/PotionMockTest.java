package Item.Potion;

import Character.Job.Job;
import Character.Job.Jobmock;
import Character.Race.Race;
import Character.Race.Racemock;
import Character.Stat.Constitution;
import Character.Stat.Dexterity;
import Character.Stat.Intelligence;
import Character.Stat.Strength;
import Character.Character;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PotionMockTest {
    private int jobValue = 5;
    private int raceValue = 5;
    private int strengthValue = 2;
    private int dexteretyValue = 2;
    private int constitutionValue = 2;
    private int intelligenceValue = 2;

    Race racemock = new Racemock(raceValue);
    Job jobmock = new Jobmock(jobValue);

    Character character = new Character("Pedro", racemock, jobmock, new Strength(strengthValue), new Dexterity(dexteretyValue), new Constitution(constitutionValue), new Intelligence(intelligenceValue));

    PotionMock mock = new PotionMock();

    //revisar test
    @Test
    void consumedBy() {
        double health = character.health();
        int amount = 50;
        mock.setPower(amount);
        character.receivesDamage(amount);
        mock.consumedBy(character);
        assertEquals(health,character.health());
    }
}
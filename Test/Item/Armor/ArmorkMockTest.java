package Item.Armor;

import Character.Job.Job;
import Character.Job.Jobmock;
import Character.Race.Race;
import Character.Race.Racemock;
import Character.Stat.Constitution;
import Character.Stat.Dexterity;
import Character.Stat.Intelligence;
import Character.Stat.Strength;
import Character.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorkMockTest {

    private int jobValue = 5;
    private int raceValue = 5;
    private int strengthValue = 2;
    private int dexteretyValue = 2;
    private int constitutionValue = 2;
    private int intelligenceValue = 2;

    Race racemock = new Racemock(raceValue);
    Job jobmock = new Jobmock(jobValue);
    Character character;
    ArmorkMock mock;

    @BeforeEach
    void setUp() {
        character = new Character("Pedro", racemock, jobmock, new Strength(strengthValue), new Dexterity(dexteretyValue), new Constitution(constitutionValue), new Intelligence(intelligenceValue));
        mock = new ArmorkMock();
    }
//no entiendo lo de como poner los nombres de los tests asi que los pongo un poco como me parece
    @Test
    void carry_youCanCarry() {
        mock.setConstitution(constitutionValue);
        int totalConstitution = mock.getConstitution() + character.getConstitutionValue();
        character.carryItem(mock);
        assertEquals(totalConstitution, character.getConstitutionValue());
    }
    //el test se basa en que si me dejara volver a coger el objeto se volveria a sumar la constitucion
    //y daria error, ademas nos sale el mensaje
    @Test
    void carry_youCantCarry() {
        mock.setConstitution(constitutionValue);
        int totalConstitution = mock.getConstitution() + character.getConstitutionValue();
        character.carryItem(mock);
        character.carryItem(mock);
        assertEquals(totalConstitution, character.getConstitutionValue());
    }
}
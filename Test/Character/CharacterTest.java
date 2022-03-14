package Character;

import Character.Job.Defender;
import Character.Race.Golem;
import Character.Stat.Constitution;
import Character.Stat.Dexterity;
import Character.Stat.Intelligence;
import Character.Stat.Strength;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    Character character = new Character("Pedro", new Golem(), new Defender(), new Strength(7), new Dexterity(2),new Constitution(8), new Intelligence(3));

    @Test
    void getName() {
        assertEquals("Pedro", character.getName());
    }

    @Test
    void getRace() {
        assertEquals(new Golemcharacter.getRace());
    }

    @Test
    void getJob() {
    }

    @Test
    void velocity() {
    }

    @Test
    void power() {
    }

    @Test
    void magic() {
    }

    @Test
    void health() {
    }
}
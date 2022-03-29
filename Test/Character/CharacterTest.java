package Character;

import Character.Job.Job;
import Character.Job.Jobmock;
import Character.Race.Race;
import Character.Race.Racemock;
import Character.Stat.Constitution;
import Character.Stat.Dexterity;
import Character.Stat.Intelligence;
import Character.Stat.Strength;
import Item.Armor.Armor;
import Item.Armor.HardArmor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    private int jobValue = 5;
    private int raceValue = 5;
    private int strengthValue = 2;
    private int dexteretyValue = 2;
    private int constitutionValue = 2;
    private int intelligenceValue = 2;

    Race racemock;
    Job jobmock;
    Character character;
    Armor hardarmor;

    @BeforeEach
    void setUp() {
        racemock = new Racemock(raceValue);
        jobmock = new Jobmock(jobValue);
        character = new Character("Pedro", racemock, jobmock, new Strength(strengthValue), new Dexterity(dexteretyValue), new Constitution(constitutionValue), new Intelligence(intelligenceValue));
        hardarmor = new HardArmor();
    }

    @Test
    void character_getName_haveCharacterName() {
        assertEquals("Pedro", character.getName());
    }

    @Test
    void character_getRace_haveCharacterRace() {
        assertEquals(racemock, character.getRace());
    }

    @Test
    void character_getJob_haverCharacterJob() {
        assertEquals(jobmock, character.getJob());
    }

    @Test
    void equipItem_youCanEquip() {
        character.equipItem(hardarmor);
       assertFalse(character.getEquipables().isEmpty());
    }

    @Test
    void velocity_takeIntoAccountRaceAndJobModifiers() {
        int velocityExpected = (dexteretyValue + raceValue + jobValue) * 2;
        assertEquals(velocityExpected, character.velocity());
    }

    @Test
    void power_takeIntoAccountRaceAndJobModifiers() {
        int powerExpected = (strengthValue + raceValue + jobValue) * 2;
        assertEquals(powerExpected, character.power());
    }

    @Test
    void magic_takeIntoAccountRaceAndJobModifiers() {
        int magicExpected = (intelligenceValue + raceValue + jobValue) * 2;
        assertEquals(magicExpected, character.magic());
    }

    @Test
    void character_getMaxHealth_haveMaxHealth() {
        int maxhealth = (constitutionValue + jobValue + raceValue) * 25;
        assertEquals(maxhealth, character.maxHealth());
    }

    //arreglar
    @Test
    void character_health_haveCharacterHealth() {
        int damage = 5;
        character.receivesDamage(damage);
        double health = character.maxHealth() - damage;
        assertEquals(health, character.health());
    }

    @Test
    void character_isDead_isDeadTrue() {
        double damage = character.maxHealth() + 1;
        character.receivesDamage(damage);
        assertEquals(true, character.isDead());
    }

    @Test
    void character_isDead_isDeadFalse() {
        double damage = character.maxHealth() - 1;
        character.receivesDamage(damage);
        assertEquals(false, character.isDead());
    }

    @Test
    void character_isDead_isDeadTrueValue0() {
        double damage = character.maxHealth();
        character.receivesDamage(damage);
        assertEquals(true, character.isDead());
    }

    @Test
    void character_receivesDamage_damageRecived() {
        int damage = 5;
        character.receivesDamage(damage);
        assertEquals(damage, character.getDamageTaken());
    }

    @Test
    void character_healsElseThanDamage_helathElseMaxhealth() {
        int damage = 5;
        int heal = 2;
        int damageAftereHeal = damage - heal;

        character.receivesDamage(damage);
        character.heals(heal);
        assertEquals(damageAftereHeal, character.getDamageTaken());
    }

    @Test
    void character_healsMoreThanDamage_healthEqualsMaxHealth() {
        int damage = 5;
        int heal = 6;
        int damageBeforeHeal = 0;

        character.receivesDamage(damage);
        character.heals(heal);
        assertEquals(damageBeforeHeal, character.getDamageTaken());
    }

    @Test
    void character_healsEqualsThanDamage_healthEqualsMaxHealth() {
        int damage = 5;
        int heal = 5;
        int damageBeforeHeal = 0;

        character.receivesDamage(damage);
        character.heals(heal);
        assertEquals(damageBeforeHeal, character.getDamageTaken());
    }

}
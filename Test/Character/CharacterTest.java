package Character;

import Character.Job.Job;
import Character.Job.Jobmock;
import Character.Race.Race;
import Character.Race.Racemock;
import Character.Stat.*;
import Item.Armor.Armor;
import Item.Armor.HardArmor;
import Item.EquipableMock;
import Item.IEquipable;
import Item.IPicable;
import Item.Jewels.Jewels;
import Item.Jewels.Necklace;
import Item.Weapon.Stick;
import Item.Weapon.Weapon;
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
    Jewels necklace;
    Weapon stick;
    EquipableMock mock;

    @BeforeEach
    void setUp() {
        racemock = new Racemock(raceValue);
        jobmock = new Jobmock(jobValue);
        character = new Character("Pedro", racemock, jobmock, new Strength(strengthValue), new Dexterity(dexteretyValue), new Constitution(constitutionValue), new Intelligence(intelligenceValue));
        hardarmor = new HardArmor();
        necklace = new Necklace();
        stick = new Stick();
        mock = new EquipableMock();
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
    void character_equipItem_youCanEquip() {
        character.equipItem(hardarmor);
        assertFalse(character.getEquipables().isEmpty());
    }

    @Test
    void character_equipItem_youCantEquip() {
        boolean equals = false;
        Object equipable = new Object();

        character.equipItem(hardarmor);
        character.equipItem(necklace);
        character.equipItem(stick);
        character.equipItem(stick);

        for (IEquipable object : character.getEquipables()) {
            if (equipable.equals(object))
                equals = true;
            equipable = object;
        }
        assertFalse(equals);
    }

    @Test
    void character_unequipItem_youCanunEquip() {
        boolean unequiped = true;

        character.equipItem(hardarmor);
        character.equipItem(necklace);
        character.equipItem(stick);

        character.unequipItem(stick);

        for (IEquipable object : character.getEquipables()) {
            if (object.equals(stick))
                unequiped = false;
        }
        assertTrue(unequiped);
    }

    @Test
    void character_calculateEquipmentModifier() {
        double beforeEquip = character.power() + mock.modifier(character.getStrength()) * 2;
        character.equipItem(mock);
        double afterEquip = character.power();
        assertEquals(beforeEquip, afterEquip);
    }
    @Test
    void character_picItem_YouCanPick(){
        character.picItem(stick);
        assertFalse(character.getPicables().isEmpty());
    }


    //el metodo se basa en intentar poner mas cosas de las que se pueden
    //entonces si el metodo funciona bien al hacer las suma del peso de las cosas picadas
    // no sera superior a la fuerza
    @Test
    void character_picItem_YouCanTPic() {
        double strong = character.power();
        double itemsPicketsWeight = 0;
        character.picItem(hardarmor);
        character.picItem(necklace);
        character.picItem(stick);
        character.picItem(stick);
        character.picItem(hardarmor);
        character.picItem(necklace);
        character.picItem(stick);
        character.picItem(stick);
        character.picItem(hardarmor);
        character.picItem(necklace);
        for(IPicable picable: character.getPicables()){
            itemsPicketsWeight += picable.getWeight();
        }
        assertTrue((itemsPicketsWeight<=strong));
    }
    @Test
    void character_unpicIem_YouCanUnpic(){
        boolean equals = false;
        character.picItem(hardarmor);
        character.picItem(necklace);
        character.picItem(stick);
        character.unpicIitem(stick);
        for(IPicable picable: character.getPicables()){
            if(picable.equals(stick))
                equals = true;
        }
        assertFalse(equals);
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
package Character;

import Character.Job.Job;
import Character.Race.Race;
import Character.Stat.*;
import Item.IPicable;
import Item.IConsumable;
import Item.IEquipable;

import java.util.ArrayList;
import java.util.List;

public class Character implements IDamageable {

    private String name;
    private Race race;
    private Job job;
    private Stat strength;
    private Stat dexterity;
    private Stat constitution;
    private Stat intelligence;
    private double damageTaken;
    private List<IEquipable> equipables = new ArrayList<>();
    private List<IPicable> picables = new ArrayList<>();
    private double strong;


    public Character(String name, Race race, Job job, Strength strength, Dexterity dexterity, Constitution constitution, Intelligence intelligence) {
        this.name = name;
        this.race = race;
        this.job = job;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
    }

    public List<IEquipable> getEquipables() {
        return equipables;
    }

    public String getName() {
        return name;
    }

    public Race getRace() {
        return race;
    }

    public Job getJob() {
        return job;
    }

    public double getDamageTaken() {
        return damageTaken;
    }

    public double velocity() {
        return calculateAttributeValue(dexterity) * 2;
    }

    public double power() {
        return calculateAttributeValue(strength) * 2;
    }

    public double magic() {
        return calculateAttributeValue(intelligence) * 2;
    }

    private double calculateAttributeValue(Stat stat) {
        return stat.getValue() + race.modifier(stat) + job.modifier(stat) + calculateEquipmentModifier(stat);
    }

    private double calculateEquipmentModifier(Stat stat) {
        double modifier = 0;
        for (IEquipable equip : equipables)
            modifier += equip.modifier(stat);

        return modifier;
    }

    public void picItem(IPicable picable) {
        int accomulatedWeight = 0;
        strong = power();
        if (!picables.isEmpty()) {
            for (IPicable object : picables) {
                accomulatedWeight += object.getWeight();
            }
            if ((accomulatedWeight + picable.getWeight()) <= strong) {
                picables.add(picable);
            } else System.out.println("You don't have enough strength");
        } else {
            if (picable.getWeight() <= strong)
                picables.add(picable);
        }
    }
    public void unpicIitem(IPicable picable){
        boolean unpicket = false;
        for(IPicable object: picables){
            if(picable.equals(object)) {
                picables.remove(picable);
                unpicket = true;
            }
        }
        if(unpicket)
            System.out.println("The item isent in your inventory");
    }

    public void equipItem(IEquipable equiped) {
        for (IEquipable equipable : equipables) {
            if (equipable.equals(equiped)) {
                System.out.println("You already have an " + equiped);
                return;
            }
        }
        equipables.add(equiped);
    }

    // no funcione me cagon deu
    public void unequipItem(IEquipable equiped){
        for(IEquipable object: equipables){
            if(equiped.equals(object))
                equipables.remove(equiped);
            break;
        }
    }

    public Stat getConstitution() {
        return constitution;
    }

    public Stat getDexterity() {
        return dexterity;
    }

    public Stat getIntelligence() {
        return intelligence;
    }

    public Stat getStrength() {
        return strength;
    }


    public void consumeAlimento(IConsumable consumable) {
        consumable.consumedBy(this);
        System.out.println(name + " consumed: " + consumable.toString());
    }

    public void consumePocion(IConsumable consumable) {
        consumable.consumedBy(this);
        System.out.println(name + " consumed:" + consumable.toString());
    }

    @Override
    public double maxHealth() {
        return calculateAttributeValue(constitution) * 25;
    }

    @Override
    public double health() {
        return maxHealth() - damageTaken;
    }

    @Override
    public boolean isDead() {
        return (maxHealth() <= damageTaken);
    }

    @Override
    public void receivesDamage(double amount) {
        damageTaken = damageTaken + amount;
        System.out.println(name + " received " + amount + " damage. " + "Health: " + health() + "/" + maxHealth());
    }

    @Override
    public void heals(double amount) {
        if (damageTaken <= amount)
            damageTaken = 0;
        else damageTaken = damageTaken - amount;
        System.out.println(name + " healed " + amount + " life." + " Health: " + health() + "/" + maxHealth());
    }

    @Override
    public String toString() {
        return "My name is " +
                name + '\'' +
                "I'm an " + race + job +
                " My stats are: Strenght: " + strength.getValue() +
                "Dexterity: " + dexterity.getValue() +
                "Constitution: " + constitution.getValue() +
                "Intelligence: " + intelligence.getValue() +
                "Velocity: " + velocity() +
                "Power: " + power() +
                "Magic: " + magic() +
                "Health: " + health();
    }
}

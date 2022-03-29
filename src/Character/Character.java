package Character;

import Character.Job.Job;
import Character.Race.Race;
import Character.Stat.*;
import Item.IChargeable;
import Item.IConsumable;
import Item.IPortable;

import java.awt.*;
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
    private List<IPortable> portableList = new ArrayList<>();
    private List<IChargeable> chargeables = new ArrayList<>();
    private int strong;


    public Character(String name, Race race, Job job, Strength strength, Dexterity dexterity, Constitution constitution, Intelligence intelligence) {
        this.name = name;
        this.race = race;
        this.job = job;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
    }

    public List<IPortable> getPortableList() {
        return portableList;
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
        return (dexterity.getValue() + race.modifier(dexterity) + job.modifier(dexterity)) * 2;
    }

    public double power() {
        return (strength.getValue() + race.modifier(strength) + job.modifier(strength)) * 2;
    }

    public double magic() {
        return (intelligence.getValue() + race.modifier(intelligence) + job.modifier(intelligence)) * 2;
    }

    public void chargeItem(IChargeable chargeable){
        int accomulatedWeight = 0;
        strong = (strength.getValue() * constitution.getValue());
        if(!chargeables.isEmpty()){
            for(IChargeable object:chargeables){
                accomulatedWeight += object.getWeight();
            }
            if((accomulatedWeight + chargeable.getWeight()) <= strong){
                chargeables.add(chargeable);
            } else System.out.println("You don't have enough strength");
        } else {
            if(chargeable.getWeight()<=strong)
                chargeables.add(chargeable);
        }
    }

    public void carryItem(IPortable portable) {
        portable.carry(this);
    }

    public void increaseConstitution(int value) {
        this.constitution.increase(value);
    }

    public void increaseStrenght(int value) {
        this.strength.increase(value);
    }

    public void increaseDexterety(int value) {
        this.dexterity.increase(value);
    }

    public void increaseIntelligence(int value) {
        this.intelligence.increase(value);
    }

    public void addPortable(IPortable portable) {
        portableList.add(portable);
    }

    public int getConstitutionValue() {
        return constitution.getValue();
    }
    public int getDexterityValue(){
        return dexterity.getValue();
    }
    public int getIntelligenceValue(){
        return intelligence.getValue();
    }
    public int getStrengthValue(){
        return strength.getValue();
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
        return (constitution.getValue() + race.modifier(constitution) + job.modifier(constitution)) * 25;
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

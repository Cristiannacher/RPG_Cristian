package Character;

import Character.Job.Job;
import Character.Race.Race;
import Character.Stat.*;
import Item.Food.IConsumable;

public class Character implements IDamageable {

    private String name;
    private Race race;
    private Job job;
    private Stat strength;
    private Stat dexterity;
    private Stat constitution;
    private Stat intelligence;
    private double damageTaken;

    public Character(String name, Race race, Job job, Strength strength, Dexterity dexterity, Constitution constitution, Intelligence intelligence) {
        this.name = name;
        this.race = race;
        this.job = job;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
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

    public void consumeAlimento(IConsumable consumable){
        consumable.consumedBy(this);
        System.out.println(name +" consumed: "+ consumable.toString());
    }

    public void consumePocion(IConsumable consumable){
        consumable.consumedBy(this);
        System.out.println(name+" consumed:" + consumable.toString());
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
        damageTaken =  damageTaken +amount;
        System.out.println(name+" received "+amount+ " damage. " +"Health: "+health()+"/"+maxHealth());
    }

    @Override
    public void heals(double amount) {
        if((damageTaken - amount)<=0)
            damageTaken = 0;
        else damageTaken = damageTaken - amount;
System.out.println(name+" healed "+ amount+" life."+" Health: "+health()+"/"+maxHealth());
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

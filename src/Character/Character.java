package Character;

import Character.Job.Job;
import Character.Race.Race;
import Character.Stat.*;

public class Character {

    private String name;
    private Race race;
    private Job job;
    private Stat strength;
    private Stat dexterity;
    private Stat constitution;
    private Stat intelligence;

    public Character (String name, Race race, Job job, Strength strength, Dexterity dexterity, Constitution constitution, Intelligence intelligence){
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

    public double velocity(){
        return  (dexterity.getValue() + race.modifier(dexterity) + job.modifier(dexterity))*2;
    }

    public double power(){
        return (strength.getValue() + race.modifier(strength) + job.modifier(strength))*2;
    }

    public double magic(){
        return (intelligence.getValue() + race.modifier(intelligence) + job.modifier(intelligence))*2;
    }

    public double health(){
        return (constitution.getValue() + race.modifier(constitution) + job.modifier(constitution))*2;
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

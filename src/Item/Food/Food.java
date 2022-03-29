package Item.Food;

import Character.Character;
import Item.IChargeable;
import Item.IConsumable;

public abstract class Food implements IConsumable, IChargeable {
    protected double power;
    protected int weight;

    @Override
    public int getWeight() {
        return weight;
    }

    public double getPower() {
        return power;
    }

    @Override
    public void consumedBy(Character character) {
        character.heals(this.power);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

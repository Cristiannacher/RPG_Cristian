package Item.Potion;

import Item.IChargeable;
import Item.IConsumable;
import Character.Character;

public abstract class Potion implements IConsumable, IChargeable {
    protected int power;
    protected int weight;

    @Override
    public int getWeight() {
        return weight;
    }

    public int getPower() {
        return power;
    }

    @Override
    public void consumedBy(Character character) {
        character.heals(power);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

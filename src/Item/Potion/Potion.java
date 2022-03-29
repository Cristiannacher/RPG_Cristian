package Item.Potion;

import Item.IPicable;
import Item.IConsumable;
import Character.Character;

public abstract class Potion implements IConsumable, IPicable {
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

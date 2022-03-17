package Item.Potion;

import Item.Food.IConsumable;
import Character.Character;

public class Potion implements IConsumable {
    private int power;

    @Override
    public void consumedBy(Character character) {
        character.heals(power);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

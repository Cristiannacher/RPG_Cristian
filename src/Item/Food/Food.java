package Item.Food;

import Character.Character;

public abstract class Food implements IConsumable{
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

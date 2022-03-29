package Item.Armor;

import Item.IEquipable;
import Character.Character;

import java.util.List;

public abstract class Armor implements IEquipable {
    protected int weight;
    protected int constitution;

    @Override
    public int getWeight() {
        return weight;
    }

    public int getConstitution() {
        return constitution;
    }


    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

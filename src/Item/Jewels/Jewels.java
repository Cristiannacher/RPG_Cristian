package Item.Jewels;

import Item.IPicable;
import Item.IEquipable;
import Character.Character;

import java.util.List;

public abstract class Jewels implements IEquipable {
    protected int weight;
    protected int dexterety;
    protected int intelligence;

    @Override
    public int getWeight() {
        return weight;
    }

    public int getDexterety() {
        return dexterety;
    }

    public int getIntelligence() {
        return intelligence;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

package Item.Weapon;

import Item.IPicable;
import Item.IEquipable;
import Character.Character;



import java.util.List;

public abstract class Weapon implements IEquipable{
    protected int weight;
    protected int Strenght;

    @Override
    public int getWeight() {
        return weight;
    }

    public int getStrenght() {
        return Strenght;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

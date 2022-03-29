package Item.Weapon;

import Character.Stat.Stat;
import Character.Stat.Strength;
import Item.IPicable;
import Item.IEquipable;
import Character.Character;



import java.util.List;

public abstract class Weapon implements IEquipable{
    protected int weight;
    protected int strenght;

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public int modifier(Stat stat) {
        if(stat instanceof Strength)
            return strenght;
        return 0;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

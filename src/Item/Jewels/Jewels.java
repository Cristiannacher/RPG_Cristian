package Item.Jewels;

import Character.Stat.Dexterity;
import Character.Stat.Intelligence;
import Character.Stat.Stat;
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

    @Override
    public int modifier(Stat stat) {
        if(stat instanceof Dexterity)
            return dexterety;
        if(stat instanceof Intelligence)
            return intelligence;
        return 0;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

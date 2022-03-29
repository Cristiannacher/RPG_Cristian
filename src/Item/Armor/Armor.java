package Item.Armor;

import Character.Stat.Constitution;
import Character.Stat.Stat;
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

    @Override
    public int modifier(Stat stat){
        if(stat instanceof Constitution)
            return  constitution;
        return 0;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

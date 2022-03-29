package Item;

import Character.Stat.*;

public class EquipableMock implements IEquipable{

    @Override
    public int modifier(Stat stat) {
       if(stat instanceof Intelligence)
        return 1;
        if(stat instanceof Dexterity)
            return 1;
        if(stat instanceof Strength)
            return 1;
        if(stat instanceof Constitution)
            return 1;
        return 0;
    }

    @Override
    public int getWeight() {
        return 0;
    }
}

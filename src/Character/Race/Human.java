package Character.Race;

import Character.Stat.Constitution;
import Character.Stat.Dexterity;
import Character.Stat.Stat;
import Character.Stat.Strength;

public class Human extends Race{
    @Override
    public int modifier(Stat stat) {
        if(stat instanceof Strength)
            return 2;
        if(stat instanceof Constitution)
            return 2;
        if(stat instanceof Dexterity)
            return 1;
        return 0;
    }
}

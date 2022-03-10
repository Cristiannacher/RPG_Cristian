package Character.Race;

import Character.Stat.*;

public class Bruja extends Race{
    @Override
    public int modifier(Stat stat) {
        if(stat instanceof Strength)
            return -2;
        if(stat instanceof Intelligence)
            return 4;
        if(stat instanceof Dexterity)
            return 3;
        return 0;
    }
}

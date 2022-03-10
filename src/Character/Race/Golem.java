package Character.Race;

import Character.Stat.*;

public class Golem  extends Race{
    @Override
    public int modifier(Stat stat) {
        if(stat instanceof Strength)
            return 4;
        if(stat instanceof Constitution)
            return 4;
        if(stat instanceof Intelligence)
            return -3;
        return 0;
    }
}

package Character.Job;

import Character.Stat.*;

public class Artificer extends Job{
    @Override
    public int modifier(Stat stat) {
        if (stat instanceof Intelligence)
            return 2;
        if(stat instanceof Constitution)
            return +1;
        if(stat instanceof Dexterity)
            return +2;
        return 0;
    }
}

package Character.Job;

import Character.Stat.Dexterity;
import Character.Stat.Intelligence;
import Character.Stat.Stat;

public class Mage extends Job{

    @Override
    public int modifier(Stat stat) {
        if(stat instanceof Intelligence)
           return  4;
        if(stat instanceof Dexterity)
            return 1;
        return 0;
    }


}

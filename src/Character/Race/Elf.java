package Character.Race;

import Character.Stat.*;

public class Elf extends Race{
    @Override
        public int modifier(Stat stat) {
            if(stat instanceof Intelligence)
                return 3;
            if(stat instanceof Constitution)
                return -1;
            if(stat instanceof Dexterity)
                return 3;
            return 0;
    }
}

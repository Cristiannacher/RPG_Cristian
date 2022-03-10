package Character.Job;

import Character.Stat.Constitution;
import Character.Stat.Stat;
import Character.Stat.Strength;

import java.lang.invoke.ConstantBootstraps;

public class Defender extends Job {

    @Override
    public int modifier(Stat stat) {
        if (stat instanceof Constitution)
            return 2;
        if (stat instanceof Strength)
            return 3;
        return 0;
    }
}

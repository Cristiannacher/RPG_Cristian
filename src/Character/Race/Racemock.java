package Character.Race;

import Character.Stat.Stat;

public class Racemock extends Race{

    private int raceValue;

    public Racemock (int raceValue){
        this.raceValue = raceValue;
    }

    @Override
    public int modifier(Stat stat) {
        return raceValue;
    }
}

package Character.Job;

import Character.Stat.Stat;

public class Jobmock extends Job{

    private int modifiervalue;

    public Jobmock (int modifiervalue){
        this.modifiervalue = modifiervalue;
    }

    @Override
    public int modifier(Stat stat) {
        return modifiervalue;
    }
}

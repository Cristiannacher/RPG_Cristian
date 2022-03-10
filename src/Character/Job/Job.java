package Character.Job;

import Character.Stat.Stat;

public abstract class Job {

    public abstract int modifier(Stat stat);

    public boolean equals(Object obj) {
        if (obj == null) return false;
        return getClass()==obj.getClass();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

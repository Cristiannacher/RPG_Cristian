package Character.Race;

import Character.Stat.Stat;

public abstract class Race {
    public abstract  int modifier(Stat stat);

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

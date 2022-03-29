package Character.Stat;

public abstract class Stat {

    private int value;

    public Stat (int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public void increase(int value){
        this.value += value;
    }
    public void decrease(int value){
        this.value -= value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": "+ value;
    }
}

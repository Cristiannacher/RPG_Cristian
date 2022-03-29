package Character.Stat;

public abstract class Stat {

    private int value;

    public Stat (int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public void increase(){
        this.value += 1;
    }
    public void decrease(){
        this.value -= 1;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": "+ value;
    }
}

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
        value++;
    }
    public void decrease(){
        value--;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": "+ value;
    }
}

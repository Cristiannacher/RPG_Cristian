package Character;

public interface IDamageable {

    double maxHealth();
    double health();
    boolean isDead();
    void receivesDamage(double amount);
    void heals(double amount);

}

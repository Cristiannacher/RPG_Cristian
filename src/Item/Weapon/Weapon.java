package Item.Weapon;

import Item.IChargeable;
import Item.IPortable;
import Character.Character;



import java.util.List;

public abstract class Weapon implements IPortable, IChargeable {
    protected int weight;
    protected int Strenght;

    @Override
    public int getWeight() {
        return weight;
    }

    public int getStrenght() {
        return Strenght;
    }

    @Override
    public void carry(Character character) {
        List<IPortable> portables = character.getPortableList();
        if (!portables.isEmpty()) {
            for (Object object : portables) {
                if (object.equals(this))
                    System.out.println("You already have a weapon");
                else {
                    character.addPortable(this);
                    character.increaseStrenght(Strenght);
                }
            }
        } else {
            character.addPortable(this);
            character.increaseStrenght(Strenght);
        }
    }
}

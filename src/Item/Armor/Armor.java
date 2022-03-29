package Item.Armor;

import Item.IChargeable;
import Item.IPortable;
import Character.Character;

import java.util.List;

public abstract class Armor implements IPortable, IChargeable {
    protected int weight;
    protected int constitution;

    @Override
    public int getWeight() {
        return weight;
    }

    public int getConstitution() {
        return constitution;
    }

    @Override
    public void carry(Character character) {
        List<IPortable> portables = character.getPortableList();
        if (!portables.isEmpty()) {
            for (Object object : portables) {
                if (object.equals(this)) {
                    System.out.println("You already have an armor");
                    break;
                } else {
                    character.addPortable(this);
                    character.increaseConstitution(constitution);
                }
            }
        } else {
            character.addPortable(this);
            character.increaseConstitution(constitution);
        }
    }
}

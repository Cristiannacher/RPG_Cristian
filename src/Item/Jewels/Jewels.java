package Item.Jewels;

import Item.IChargeable;
import Item.IPortable;
import Character.Character;

import java.util.List;

public abstract class Jewels implements IPortable, IChargeable {
    protected int weight;
    protected int dexterety;
    protected int intelligence;

    @Override
    public int getWeight() {
        return weight;
    }

    public int getDexterety() {
        return dexterety;
    }

    public int getIntelligence() {
        return intelligence;
    }

    @Override
    public void carry(Character character) {
        List<IPortable> portables = character.getPortableList();
        if(!portables.isEmpty()) {
            for (Object object : portables) {
                if (object.equals(this))
                    System.out.println("You already have a jewel");
                else {
                    character.addPortable(this);
                    character.increaseIntelligence(intelligence);
                    character.increaseDexterety(dexterety);
                }
            }
        } else {
            character.addPortable(this);
            character.increaseIntelligence(intelligence);
            character.increaseDexterety(dexterety);
        }
    }

}

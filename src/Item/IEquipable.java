package Item;

import Character.Character;
import Character.Stat.Stat;

public interface IEquipable extends IPicable {

    int modifier(Stat stat);
}

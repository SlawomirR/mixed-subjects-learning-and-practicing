package players_and_monsters;

import java.util.ArrayList;
import java.util.List;

public class Monster implements Savable {

    private String monsterName;
    private int hitPoints;
    private int strength;

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<>();
        values.add(0, this.monsterName);
        values.add(1, String.valueOf(this.hitPoints));
        values.add(2, String.valueOf(this.strength));
        return values;
    }

    @Override
    public void read(List<String> savedValues) {
        if (savedValues != null && savedValues.size() > 0) {
            this.monsterName = savedValues.get(0);
            this.hitPoints = Integer.valueOf(savedValues.get(1));
            this.strength = Integer.valueOf(savedValues.get(2));
        }
    }

    Monster(String monsterName, int hitPoints, int strength) {
        this.monsterName = monsterName;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    int getStrength() {
        return strength;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "monsterName='" + monsterName + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                '}';
    }
}

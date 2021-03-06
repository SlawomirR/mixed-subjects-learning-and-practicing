package players_and_monsters;

import java.util.ArrayList;
import java.util.List;

public class Player implements Savable {

    private String playerName;
    private String playerWeapon;
    private int hitPoints;
    private int strength;

    Player(String playerName, int hitPoints, int strength) {
        this.playerName = playerName;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.playerWeapon = "Sword";
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<>();
        values.add(0, this.playerName);
        values.add(1, String.valueOf(this.hitPoints));
        values.add(2, String.valueOf(this.strength));
        values.add(3, playerWeapon);
        return values;
    }

    @Override
    public void read(List<String> savedValues) {
        if (savedValues != null && savedValues.size() > 0) {
            this.playerName = savedValues.get(0);
            this.hitPoints = Integer.parseInt(savedValues.get(1));
            this.strength = Integer.parseInt(savedValues.get(2));
            this.playerWeapon = savedValues.get(3);
        }
    }

    void setPlayerWeapon(String playerWeapon) {
        this.playerWeapon = playerWeapon;
    }

    void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", playerWeapon='" + playerWeapon + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                '}';
    }
}

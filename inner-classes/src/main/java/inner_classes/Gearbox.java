package inner_classes;

import java.util.ArrayList;
import java.util.List;

class Gearbox {

    private List<Gear> gears;
    private int maxGears;
    private int currentGearNumber = 0;
    private boolean clutchIsIn;

    Gearbox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<>();
        Gear neutral = new Gear(0, 0.0);
        this.gears.add(neutral);

        for (int i = 0; i < maxGears; i++) {
            addGear(i, i * 5.3);
        }
    }

    void operateClutch(boolean in) {
        this.clutchIsIn = in;
    }

    void addGear(int numberOfGears, double ratio) {
        if ((numberOfGears > 0) && (numberOfGears <= maxGears)) {
            this.gears.add(new Gear(numberOfGears, ratio));
        }
    }

    void changeGear(int newGear) {
        if ((newGear >= 0) && (newGear < this.gears.size()) && this.clutchIsIn) {
            this.currentGearNumber = newGear;
            System.out.println("Gear " + newGear + " selected.");
        } else {
            System.out.println("Grind!");
            currentGearNumber = 0;
        }
    }

    public double weelSpeed(int revs) {
        if (clutchIsIn) {
            System.out.println("Scream!!!");
            return 0.0;
        }
        return revs * gears.get(currentGearNumber).getRatio();
    }

    private class Gear {

        private int gearNumber;
        private double ratio;


        Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber;
            this.ratio = ratio;
        }

        double driveSpeed(int revs) {
            return revs * this.ratio;
        }

        double getRatio() {
            return ratio;
        }
    }
}

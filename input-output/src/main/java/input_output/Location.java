package input_output;

import java.util.HashMap;
import java.util.Map;

class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if (exits != null) {
            this.exits = new HashMap<>(exits);
        } else {
            this.exits = new HashMap<>();
        }
        this.exits.put("Q", 0);
    }

//    public void addExit(String direction, int location) {
//        exits.put(direction, location);
//    }

    int getLocationID() {
        return locationID;
    }

    String getDescription() {
        return description;
    }

    Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }

    void addExit(String directions, int location) {
        exits.put(directions, location);
    }
}

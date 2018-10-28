package input_output;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if (exits != null) {
            this.exits = new LinkedHashMap<>(exits);
        } else {
            this.exits = new LinkedHashMap<>();
        }
        this.exits.put("Q", 0);
    }

    int getLocationID() {
        return locationID;
    }

    String getDescription() {
        return description;
    }

    Map<String, Integer> getExits() {
        return new LinkedHashMap<>(exits);
    }

    void addExit(String directions, int location) {
        exits.put(directions, location);
    }
}

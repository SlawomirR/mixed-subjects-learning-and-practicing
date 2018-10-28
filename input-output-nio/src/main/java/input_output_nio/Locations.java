package input_output_nio;

import java.io.*;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Locations implements Map<Integer, Location> {

    private static final String DATA_FILE = "input-output-nio/locations.dat";
    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static boolean isRead = false;

    public static void main(String[] args) throws IOException {
        if (isRead) {
//        try (
//                DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(DATA_FILE)))
//        ) {
//            for (Location location : locations.values()) {
//                locFile.writeInt(location.getLocationID());
//                locFile.writeUTF(location.getDescription());
//                System.out.println("Write location " + location.getLocationID() + " : " + location.getDescription());
//                System.out.println("Writing" + (location.getExits().size() - 1) + " exits.");
//                locFile.writeInt(location.getExits().size() - 1);
//                for (String direction : location.getExits().keySet()) {
//                    if (!direction.equalsIgnoreCase("Q")) {
//                        System.out.println("\t\t" + direction + "," + location.getExits().get(direction));
//                        locFile.writeUTF(direction);
//                        locFile.writeInt(location.getExits().get(direction));
//                    }
//                }
//            }
//        }
            try (
                    ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(DATA_FILE)))
            ) {
                for (Location location : locations.values()) {
                    locFile.writeObject(location);
                }
            }
        } else {
            System.out.println("File didn't read properly so writing is blocked!");
        }
    }

    static {
        try (
                ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream(DATA_FILE)))
        ) {
            boolean eof = false;
            while (!eof) {
                try {
                    Location location = (Location) locFile.readObject();
                    System.out.println("Read location " + location.getLocationID() + " : " + location.getDescription());
                    System.out.println("Found " + location.getExits().size() + " exits");
                    locations.put(location.getLocationID(), location);
                } catch (EOFException e) {
                    System.out.println("EOFException, so OK");
                    eof = true;
                }
            }
            isRead = true;
        } catch (IOException io) {
            System.out.println("IO Exception " + io.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException " + e.getMessage());
        }
//        try (DataInputStream locFile = new DataInputStream(new BufferedInputStream(new FileInputStream(DATA_FILE)))
//        ) {
//            boolean eof = false;
//            while (!eof) {
//                try {
//                    Map<String, Integer> exits = new LinkedHashMap<>();
//                    int locID = locFile.readInt();
//                    String description = locFile.readUTF();
//                    int numExits = locFile.readInt();
//                    System.out.println("Read location " + locID + " : " + description);
//                    System.out.println("Found " + numExits + " exits");
//                    for (int i = 0; i < numExits; i++) {
//                        String direction = locFile.readUTF();
//                        int destination = locFile.readInt();
//                        exits.put(direction, destination);
//                        System.out.println("\t\t" + direction + "," + destination);
//                    }
//                    locations.put(locID, new Location(locID, description, exits));
//                } catch (EOFException e) {
//                    eof = true;
//                }
//            }
//            isRead = true;
//        } catch (IOException io) {
//            System.out.println("IO Exception occurred.");
//        }
//        try (
//                Scanner scanner = new Scanner(new BufferedReader(new FileReader("input-output-nio/locations_big.txt")))
//        ) {
//            scanner.useDelimiter(",");
//            while (scanner.hasNextLine()) {
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String description = scanner.nextLine();
//                System.out.println("Imported loc: " + loc + ": " + description);
//                Map<String, Integer> tempExit = new LinkedHashMap<>();
//                locations.put(loc, new Location(loc, description, tempExit));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // Now read the exits
//        try (
//                BufferedReader dirFile = new BufferedReader(new FileReader("input-output-nio/directions_big.txt"))
//        ) {
//            String input;
//            while ((input = dirFile.readLine()) != null) {
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String directions = data[1];
//                int destination = Integer.parseInt(data[2]);
//
//                System.out.println(loc + ": " + directions + ": " + destination);
//                Location location = locations.get(loc);
//                location.addExit(directions, destination);
//            }
//            isRead = true;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {
    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}

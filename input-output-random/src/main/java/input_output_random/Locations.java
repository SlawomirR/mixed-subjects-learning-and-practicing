package input_output_random;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Locations implements Map<Integer, Location> {

    private static final String DATA_FILE = "input-output-random/locations_rand.dat";
    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile ra;
    private static boolean isRead = false;

    public static void main(String[] args) throws IOException {
        if (isRead) {
            try (
                    RandomAccessFile raf = new RandomAccessFile(DATA_FILE, "rwd")
            ) {
                raf.writeInt(locations.size());
                int indexSize = locations.size() * 3 * Integer.BYTES;
                int locationStart = (int) (indexSize + raf.getFilePointer() + Integer.BYTES);
                raf.writeInt(locationStart);

                long indexStart = raf.getFilePointer();

                int startPointer = locationStart;
                raf.seek(startPointer);

                for (Location location : locations.values()) {
                    raf.writeInt(location.getLocationID());
                    raf.writeUTF(location.getDescription());
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String direction : location.getExits().keySet()) {
                        if (!direction.equalsIgnoreCase("Q")) {
                            stringBuilder.append(direction);
                            stringBuilder.append(",");
                            stringBuilder.append(location.getExits().get(direction));
                            stringBuilder.append(",");
                        }
                    }
                    raf.writeUTF(stringBuilder.toString());

                    IndexRecord record = new IndexRecord(startPointer, (int) (raf.getFilePointer() - startPointer));
                    index.put(location.getLocationID(), record);

                    startPointer = (int) raf.getFilePointer();
                }
                raf.seek(indexStart);
                for (Integer locationID : index.keySet()) {
                    raf.writeInt(locationID);
                    raf.writeInt(index.get(locationID).getStartByte());
                    raf.writeInt(index.get(locationID).getLength());
                }
            }
        } else {
            System.out.println("File didn't read properly so writing is blocked!");
        }
    }

    // 1. The first four bytes will contain the number of locations (bytes 0-3)
    // 2. The next four bytes will contain the start offset of the locations section (bytes 4-7)
    // 3. The next section of the file will contain the index (the index is 1692 bytes long. It will start at byte 8 and end a byte 1699)
    // 4. The final section of the file will contain the location records (the data). It will start at byte 1700.

    static {
        try {
            ra = new RandomAccessFile(DATA_FILE, "rwd");
            int numLocations = ra.readInt();
            long locationStartPoint = ra.readInt();

            while (ra.getFilePointer() < locationStartPoint) {
                int locationID = ra.readInt();
                int locationStart = ra.readInt();
                int locationLength = ra.readInt();

                IndexRecord record = new IndexRecord(locationStart, locationLength);
                index.put(locationID, record);
            }
            isRead = true;
        } catch (IOException io) {
            System.out.println("IOException in static initializer: " + io.getMessage());
        }
    }

    public Location getLocation(int locationID) throws IOException {
        IndexRecord record = index.get(locationID);
        ra.seek(record.getStartByte());
        int id = ra.readInt();
        String description = ra.readUTF();
        String exits = ra.readUTF();
        String[] exitPart = exits.split(",");

        Location location = new Location(locationID, description, null);

        if (locationID != 0) {
            for (int i = 0; i < exitPart.length; i++) {
                System.out.println("exitPart = " + exitPart[i]);
                System.out.println("exitPart[+1] = " + exitPart[i + 1]);
                String direction = exitPart[i];
                int destination = Integer.parseInt(exitPart[++i]);
                location.addExit(direction, destination);
            }
        }
        return location;
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

    public void close() throws IOException {
        ra.close();
    }
}

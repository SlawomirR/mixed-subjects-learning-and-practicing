/*
 * Napisać metodę, która przyjmuje String w formacie "klucz1=wartość1&klucz2=wartość2" itd.
 * Metoda ma zwracać Map<String, String>.
 * Jest dopuszczalne, by wartość klucza lub wartości była pusta, ale musi być zachowany znak równości np. "=wartość1", "klucz21=".
 * Jeśli otrzymany String jest null, metoda powinna zwracać null.
 * Jeśli otrzymany String jest pusty, metoda zwraca pustą Mapę.
 */

import java.util.HashMap;
import java.util.Map;

public class DecodeFormattedString {

    private static final String STRING_TO_DECODE = "=&=wartość1&klucz2=&klucz3=wartosc3&=wartosc4&klucz5=&=";

    public static void main(String[] args) {
        System.out.println("===> Zadanie 2: " + decode(STRING_TO_DECODE).toString());
    }

    static Map<String, String> decode(String s) {
        Map<String, String> stringMap = new HashMap<>();
        if (s == null) {
            return null;
        }
        if (s.isEmpty()) {
            return new HashMap<>();
        }
        if (!s.contains("=")) {
            throw new IllegalArgumentException("String must contain '=' sign!");
        }
        String[] strings = s.split("&");
        for (String str : strings) {
            String[] splitOnEqualSign = str.split("=");
            if (splitOnEqualSign.length == 0) {
                continue;
            }
            if (splitOnEqualSign.length > 2) {
                throw new IllegalArgumentException("String must contain single '=' signs separated by '&' sign.");
            }
            if (stringMap.containsKey(splitOnEqualSign[0])) {
                System.err.println("WARNING: There were duplicated key! So value was updated to the last occurrence!");
            }
            if (splitOnEqualSign.length == 1) {
                stringMap.put(splitOnEqualSign[0], "");
            }
            if (splitOnEqualSign.length == 2) {
                stringMap.put(splitOnEqualSign[0], splitOnEqualSign[1]);
            }
        }
        return stringMap;
    }
}

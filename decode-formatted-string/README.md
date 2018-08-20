Napisać metodę, która przyjmuje String w formacie "klucz1=wartość1&klucz2=wartość2" itd.
Metoda ma zwracać Map<String, String>.
Jest dopuszczalne, by wartość klucza lub wartości była pusta, ale musi być zachowany znak równości np. "=wartość1", "klucz21=".
Jeśli otrzymany String jest null, metoda powinna zwracać null.
Jeśli otrzymany String jest pusty, metoda zwraca pustą Mapę.
```
@Override
public static Map<String, String> decode(String s) {

    return null; // TODO implement it

}
```

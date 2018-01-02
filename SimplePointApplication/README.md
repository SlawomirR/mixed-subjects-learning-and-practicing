Napisz program, który pozwala na kontrolowanie danych obiektu, który reprezentuje punkt na płaszczyźnie.

Punkt (klasa Point - Point.java) powinien zawierać dwa pola reprezentujące współrzędną X oraz Y - reprezentacja
współrzędnych powinna być całkowitoliczbowa. Klasa powinna być zgodna ze specyfikacją JavaBeans. Klasa powinna
posiadać konstruktor bezparametrowy oraz pozwalający ustawić odpowiednie współrzędne w trakcie tworzenia obiektu.
Klasa PointController (PointController.java) posiada cztery metody, które pozwalają manipulować położeniem punktu:
-addX() - zwiększa zmienną x o 1
-minusX() - zmniejsza zmienną x o 1
-addY() - zwiększa zmienną y o 1
-minusY() - zmniejsza zmienną y o 1
Każda z metod przyjmuje jako parametr obiekt klasy Point i na nim operuje.
Obie klasy powinny znajdować się w osobnych pakietach, a ich działanie powinno zostać przetestowane w trzeciej klasie o nazwie PointApplication.

Struktury sterujące - Zadanie
W kolejnym kroku wykorzystaj dotychczasowy projekt. W klasie PointApplication dodaj proste sterowanie, które pozwoli
na zmianę wartości współrzędnych punktu w zależności od wybranej opcji.
Zdefiniuj 4 stałe pozwalające na wybór odpowiedniego zachowania ADD_X, ADD_Y, MINUS_X, MINUS_Y
Wykorzystaj strukturę switch i w niej wywołaj odpowiednią metodę klasy PointController
Wyświetl zmienione współrzędne punktu
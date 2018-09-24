package countPassengers;

import java.util.ArrayList;

public class CountPassengers {

    public static void main(String[] args) {
        ArrayList<int[]> listOfArrays = new ArrayList<>();
        int[] temp1 = {10, 0};
        int[] temp2 = {3, 5};
        int[] temp3 = {2, 5};
        listOfArrays.add(temp1);
        listOfArrays.add(temp2);
        listOfArrays.add(temp3);

        System.out.println(countPassengers(listOfArrays) + "");
    }

    public static int countPassengers(ArrayList<int[]> stops) {
        if (stops == null || stops.size() == 0) {
            return 0;
        }
        int result = 0;
        for (int[] busStop : stops) {
            result += busStop[0] - busStop[1];
        }
        return result >= 0 ? result : 0;
    }
}

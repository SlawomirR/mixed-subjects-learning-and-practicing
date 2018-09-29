import java.util.Arrays;
import java.util.Collections;

public class ArraySorting {

    public static void main(String[] args) {
        int[] originalArray = {17, 4, 13, 2, 19, 5, 14, 7, 9, 8};

        System.out.println("Original array: " + Arrays.toString(originalArray));

        Arrays.sort(originalArray);
        System.out.println("Array sorted ascending: " + Arrays.toString(originalArray));

        Integer[] integerArray = Arrays.stream(originalArray).boxed().toArray(Integer[]::new);
        Arrays.sort(integerArray, Collections.reverseOrder());
        System.out.println("Array sorted descending: " + Arrays.toString(integerArray));
    }
}

/* Napisać metodę, która pobiera dwie tablice int: array i subArray.
 * Jeśli tablica array zawiera dokładną tablicę subArray, to zwracany jest index zaczynający podtablicę.
 * Jeśli tablica array zawiera kilkukrotnie tablicę subArray, to zwracany jest index ostatniego wystąpienia.
 * Jeśli array nie zawiera subArray, zwracane jest -1.
 */

import java.util.Arrays;

public class IsArrayContainingSubarray {

    public static void main(String[] args) {
        IsArrayContainingSubarray subarrayInArray = new IsArrayContainingSubarray();

        int[] array = {3, 4, 5, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] subArray = {3, 4, 5};
        System.out.println("===> Zadanie 1: " + subarrayInArray.findArray(array, subArray));

    }

    private int findArray(int[] array, int[] subArray) {
        if (array == null || subArray == null || array.length < subArray.length) {
            return -1;
        }
        StringBuilder arrayStrBuild = new StringBuilder();
        Arrays.stream(array).forEach(arrayStrBuild::append);

        StringBuilder subArrayStrBuild = new StringBuilder();
        Arrays.stream(subArray).forEach(subArrayStrBuild::append);

        return arrayStrBuild.lastIndexOf(subArrayStrBuild.toString());
    }
}

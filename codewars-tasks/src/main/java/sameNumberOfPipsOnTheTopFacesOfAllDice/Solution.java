package sameNumberOfPipsOnTheTopFacesOfAllDice;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A1 = {1, 2, 3};
        int[] A2 = {1, 1, 6};
        int[] A3 = {1, 6, 2, 3};
        int[] A4 = {1, 1, 1, 1};
        int[] A5 = {1, 6, 2, 3, 4};
        System.out.println("A1:2 => " + s.solution(A1));
        System.out.println("A2:2 => " + s.solution(A2));
        System.out.println("A3:3 => " + s.solution(A3));
        System.out.println("A4:0 => " + s.solution(A4));
        System.out.println("A5:4 => " + s.solution(A5));
    }

    public int solution(int[] A) {
        int min = Integer.MAX_VALUE;
        int[][] solArray = {
                {0, 1, 1, 1, 1, 2},
                {1, 0, 1, 1, 2, 1},
                {1, 1, 0, 2, 1, 1},
                {1, 1, 2, 0, 1, 1},
                {1, 2, 1, 1, 0, 1},
                {2, 1, 1, 1, 1, 0}
        };
        int couter;

        for (int cellA1 : A) {
            couter = 0;
            for (int cellA : A) {
                couter += solArray[cellA1 - 1][cellA - 1];
            }
            if (min > couter) {
                min = couter;
            }
        }
        return min;
    }
}

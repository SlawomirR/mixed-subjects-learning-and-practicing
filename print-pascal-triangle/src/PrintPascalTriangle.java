import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrintPascalTriangle {

    public static void main(String[] args) {
        int row;
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many rows of Pascal's Triangle would you like to print?: ");
        row = scanner.nextInt();

        for (int i = 0; i < row; i++) {
            for (int j = row; j > i - 1; j--) {
                System.out.print(" ");
            }
            int value = 1;
            for (int k = 0; k <= i; k++) {
                String numberString = IntStream
                        .range(0, (longestValue(row) - String.valueOf(value).length()))
                        .mapToObj(e -> " ")
                        .collect(Collectors.joining(""));
                System.out.print(" " + (value + numberString));
                value = value * (i - k) / (k + 1);
            }
            System.out.println();
        }

        scanner.close();
    }

    private static int longestValue(int row) {
        int value = 1;
        for (int k = 0; k <= (row - 1) / 2; k++) {
            value = value * ((row - 1) - k) / (k + 1);
        }
        return String.valueOf(value).length();
    }
}

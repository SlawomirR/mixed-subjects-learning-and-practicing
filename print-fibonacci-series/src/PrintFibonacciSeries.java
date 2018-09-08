import java.util.Scanner;

public class PrintFibonacciSeries {

    public static void main(String[] args) {

        int limit;
        int previousNumber = 1;
        int beforePreviousNumber = 0;
        int currentNumber;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter limiting number in Fibonacci Series: ");
        limit = scanner.nextInt();
        System.out.print("Fibonacci Series : " + beforePreviousNumber + "  " + previousNumber + "  ");
        currentNumber = beforePreviousNumber + previousNumber;
        limit = limit - 2; // we manually print first 2 numbers.
        while (limit > 0) {
            System.out.print(currentNumber + " ");
            beforePreviousNumber = previousNumber;
            previousNumber = currentNumber;
            currentNumber = beforePreviousNumber + previousNumber;
            limit--;
        }
    }
}

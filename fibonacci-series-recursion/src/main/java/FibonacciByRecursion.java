public class FibonacciByRecursion {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.printf("Fibonacci of %d is: %d\n", i, fibonacciSeries(i));
        }
    }

    private static long fibonacciSeries(long numberOfElements) {
        if (numberOfElements < 0) {
            System.out.println("Positive integer expected");
            return 0;
        }
        if (numberOfElements == 0 || numberOfElements == 1) {
            return numberOfElements;
        }
        return fibonacciSeries(numberOfElements - 1) + fibonacciSeries(numberOfElements - 2);
    }
}
import java.util.Scanner;

public class SwapTwoNumbersWithoutUsingThirdVariable {

    public static void main(String[] args) {
        long numberX;
        long numberY;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Provide first number, please: ");
        numberX = scanner.nextInt();
        System.out.print("Provide second number, please: ");
        numberY = scanner.nextInt();

        System.out.println("   Your numbers: A = " + numberX + " and B = " + numberY);
        numberX = numberX + numberY;
        numberY = numberX - numberY;
        numberX = numberX - numberY;
        System.out.println("Swapped numbers: A = " + numberX + " and B = " + numberY);

        scanner.close();
    }
}

package findMaxAndMinInStringNumbers;

public class findMaxAndMinInStringNumbers {

    public static void main(String[] args) {
        System.out.println(highAndLow("4 18 5 2 -9 -3 6 -1 0"));
    }

    public static String highAndLow(String numbers) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int temporaryValue;

        for (String singleStringNumber : numbers.split(" ")) {
            temporaryValue = Integer.valueOf(singleStringNumber, 10);
            if (min > temporaryValue) {
                min = temporaryValue;
            }
            if (max < temporaryValue) {
                max = temporaryValue;
            }
        }

        return max + " " + min;
    }
}

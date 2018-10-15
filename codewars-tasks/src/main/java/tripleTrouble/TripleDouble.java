package tripleTrouble;

public class TripleDouble {

    public static void main(String[] args) {
        System.out.println(tripleDouble(451999277, 41177722899L) == 1 ? "OK" : "ERROR");
        System.out.println(tripleDouble(1222345, 12345) == 0 ? "OK" : "ERROR");
        System.out.println(tripleDouble(12345, 12345) == 0 ? "OK" : "ERROR");
        System.out.println(tripleDouble(666789, 12345667) == 1 ? "OK" : "ERROR");
    }

    public static int tripleDouble(long num1, long num2) {
        String num1Str = String.valueOf(num1);
        String num2Str = String.valueOf(num2);
        for (int i = 0; i < 10; i++) {
            String nStr = String.valueOf(i);
            if (num1Str.matches(nStr + nStr + nStr) && num2Str.matches(nStr + nStr)) {
                return 1;
            }
        }
        return 0;
    }
/*
        Set<Character> multiNum1Set = new TreeSet<>();
        char[] num1Char = String.valueOf(num1).toCharArray();
        char[] num2Char = String.valueOf(num2).toCharArray();
        int count = 0;
        char temp = '0';
        for (char numChar : num1Char) {
            if (temp == numChar) {
                count++;
            } else {
                temp = numChar;
                count = 1;
            }
            if (count == 3) {
                multiNum1Set.add(numChar);
                count = 0;
            }
        }
        count = 0;
        for (char numChar : num2Char) {
            if (temp == numChar) {
                count++;
            } else {
                temp = numChar;
                count = 1;
            }
            if (count == 2) {
                if (multiNum1Set.contains(temp)) {
                    return 1;
                }
                count = 0;
            }
        }
        return 0;
    }
*/
}

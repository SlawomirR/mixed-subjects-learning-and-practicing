package arabicToRomanConversion;

import java.util.Arrays;
import java.util.List;

public class ArabicToRomanConversion {

    public static void main(String[] args) {
        int num;
        num = 1;
        System.out.println(num + " => " + solution(num));
        num = 4;
        System.out.println(num + " => " + solution(num));
        num = 5;
        System.out.println(num + " => " + solution(num));
        num = 9;
        System.out.println(num + " => " + solution(num));
        num = 10;
        System.out.println(num + " => " + solution(num));
        num = 14;
        System.out.println(num + " => " + solution(num));
        num = 19;
        System.out.println(num + " => " + solution(num));
        num = 50;
        System.out.println(num + " => " + solution(num));
        num = 90;
        System.out.println(num + " => " + solution(num));
        num = 120;
        System.out.println(num + " => " + solution(num));
        num = 440;
        System.out.println(num + " => " + solution(num));
        num = 940;
        System.out.println(num + " => " + solution(num));
        num = 1666;
        System.out.println(num + " => " + solution(num));
        num = 1918;
        System.out.println(num + " => " + solution(num));
        num = 2008;
        System.out.println(num + " => " + solution(num));
    }

    public static String solution(int n) {
        List<Character> romanCharacters = Arrays.asList('I', 'V', 'X', 'L', 'C', 'D', 'M');
        StringBuilder result = new StringBuilder();

        if (n < 0 || n > 3999) {
            return "IllegalStateException";
        }
        if (n == 0) {
            return "";
        }
        char[] singleChar = String.valueOf(n).toCharArray();
        for (int k = 0; k < singleChar.length; k++) {
            int i = (((singleChar.length - 1) - k) * 2);
            switch (singleChar[k]) {
                case '1':
                    result.append(romanCharacters.get(i));
                    break;
                case '2':
                    result.append(romanCharacters.get(i)).append(romanCharacters.get(i));
                    break;
                case '3':
                    result.append(romanCharacters.get(i)).append(romanCharacters.get(i)).append(romanCharacters.get(i));
                    break;
                case '4':
                    result.append(romanCharacters.get(i)).append(romanCharacters.get(i + 1));
                    break;
                case '5':
                    result.append(romanCharacters.get(i + 1));
                    break;
                case '6':
                    result.append(romanCharacters.get(i + 1)).append(romanCharacters.get(i));
                    break;
                case '7':
                    result.append(romanCharacters.get(i + 1)).append(romanCharacters.get(i)).append(romanCharacters.get(i));
                    break;
                case '8':
                    result.append(romanCharacters.get(i + 1)).append(romanCharacters.get(i)).append(romanCharacters.get(i)).append(romanCharacters.get(i));
                    break;
                case '9':
                    result.append(romanCharacters.get(i)).append(romanCharacters.get(i + 2));
                    break;
                case '0':
                    break;
            }
        }
        return result.toString();
    }
}

public class CheckPalindrome {

    private static final String WORD_1 = "Deleveled";
    private static final String WORD_2 = "Titanic";
    private static final String WORD_3 = "38783";
    private static final String WORD_4 = "112";

    public static void main(String[] args) {
        System.out.println("Is \"" + WORD_1 + "\" a palindtom word?: " + isPalindrome(WORD_1));
        System.out.println("Is \"" + WORD_2 + "\" a palindtom word?: " + isPalindrome(WORD_2));
        System.out.println("Is \"" + WORD_3 + "\" a palindtom word?: " + isPalindrome(WORD_3));
        System.out.println("Is \"" + WORD_4 + "\" a palindtom word?: " + isPalindrome(WORD_4));
    }

    private static boolean isPalindrome(String textToCheck) {
        StringBuilder stringBuilder = new StringBuilder(textToCheck);
        return textToCheck.toLowerCase().equals(stringBuilder.reverse().toString().toLowerCase());
    }
}

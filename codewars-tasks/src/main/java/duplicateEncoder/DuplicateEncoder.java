package duplicateEncoder;

public class DuplicateEncoder {

    public static void main(String[] args) {
        // If a letter has duplicates print ")" otherwise "("
        System.out.println(encode("Alibaba"));
    }

    static String encode(String word) {
        word = word.toLowerCase();
        StringBuilder encodedString = new StringBuilder();
        char tempChar;
        for (int i = 0; i < word.length(); i++) {
            tempChar = word.charAt(i);
            encodedString.append(word.indexOf(tempChar) == word.lastIndexOf(tempChar) ? "(" : ")");
        }
        return encodedString.toString();
    }
}

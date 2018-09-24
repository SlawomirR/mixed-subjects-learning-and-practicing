package jadenCase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JadenCase {

    public static void main(String[] args) {
        JadenCase jadenCase = new JadenCase();
        // Each word should start with capital letter.
        System.out.println(jadenCase.toJadenCase("today no posts. i feel sick and i'm tired."));
    }

    public String toJadenCase(String phrase) {
        List<String> phraseList = Arrays.asList(phrase.split(" "));
        String result;
        result = phraseList.stream()
                .map(e -> e.replaceFirst(e.substring(0, 1), e.substring(0, 1).toUpperCase()))
                .collect(Collectors.joining(" "));
        return result;
    }
}

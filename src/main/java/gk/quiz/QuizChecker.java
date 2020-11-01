package gk.quiz;

import java.util.*;

/**
 * Implements the checker algorithm
 */
class QuizChecker {

    /**
     * @param quizText the whole input file
     * @return a map containing the lines and the occurrences
     */
    Map<String, Occurrences> check(String quizText) {
        Map<String, Occurrences> lines = new HashMap<>();

        StringTokenizer tokenizer = new StringTokenizer(quizText, "\n");

        for (Integer i = 1; tokenizer.hasMoreTokens(); i++) {
            String token = tokenizer.nextToken();

            checkOccurrence(token, i, lines);
        }

        return lines;
    }

    private void checkOccurrence(String token, Integer lineNumber, Map<String, Occurrences> lines) {
        String key = token.toLowerCase();
        Occurrences occurrences = lines.get(key);

        if (occurrences == null) {
            occurrences = new Occurrences();
        }

        occurrences.add(lineNumber);

        lines.put(key, occurrences);
    }

}

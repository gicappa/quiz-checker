package gk.quiz;

import java.util.*;

import static gk.quiz.Occurrences.occ;

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

            String key = token.toLowerCase();
            Occurrences occurrences = lines.get(key);

            if (occurrences == null) {
                occurrences = new Occurrences();
            }

            occurrences.add(i);

            lines.put(key, occurrences);
        }

        return lines;
    }

}

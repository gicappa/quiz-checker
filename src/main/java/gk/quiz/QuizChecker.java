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
    Map<String, QuizItem> check(String quizText) {
        Map<String, QuizItem> lines = new HashMap<>();

        StringTokenizer tokenizer = new StringTokenizer(quizText, "\n");

        for (Integer i = 1; tokenizer.hasMoreTokens(); i++) {
            String token = tokenizer.nextToken();

            checkQuizItem(token, i, lines);
        }

        return lines;
    }

    private void checkQuizItem(String quizText, Integer lineNumber, Map<String, QuizItem> lines) {
        QuizItem quizItem = lines.get(hash(quizText));

        if (quizItem == null) {
            quizItem = new QuizItem(quizText);
        }

        quizItem.addLineNumber(lineNumber);

        lines.put(hash(quizText), quizItem);
    }

    private String hash(String quizText) {
        return quizText.toLowerCase();
    }

}

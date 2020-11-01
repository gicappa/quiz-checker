package gk.quiz;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static gk.quiz.QuizItem.hash;

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
            String quizItemText = tokenizer.nextToken();

            QuizItem quizItem = lines.get(hash(quizItemText));

            if (quizItem == null) {
                quizItem = new QuizItem(quizItemText);
            }

            quizItem.addLineNumber(i);

            lines.put(quizItem.hash(), quizItem);
        }

        return lines;
    }


}

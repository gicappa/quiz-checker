package gk.quiz;

import java.util.Map;

import static java.util.stream.Collectors.joining;

class QuizResult {
    String format(Map<String, QuizItem> resultingHash) {
        String result = resultingHash.values().stream()
                .filter(QuizItem::hasDuplicates)
                .map(QuizItem::toString)
                .sorted()
                .collect(joining("\n"));

        return result.isBlank() ? "no matches found" : result;
    }

    void display(Map<String, QuizItem> resultingHash) {
        System.out.println(format(resultingHash));
    }

}

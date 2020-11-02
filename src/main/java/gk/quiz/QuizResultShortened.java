package gk.quiz;

import java.util.Map;

import static java.util.stream.Collectors.joining;

/**
 * Display the results
 */
class QuizResultShortened implements QuizResult {

    @Override
    public void display(Map<String, QuizItem> resultsMap) {
        System.out.println(format(resultsMap));
    }

    String format(Map<String, QuizItem> resultingHash) {
        String result = resultingHash.values().stream()
                .filter(QuizItem::hasDuplicates)
                .map(QuizItem::toString)
                .sorted()
                .collect(joining("\n"));

        return result.isBlank() ? "no matches found" : result;
    }

    private String shortenLine(String s) {
        return s.length() > 30 ? s.substring(0, 50) + "..." : s;
    }

}

package gk.quiz;

import java.util.Map;

import static java.util.stream.Collectors.joining;

/**
 * Display the results
 */
class QuizResultDefault implements QuizResult {

    @Override
    public void display(Map<String, QuizItem> resultsMap) {
        System.out.println(format(resultsMap));
    }

    /**
     * @param resultingHash the hash to be transformed into a string
     * @return a string representing the hash
     */
    String format(Map<String, QuizItem> resultingHash) {
        String result = resultingHash.values().stream()
                .filter(QuizItem::hasDuplicates)
                .map(QuizItem::toString)
                .map(this::shortenLine)
                .sorted()
                .collect(joining("\n"));

        return result.isBlank() ? "no matches found" : result;
    }

    private String shortenLine(String s) {
        return s.length() > 30 ? s.substring(0, 50) + "..." : s;
    }

}

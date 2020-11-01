package gk.quiz;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.joining;

class QuizResult {
    String format(Map<String, List<Integer>> resultingHash) {
        String result = resultingHash.entrySet().stream()
                .filter(e -> e.getValue().size() > 1)
                .map(m -> m.getKey() + m.getValue())
                .sorted()
                .collect(joining("\n"));

        return result.isBlank() ? "no matches found" : result;
    }

    void display(Map<String, List<Integer>> resultingHash) {
        System.out.println(format(resultingHash));
    }

}
package gk.quiz;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.joining;

/**
 * Hello world!
 */
public class CheckerApp {
    public static void main(String[] args) throws IOException {
        CheckerApp checkerApp = new CheckerApp();
        String inputFile = new FileQuiz().readFile(args[0]);
        System.out.println(checkerApp.result(new QuizChecker().check(inputFile)));
    }

    public String result(Map<String, List<Integer>> resultingHash) {
        String result = resultingHash.entrySet().stream()
                .filter(e -> e.getValue().size() > 1)
                .map(m -> m.getKey() + m.getValue())
                .sorted()
                .collect(joining("\n"));

        return result.isBlank() ? "no matches found" : result;

    }
}

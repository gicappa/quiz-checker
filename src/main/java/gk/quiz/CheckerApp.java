package gk.quiz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.util.stream.Collectors.joining;

/**
 * Hello world!
 */
public class CheckerApp {
    public static void main(String[] args) throws IOException {
        String inputFile = Files.readString(Paths.get(args[0]));
        CheckerApp checkerApp = new CheckerApp();
        System.out.println(checkerApp.result(checkerApp.check(inputFile)));
    }

    public Map<String, List<Integer>> check(String quizText) {
        HashMap<String, List<Integer>> lines = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(quizText);
        for (Integer i = 1; tokenizer.hasMoreTokens(); i++) {
            String token = tokenizer.nextToken();
            List<Integer> occurrences = lines.get(token);

            if (occurrences == null) {
                occurrences = new ArrayList<>(1);
            }

            occurrences.add(i);
            lines.put(token, occurrences);
        }
        return lines;
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

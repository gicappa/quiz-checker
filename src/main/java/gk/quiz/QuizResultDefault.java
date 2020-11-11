package gk.quiz;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static java.util.stream.Collectors.joining;

/**
 * Display the results
 */
class QuizResultDefault implements QuizResult {

    @Override
    public void display(Map<String, QuizItem> resultsMap) {
        var writer = new OutputStreamWriter(System.out);
        try {
            writer.write(format(resultsMap));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param resultingHash the hash to be transformed into a string
     * @return a string representing the hash
     */
    String format(Map<String, QuizItem> resultingHash) {
        String result = resultingHash.values().stream()
                .filter(QuizItem::hasDuplicates)
                .map(QuizItem::toString)
                .sorted()
                .collect(joining("\n"));

        return result.isBlank() ? "no matches found" : result;
    }
}

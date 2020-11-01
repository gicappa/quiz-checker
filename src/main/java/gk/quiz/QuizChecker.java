package gk.quiz;

import java.util.*;

class QuizChecker {
    Map<String, List<Integer>> check(String quizText) {
        HashMap<String, List<Integer>> lines = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(quizText, "\n");
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

}

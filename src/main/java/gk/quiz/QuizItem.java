package gk.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * A quiz line
 */
public class QuizItem {
    private final ArrayList<Integer> lineNumbers;

    private final String quizText;

    public QuizItem(String quizText) {
        lineNumbers = new ArrayList<>();
        this.quizText = quizText;
    }

    public void addLineNumber(Integer lineNumber) {
        lineNumbers.add(lineNumber);
    }

    public boolean hasDuplicates() {
        return lineNumbers.size() > 1;
    }

    public String hash() {
        return hash(quizText);
    }

    public static String hash(String text) {
        return text.toLowerCase()
                .replaceAll("[^a-z\\d]", "");
    }

    public ArrayList<Integer> getLineNumbers() {
        return lineNumbers;
    }

    public String getQuizText() {
        return quizText;
    }

    @Override
    public String toString() {
        return quizText + lineNumbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuizItem that = (QuizItem) o;
        return Objects.equals(lineNumbers, that.lineNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineNumbers);
    }

    public static QuizItem quiz(String text,Integer... lineNumbers) {
        QuizItem item = new QuizItem(text);
        Arrays.stream(lineNumbers).forEach(item::addLineNumber);
        return item;
    }
}

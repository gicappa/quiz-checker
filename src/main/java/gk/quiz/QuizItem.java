package gk.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class QuizItem {
    private final ArrayList<Integer> lineNumbers;
    private final String quizText;

    public QuizItem(String quizText) {
        lineNumbers = new ArrayList<>();
        this.quizText = quizText;
    }

    public static QuizItem occ(Integer... lineNumbers) {
        QuizItem occurrences = new QuizItem();
        Arrays.stream(lineNumbers).forEach(occurrences::addLineNumber);
        return occurrences;
    }

    public QuizItem() {
        quizText = "";
        lineNumbers = new ArrayList<>();
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
        return text.toLowerCase();
    }

    @Override
    public String toString() {
        return lineNumbers.toString();
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
}

package gk.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Occurrences {
    private final ArrayList<Integer> lineNumbers;

    public static Occurrences occ(Integer... lineNumbers) {
        Occurrences occurrences = new Occurrences();
        Arrays.stream(lineNumbers).forEach(occurrences::add);
        return occurrences;
    }

    public Occurrences() {
        lineNumbers = new ArrayList<>();
    }

    public void add(Integer lineNumber) {
        lineNumbers.add(lineNumber);
    }

    public boolean hasDuplicates() {
        return lineNumbers.size() > 1;
    }

    @Override
    public String toString() {
        return lineNumbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Occurrences that = (Occurrences) o;
        return Objects.equals(lineNumbers, that.lineNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineNumbers);
    }
}

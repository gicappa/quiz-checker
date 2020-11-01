package gk.quiz;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class QuizResultTest {

    private QuizResult result;

    @Before
    public void before() {
        result = new QuizResult();
    }

    @Test
    public void it_summarize_a_no_result() {
        Map<String, List<Integer>> noMatch =
                Map.of("no match one", List.of(3), "no match two", List.of(2));

        assertThat(result.format(noMatch), is("no matches found"));
    }

    @Test
    public void it_summarize_one_result() {
        Map<String, List<Integer>> oneMatch =
                Map.of("no match one", List.of(3),
                        "this match", List.of(1, 4),
                        "no match two", List.of(2));

        assertThat(result.format(oneMatch), is("this match[1, 4]"));
    }

    @Test
    public void it_summarize_two_result() {
        Map<String, List<Integer>> oneMatch =
                Map.of("no match one", List.of(3),
                        "this match", List.of(1, 4),
                        "no match two", List.of(2),
                        "another match", List.of(5, 6));

        assertThat(result.format(oneMatch), is("another match[5, 6]\nthis match[1, 4]"));
    }

}

package gk.quiz;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import static gk.quiz.QuizItem.quiz;
import static java.util.stream.Collectors.toMap;
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
        Map<String, QuizItem> noMatch =
                quizItems(quiz("no match one", 3),
                        quiz("no match two", 2));

        assertThat(result.format(noMatch), is("no matches found"));
    }

    @Test
    public void it_summarize_one_result() {
        Map<String, QuizItem> oneMatch =
                quizItems(quiz("no match one", 3),
                        quiz("this match", 1, 4),
                        quiz("no match two", 2));

        assertThat(result.format(oneMatch), is("this match[1, 4]"));
    }

    @Test
    public void it_summarize_two_result() {
        Map<String, QuizItem> oneMatch =
                quizItems(quiz("no match one", 3),
                        quiz("this match", 1, 4),
                        quiz("no match two", 2),
                        quiz("another match", 5, 6));

        assertThat(result.format(oneMatch), is("another match[5, 6]\nthis match[1, 4]"));
    }

    private Map<String, QuizItem> quizItems(QuizItem... items) {
        return Arrays.stream(items).collect(toMap(QuizItem::hash, Function.identity()));
    }

}

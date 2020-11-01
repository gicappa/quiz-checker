package gk.quiz;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CheckerAppTest {

    private static final String QUIZ_TEXT_NO_DUP = "abc\ncdf\njoy";
    private static final String QUIZ_TEXT_ONE_DUP = "abc\ncdf\njoy\ncdf";
    private static final String QUIZ_SENTENCES_ONE_DUP = "I am\nyou are\nI am\nhe is";

    private CheckerApp checker;

    @Before
    public void before() {
        checker = new CheckerApp();
    }

    @Test
    public void it_finds_no_duplicate_lines() {
        assertThat(new QuizChecker().check(QUIZ_TEXT_NO_DUP), hasEntry("abc", List.of(1)));
        assertThat(new QuizChecker().check(QUIZ_TEXT_NO_DUP), hasEntry("cdf", List.of(2)));
        assertThat(new QuizChecker().check(QUIZ_TEXT_NO_DUP), hasEntry("joy", List.of(3)));
    }

    @Test
    public void it_finds_a_duplicate_lines() {
        assertThat(new QuizChecker().check(QUIZ_TEXT_ONE_DUP), hasEntry("abc", List.of(1)));
        assertThat(new QuizChecker().check(QUIZ_TEXT_ONE_DUP), hasEntry("cdf", List.of(2, 4)));
        assertThat(new QuizChecker().check(QUIZ_TEXT_ONE_DUP), hasEntry("joy", List.of(3)));
    }

    @Test
    public void it_finds_a_duplicate_lines_on_a_file_with_sentences() {
        assertThat(new QuizChecker().check(QUIZ_SENTENCES_ONE_DUP), hasEntry("I am", List.of(1,3)));
        assertThat(new QuizChecker().check(QUIZ_SENTENCES_ONE_DUP), hasEntry("you are", List.of(2)));
        assertThat(new QuizChecker().check(QUIZ_SENTENCES_ONE_DUP), hasEntry("he is", List.of(4)));
    }

    @Test
    public void it_summarize_a_no_result() {
        Map<String, List<Integer>> noMatch =
                Map.of("no match one", List.of(3), "no match two", List.of(2));

        assertThat(checker.result(noMatch), is("no matches found"));
    }

    @Test
    public void it_summarize_one_result() {
        Map<String, List<Integer>> oneMatch =
                Map.of("no match one", List.of(3),
                        "this match", List.of(1, 4),
                        "no match two", List.of(2));

        assertThat(checker.result(oneMatch), is("this match[1, 4]"));
    }

    @Test
    public void it_summarize_two_result() {
        Map<String, List<Integer>> oneMatch =
                Map.of("no match one", List.of(3),
                        "this match", List.of(1, 4),
                        "no match two", List.of(2),
                        "another match", List.of(5, 6));

        assertThat(checker.result(oneMatch), is("another match[5, 6]\nthis match[1, 4]"));
    }

}

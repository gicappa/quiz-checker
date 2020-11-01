package gk.quiz;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class QuizCheckerTest {

    private static final String QUIZ_TEXT_NO_DUP = "abc\ncdf\njoy";
    private static final String QUIZ_TEXT_ONE_DUP = "abc\ncdf\njoy\ncdf";
    private static final String QUIZ_SENTENCES_ONE_DUP = "I am\nyou are\nI am\nhe is";
    private QuizChecker checker;

    @Before
    public void before() {
        checker = new QuizChecker();
    }

    @Test
    public void it_finds_no_duplicate_lines() {
        assertThat(checker.check(QUIZ_TEXT_NO_DUP), hasEntry("abc", List.of(1)));
        assertThat(checker.check(QUIZ_TEXT_NO_DUP), hasEntry("cdf", List.of(2)));
        assertThat(checker.check(QUIZ_TEXT_NO_DUP), hasEntry("joy", List.of(3)));
    }

    @Test
    public void it_finds_a_duplicate_lines() {
        assertThat(checker.check(QUIZ_TEXT_ONE_DUP), hasEntry("abc", List.of(1)));
        assertThat(checker.check(QUIZ_TEXT_ONE_DUP), hasEntry("cdf", List.of(2, 4)));
        assertThat(checker.check(QUIZ_TEXT_ONE_DUP), hasEntry("joy", List.of(3)));
    }

    @Test
    public void it_finds_a_duplicate_lines_on_a_file_with_sentences() {
        assertThat(checker.check(QUIZ_SENTENCES_ONE_DUP), hasEntry("I am", List.of(1,3)));
        assertThat(checker.check(QUIZ_SENTENCES_ONE_DUP), hasEntry("you are", List.of(2)));
        assertThat(checker.check(QUIZ_SENTENCES_ONE_DUP), hasEntry("he is", List.of(4)));
    }
}
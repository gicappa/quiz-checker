package gk.quiz;

import org.junit.Before;
import org.junit.Test;

import static gk.quiz.QuizItem.occ;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
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
        assertThat(checker.check(QUIZ_TEXT_NO_DUP), hasEntry("abc", occ(1)));
        assertThat(checker.check(QUIZ_TEXT_NO_DUP), hasEntry("cdf", occ(2)));
        assertThat(checker.check(QUIZ_TEXT_NO_DUP), hasEntry("joy", occ(3)));
    }

    @Test
    public void it_finds_a_duplicate_lines() {
        assertThat(checker.check(QUIZ_TEXT_ONE_DUP), hasEntry("abc", occ(1)));
        assertThat(checker.check(QUIZ_TEXT_ONE_DUP), hasEntry("cdf", occ(2, 4)));
        assertThat(checker.check(QUIZ_TEXT_ONE_DUP), hasEntry("joy", occ(3)));
    }

    @Test
    public void it_finds_a_duplicate_lines_on_a_file_with_sentences() {
        assertThat(checker.check(QUIZ_SENTENCES_ONE_DUP), hasEntry("i am", occ(1, 3)));
        assertThat(checker.check(QUIZ_SENTENCES_ONE_DUP), hasEntry("you are", occ(2)));
        assertThat(checker.check(QUIZ_SENTENCES_ONE_DUP), hasEntry("he is", occ(4)));
    }

    @Test
    public void it_disregards_case_of_the_sentence() {
        String quizzes = "my Duplicate\nMy dupliCate\nNot a duplicate";
        assertThat(checker.check(quizzes), hasEntry("my duplicate", occ(1, 2)));
        assertThat(checker.check(quizzes), hasEntry("not a duplicate", occ(3)));
    }
}

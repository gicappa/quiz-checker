package gk.quiz;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static gk.quiz.QuizItem.quiz;
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
        assertThat(checker.check(QUIZ_TEXT_NO_DUP), hasItem(quiz("abc", 1)));
        assertThat(checker.check(QUIZ_TEXT_NO_DUP), hasItem(quiz("cdf", 2)));
        assertThat(checker.check(QUIZ_TEXT_NO_DUP), hasItem(quiz("joy", 3)));
    }

    @Test
    public void it_finds_a_duplicate_lines() {
        assertThat(checker.check(QUIZ_TEXT_ONE_DUP), hasItem(quiz("abc", 1)));
        assertThat(checker.check(QUIZ_TEXT_ONE_DUP), hasItem(quiz("cdf", 2, 4)));
        assertThat(checker.check(QUIZ_TEXT_ONE_DUP), hasItem(quiz("joy", 3)));
    }

    @Test
    public void it_finds_a_duplicate_lines_on_a_file_with_sentences() {
        assertThat(checker.check(QUIZ_SENTENCES_ONE_DUP), hasItem(quiz("iam", 1, 3)));
        assertThat(checker.check(QUIZ_SENTENCES_ONE_DUP), hasItem(quiz("youare", 2)));
        assertThat(checker.check(QUIZ_SENTENCES_ONE_DUP), hasItem(quiz("heis", 4)));
    }

    @Test
    public void it_disregards_case_of_the_sentence() {
        String quizzes = "my Duplicate\nMy dupliCate\nNot a duplicate";
        assertThat(checker.check(quizzes), hasItem(quiz("myduplicate", 1, 2)));
        assertThat(checker.check(quizzes), hasItem(quiz("notaduplicate", 3)));
    }

    @Test
    public void it_disregards_difference_in_spaces_of_a_sentence() {
        String quizzes = "my Du pli cate\nMy d upli Ca te\nNot a duplicate";
        assertThat(checker.check(quizzes), hasItem(quiz("myduplicate", 1, 2)));
        assertThat(checker.check(quizzes), hasItem(quiz("notaduplicate", 3)));
    }


    @Test
    public void it_disregards_difference_in_symbols() {
        String quizzes = "my, Du pli cate1\nMy.. d; up';\"li Ca te1\nNot a duplicate";
        assertThat(checker.check(quizzes), hasItem(quiz("myduplicate1", 1, 2)));
        assertThat(checker.check(quizzes), hasItem(quiz("notaduplicate", 3)));
    }

    // Matcher
    private static Matcher<Map<String, QuizItem>> hasItem(QuizItem expectedItem) {
        return new BaseMatcher<>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("checks quiz item to have line numbers");
            }

            @SuppressWarnings("unchecked")
            @Override
            public boolean matches(Object o) {
                Map<String, QuizItem> lines = (Map<String, QuizItem>) o;
                QuizItem actualItem = lines.get(expectedItem.hash());
                return expectedItem.equals(actualItem);
            }
        };
    }

}

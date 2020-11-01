package gk.quiz;

import org.junit.Test;

import static gk.quiz.QuizItem.quiz;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class QuizItemTest {
    @Test
    public void it_adds_one_occurrence() {
        QuizItem expected = new QuizItem("text");
        expected.addLineNumber(2);

        assertThat(quiz("text", 2), equalTo(expected));
    }
}

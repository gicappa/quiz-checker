package gk.quiz;

import org.junit.Test;

import static gk.quiz.QuizItem.occ;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class OccurrencesTest {
    @Test
    public void it_adds_one_occurrence() {
        QuizItem expected = new QuizItem();
        expected.addLineNumber(2);

        assertThat(occ(2), equalTo(expected));
    }
}

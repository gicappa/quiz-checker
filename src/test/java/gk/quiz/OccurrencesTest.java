package gk.quiz;

import org.junit.Test;

import static gk.quiz.Occurrences.occ;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class OccurrencesTest {
    @Test
    public void it_adds_one_occurrence() {
        Occurrences expected = new Occurrences();
        expected.add(2);

        assertThat(occ(2), equalTo(expected));
    }
}

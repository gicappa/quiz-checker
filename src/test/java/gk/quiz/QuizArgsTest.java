package gk.quiz;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class QuizArgsTest {
    @Test(expected = CheckerException.class)
    public void it_throws_an_exception_if_no_arg_is_passed() {
        QuizArgs quizArgs = new QuizArgs();

        quizArgs.getFileName();
    }

    @Test
    public void it_doesnt_throw_an_exception_if_one_arg_is_passed() {
        try {
            QuizArgs quizArgs = new QuizArgs("one");
            quizArgs.getFileName();
        } catch (Exception e) {
            fail("It should not throw an exception when one argument is passed to the command line");
        }
    }

    @Test
    public void it_should_return_the_first_arg_as_file_name() {
            QuizArgs quizArgs = new QuizArgs("one");

            assertThat(quizArgs.getFileName(), is("one"));
    }

    @Test(expected = CheckerException.class)
    public void it_throws_an_exception_if_more_than_one_arg_is_passed() {
        QuizArgs quizArgs = new QuizArgs("one", "two", "three");

        quizArgs.getFileName();
    }
}

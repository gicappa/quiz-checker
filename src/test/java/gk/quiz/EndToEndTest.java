package gk.quiz;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EndToEndTest {
    @Test
    public void it_load_an_input_and_displays_an_output() {

        assertThat(captureOutput(() -> {
            CheckerApp app = new CheckerApp("src/main/resources/simple-input.txt");
            app.run();
        }), is("a repeated line[2, 4]\n"));
    }

    private String captureOutput(Runnable function) {
        final ByteArrayOutputStream stdout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdout));

        function.run();

        return stdout.toString();
    }
}

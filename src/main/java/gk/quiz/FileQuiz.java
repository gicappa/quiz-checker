package gk.quiz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Abstraction to wrap the file containing the quiz
 */
class FileQuiz {
    String loadData(String arg) throws IOException {
        return Files.readString(Paths.get(arg));
    }

}

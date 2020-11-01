package gk.quiz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class FileQuiz {
    String loadData(String arg) throws IOException {
        return Files.readString(Paths.get(arg));
    }

}

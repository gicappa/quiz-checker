package gk.quiz;

import java.io.IOException;

/**
 * This is the entry point of the application that takes the
 * quiz file name as an argument and display the result
 * in standard output
 */
public class CheckerApp {

    /**
     * @param args in the first argument it holds the filename
     * @throws IOException in the case the file is not found or can't be opened
     */
    public static void main(String[] args) throws IOException {
        String inputFile = new FileQuiz().readFile(args[0]);
        System.out.println(new QuizResult().result(new QuizChecker().check(inputFile)));
    }

}

package gk.quiz;

/**
 * This is the entry point of the application that takes the
 * quiz file name as an argument and display the result
 * in standard output
 */
public class CheckerApp implements Runnable {

    private static String fileName;

    /**
     * @param args in the first argument it holds the filename
     */
    public static void main(String[] args) {
        fileName = args[0];
        new CheckerApp().run();
    }

    public void run() {
        try {
            FileQuiz fileQuiz = new FileQuiz();
            QuizResult quizResult = new QuizResult();
            QuizChecker quizChecker = new QuizChecker();

            quizResult.display(quizChecker.check(fileQuiz.readFile(fileName)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

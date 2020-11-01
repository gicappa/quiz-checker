package gk.quiz;

/**
 * This is the entry point of the application that takes the
 * quiz file name as an argument and display the result
 * in standard output
 */
public class CheckerApp implements Runnable {

    private String fileName;

    public CheckerApp(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @param args in the first argument it holds the filename
     */
    public static void main(String[] args) {
        new CheckerApp(args[0]).run();
    }

    /**
     * Launches the application to:
     * - load data
     * - run the checker
     * - display the result
     */
    public void run() {
        try {
            FileQuiz fileQuiz = new FileQuiz();
            QuizResult quizResult = new QuizResult();
            QuizChecker quizChecker = new QuizChecker();

            quizResult.display(quizChecker.check(fileQuiz.loadData(fileName)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
